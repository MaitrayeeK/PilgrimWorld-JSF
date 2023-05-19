/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.client.AdminClient;
import com.pilgrim.helper.Response;
import com.pligrim.models.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import org.primefaces.util.LangUtils;

/**
 *
 * @author Dell
 */
@Named(value = "usersDisplayBean")
@SessionScoped
public class UsersDisplayBean implements Serializable {

    javax.ws.rs.core.Response response;
    AdminClient adminClient;

    Response<Collection<UserMaster>> resUsers;
    GenericType<Response<Collection<UserMaster>>> gresUsers;
    
    Collection<UserMaster> users;
    UserMaster selectedUser;
    Collection<UserMaster> filteredUsers;

    public UsersDisplayBean() {
        adminClient = new AdminClient();
        resUsers = new Response<>();
        gresUsers = new GenericType<Response<Collection<UserMaster>>>() {
        };
        users = new ArrayList<>();
        selectedUser = new UserMaster();
        filteredUsers = new ArrayList<>();
    }

    public UserMaster getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserMaster selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Response<Collection<UserMaster>> getResUsers() {
        return resUsers;
    }

    public void setResUsers(Response<Collection<UserMaster>> resUsers) {
        this.resUsers = resUsers;
    }

    public Collection<UserMaster> getUsers() {
        response = adminClient.getUserByGroup(javax.ws.rs.core.Response.class, String.valueOf(6));
        resUsers = response.readEntity(gresUsers);
        users = resUsers.getResult();
        return users;
    }

    public void setUsers(Collection<UserMaster> users) {
        this.users = users;
    }

    public Collection<UserMaster> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(Collection<UserMaster> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }
}
