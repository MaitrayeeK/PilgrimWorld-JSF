/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.auth;

import com.pilgrim.helper.SecurityData;
import com.pilgrim.clients.AuthClient;
import com.pilgrim.helper.JWTConstants;
import com.pilgrim.helper.Response;
import com.pilgrim.models.UserMaster;
import com.pilgrim.record.KeepRecord;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;

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

    public SecureAuthentication() {
        authClient = new AuthClient();
        gresSecurityData = new GenericType<Response<SecurityData>>() {
        };
        resSecurityData = new Response<>();
    }

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) throws AuthenticationException {

        System.out.println("in ValidateRequest!");
        //extracting token
        String token = extractToken(context);

        try {

            if (token == null && request.getParameter("username") != null) {

                String username = request.getParameter("username");
                String password = request.getParameter("password");

                securityData = new SecurityData(new UserMaster(username, password));
//                Request<SecurityData> reqSecurityData = new Request<>();
//                reqSecurityData.setData(securityData);

                res = authClient.validateUser(securityData, javax.ws.rs.core.Response.class);
                System.out.println("frontend after client call : ");
                resSecurityData = res.readEntity(gresSecurityData);
                System.out.println("frontend after client read entity : ");

                securityData = resSecurityData.getResult();

                System.out.println("In validateRequest()");

                if (securityData.getStatus() == Status.VALID) {

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
                    KeepRecord.setPrincipal(result.getCallerPrincipal());
                    KeepRecord.setRoles(result.getCallerGroups());
                    KeepRecord.setToken(securityData.getToken());
                    KeepRecord.setUsername(username);
                    KeepRecord.setPassword(password);

                    if (result.getCallerGroups().contains("User")) {
                        response.sendRedirect("index.jsf");
                    }
                    return status;
                } else {
                    KeepRecord.setErrorStatus(resSecurityData.getMessage());
                    response.sendRedirect("signin.jsf");
                    return context.doNothing();
                }
            }
            
            if(KeepRecord.getToken() != null) {
                System.out.println("KeepRecord Token: " + KeepRecord.getToken());
                return context.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (token != null) {

            System.out.println("Token is not null: " + token);

            securityData = new SecurityData(token);

            res = authClient.validateUser(securityData, javax.ws.rs.core.Response.class);
            System.out.println("frontend after client call : ");
            resSecurityData = res.readEntity(gresSecurityData);
            System.out.println("frontend after client read entity : ");

            if (resSecurityData.isStatus()) {
                System.out.println("Token is validated!!");
                securityData = resSecurityData.getResult();
                System.out.println("Validated Credential: " + securityData.getCredential());
                return context.notifyContainerAboutLogin(securityData.getCredential().getPrincipal(), securityData.getCredential().getAuthorities());
            } else {
                System.out.println("Token is not validated!!");
                return context.responseUnauthorized();
            }
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
