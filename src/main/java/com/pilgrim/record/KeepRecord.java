/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.record;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.credential.Credential;

/**
 *
 * @author Dell
 */
@SessionScoped
public class KeepRecord implements Serializable {
    
    private static Credential credential;
    private static CallerPrincipal principal;
    private static Set<String> roles;
    private static String errorStatus;
    private static String token;
    private static String username;
    private static String password;
    private static boolean isLoggedin;

    public KeepRecord() {
        credential = null;
        principal = null;
        errorStatus = "";
        token = null;
        username = null;
        password = null;
        isLoggedin = false;
    }
    
    public static void reset() {
        credential = null;
        principal = null;
        errorStatus = "";
        token = null;
        username = null;
        password = null;
        isLoggedin = false;
    }

    public static Credential getCredential() {
        return credential;
    }

    public static void setCredential(Credential credential) {
        KeepRecord.credential = credential;
    }

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        KeepRecord.principal = principal;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        KeepRecord.roles = roles;
    }

    public static String getErrorStatus() {
        return errorStatus;
    }

    public static void setErrorStatus(String errorStatus) {
        KeepRecord.errorStatus = errorStatus;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        KeepRecord.token = token;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        KeepRecord.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        KeepRecord.password = password;
    }

    public static boolean isIsLoggedin() {
        return isLoggedin;
    }

    public static void setIsLoggedin(boolean isLoggedin) {
        KeepRecord.isLoggedin = isLoggedin;
    }
    
    
    
}
