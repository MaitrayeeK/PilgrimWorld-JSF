/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pilgrim.helper;

import com.pligrim.models.UserMaster;
import java.io.Serializable;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;

/**
 *
 * @author Dell
 */
public class SecurityData implements Serializable {
    
    private Status status;
    private String token;
    private UserMaster user;
    private long credentialValidity;
    private boolean rememberMe;
    
    public SecurityData() {
    }

    public SecurityData(Status status, String token, UserMaster user, JWTCredential credential) {
        this.status = status;
        this.token = token;
        this.user = user;
    }

    public SecurityData(String token) {
        this.token = token;
    }

    public SecurityData(UserMaster user, boolean rememberMe) {
        this.user = user;
        this.rememberMe = rememberMe;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }

    public long getCredentialValidity() {
        return credentialValidity;
    }

    public void setCredentialValidity(long credentialValidity) {
        this.credentialValidity = credentialValidity;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
