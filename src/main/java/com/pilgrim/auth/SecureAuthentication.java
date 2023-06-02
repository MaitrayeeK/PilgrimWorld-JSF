/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.auth;

import com.pilgrim.helper.SecurityData;
import com.pilgrim.clients.AuthClient;
import com.pilgrim.helper.JWTConstants;
import com.pilgrim.helper.Response;
import com.pilgrim.record.KeepRecord;
import com.pligrim.models.UserMaster;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.RequestScoped;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author Dell
 */
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable {

    AuthClient authClient;
    javax.ws.rs.core.Response res;
    SecurityData securityData;

    CredentialValidationResult result;
    AuthenticationStatus status;

    Response<SecurityData> resSecurityData;
    GenericType<Response<SecurityData>> gresSecurityData;

    Pbkdf2PasswordHashImpl pb;

    public SecureAuthentication() {
        authClient = new AuthClient();
        gresSecurityData = new GenericType<Response<SecurityData>>() {
        };
        resSecurityData = new Response<>();
        pb = new Pbkdf2PasswordHashImpl();
    }

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) throws AuthenticationException {

        System.out.println("in ValidateRequest!");

        //logout
        try {
            if (request.getRequestURI().contains("logout")) {
                request.logout();
                KeepRecord.reset();

                Cookie[] cookies = request.getCookies();

                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("token")) {
                            cookie.setMaxAge(0);
                        }
                        if (cookie.getName().equals("role")) {
                            cookie.setMaxAge(0);
                        }
                    }
                }

                response.sendRedirect("signin.jsf");
                return context.doNothing();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Cookie[] cookies = request.getCookies();
        String token_cookie = null;
        String token_role = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token_cookie = cookie.getValue();
                }
                if (cookie.getName().equals("role")) {
                    token_role = cookie.getValue();
                }
            }
        }

        //checking token validity when remeber me is checked
        try {
            if (token_cookie != null) {
                if (request.getRequestURI().contains("signin.jsf")) {
                    securityData = new SecurityData(token_cookie);

                    res = authClient.validateToken(securityData, javax.ws.rs.core.Response.class);
                    System.out.println("frontend after client call : ");
                    resSecurityData = res.readEntity(gresSecurityData);
                    System.out.println("frontend after client read entity : ");

                    if (resSecurityData.isStatus()) {
                        System.out.println("Token is validated!!");
                        if (token_role.contains("Admin")) {
                            response.sendRedirect("AdminUI/index.jsf");
                        }
                        if (token_role.contains("User")) {
                            response.sendRedirect("UI/index.jsf");
                        }
                        if (token_role.contains("Client")) {
                            response.sendRedirect("ClientUI/index.jsf");
                        }
                        return context.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
                    } else {
                        System.out.println("Token is not validated!!");
                        return context.responseUnauthorized();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //extracting token
        HttpSession session = request.getSession();
        String token;
        if (null == session.getAttribute("session_token")) {
            token = null;
        } else {
            token = session.getAttribute("session_token").toString();
            System.out.println("Session Token: " + token);
        }

        try {

            System.out.println("Username: " + request.getParameter("username"));

            if (token == null && request.getParameter("username") != null) {

                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String rememberme = request.getParameter("rememberme");

                UserMaster user = new UserMaster();
                user.setUsername(username);
                user.setPassword(password);

                if (rememberme != null) {
                    securityData = new SecurityData(user, true);
                } else {
                    securityData = new SecurityData(user, false);
                }

                res = authClient.validateUser(securityData, javax.ws.rs.core.Response.class);
                System.out.println("frontend after client call : ");
                resSecurityData = res.readEntity(gresSecurityData);
                System.out.println("frontend after client read entity : ");

                securityData = resSecurityData.getResult();
                System.out.println("Credential Validity: " + TimeUnit.MILLISECONDS.toSeconds(securityData.getCredentialValidity()));

                System.out.println("In validateRequest()");

                if (securityData.getStatus() == Status.VALID) {

                    if (rememberme != null) {
                        Cookie unameCookie = new Cookie("username", username);
                        Cookie passCookie = new Cookie("password", pb.generate(password.toCharArray()));
                        Cookie tokenCookie = new Cookie("token", securityData.getToken());
                        Cookie roleCookie = new Cookie("role", securityData.getUser().getGroup().getGroupName());

                        response.addCookie(unameCookie);
                        response.addCookie(passCookie);
                        response.addCookie(tokenCookie);
                        response.addCookie(roleCookie);

                        unameCookie.setMaxAge((int) securityData.getCredentialValidity());
                        passCookie.setMaxAge((int) securityData.getCredentialValidity());
                        tokenCookie.setMaxAge((int) securityData.getCredentialValidity());
                        roleCookie.setMaxAge((int) securityData.getCredentialValidity());
                    }

                    String userRole = securityData.getUser().getGroup().getGroupName();
                    Set<String> roles = new HashSet<>();
                    roles.add(userRole);

                    result = new CredentialValidationResult(securityData.getUser().getUsername(), roles);
                    status = context.notifyContainerAboutLogin(result);

                    context.getResponse().addHeader(JWTConstants.AUTHORIZATION_HEADER, JWTConstants.BEARER + securityData.getToken());

                    System.out.println("Result Status: " + status);
                    System.out.println("Result Principal: " + result.getCallerPrincipal());
                    System.out.println("Result Groups: " + result.getCallerGroups());

                    KeepRecord.setErrorStatus("");
                    KeepRecord.setIsLoggedin(true);
                    KeepRecord.setPrincipal(result.getCallerPrincipal());
                    KeepRecord.setRoles(result.getCallerGroups());
                    KeepRecord.setToken(securityData.getToken());
                    KeepRecord.setUsername(username);
                    KeepRecord.setPassword(password);

                    session.setAttribute("session_token", securityData.getToken());

                    if (result.getCallerGroups().contains("User")) {
                        response.sendRedirect("UI/index.jsf");
                    }
                    if (result.getCallerGroups().contains("Admin")) {
                        response.sendRedirect("AdminUI/index.jsf");
                    }
                    return status;
                } else {
                    KeepRecord.setErrorStatus(resSecurityData.getMessage());
                    response.sendRedirect("signin.jsf");
                    return context.doNothing();
                }
            }

            if (token != null) {
                System.out.println("KeepRecord Token: " + KeepRecord.getToken());

                if (request.getRequestURI().contains("signin.jsf")) {
                    securityData = new SecurityData(KeepRecord.getToken());

                    res = authClient.validateToken(securityData, javax.ws.rs.core.Response.class);
                    System.out.println("frontend after client call : ");
                    resSecurityData = res.readEntity(gresSecurityData);
                    System.out.println("frontend after client read entity : ");

                    if (resSecurityData.isStatus()) {
                        System.out.println("Token is validated!!");
                        if (KeepRecord.getRoles().contains("Admin")) {
                            response.sendRedirect("AdminUI/index.jsf");
                        }
                        if (KeepRecord.getRoles().contains("User")) {
                            response.sendRedirect("UI/index.jsf");
                        }
                        if (KeepRecord.getRoles().contains("Client")) {
                            response.sendRedirect("ClientUI/index.jsf");
                        }
                        return context.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
                    } else {
                        System.out.println("Token is not validated!!");
                        return context.responseUnauthorized();
                    }
                }
//                return context.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return context.doNothing();
    }

    //for extracting token
    public String extractToken(HttpMessageContext context) {

        String authorizationHeader = context.getResponse().getHeader(JWTConstants.AUTHORIZATION_HEADER);

        if (authorizationHeader != null && authorizationHeader.startsWith(JWTConstants.BEARER)) {
            String token = authorizationHeader.substring(JWTConstants.BEARER.length(), authorizationHeader.length());
            KeepRecord.setToken(token);

            System.out.println("In SecureAuthentication - In extractToken() method!!!");
            System.out.println("Extracted Token: " + token);

            return token;
        }
        return null;
    }

}
