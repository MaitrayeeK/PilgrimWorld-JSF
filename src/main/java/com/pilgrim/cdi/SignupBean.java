/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.client.AdminClient;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;
import com.pligrim.models.CityMaster;
import com.pligrim.models.GroupMaster;
import com.pligrim.models.StateMaster;
import com.pligrim.models.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author maitr
 */
@Named(value = "signupBean")
@SessionScoped
public class SignupBean implements Serializable {

    AdminClient client;
    javax.ws.rs.core.Response response;
    Response response1;

    Response<Collection<StateMaster>> resStates;
    GenericType<Response<Collection<StateMaster>>> gresStates;
    Response<Collection<CityMaster>> resCities;
    GenericType<Response<Collection<CityMaster>>> gresCities;
    GenericType<Response> gresponse1;

    Collection<StateMaster> states;
    Collection<CityMaster> cities;

    String name, uname, email, password, address;
    Integer stateid;
    Integer cityid;

    public SignupBean() {
        client = new AdminClient();
        gresStates = new GenericType<Response<Collection<StateMaster>>>() {
        };
        gresCities = new GenericType<Response<Collection<CityMaster>>>() {
        };
        gresponse1 = new GenericType<Response>(){};
    }
    
     public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Response<Collection<StateMaster>> getResStates() {
        return resStates;
    }

    public Collection<StateMaster> getStates() {
        response = client.getAllState(javax.ws.rs.core.Response.class);
        resStates = response.readEntity(gresStates);
        states = (Collection<StateMaster>) resStates.getResult();
        return states;
    }

    public void setStates(Collection<StateMaster> states) {
        this.states = states;
    }

    public void setResStates(Response<Collection<StateMaster>> resStates) {
        this.resStates = resStates;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Response<Collection<CityMaster>> getResCities() {
        return resCities;
    }

    public void setResCities(Response<Collection<CityMaster>> resCities) {
        this.resCities = resCities;
    }

    public Collection<CityMaster> getCities() {
        return cities;
    }

    public void setCities(Collection<CityMaster> cities) {
        this.cities = cities;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void onStateChange() {
        if (stateid != null && !stateid.equals("")) {
            response = client.getAllCitiesByState(javax.ws.rs.core.Response.class, String.valueOf(stateid));
            resCities = response.readEntity(gresCities);
            cities = (List<CityMaster>) resCities.getResult();
        } else {
            cities = new ArrayList<CityMaster>();
        }
    }

    public void onSubmit() {
        Request req = new Request();
        UserMaster user = new UserMaster();
        user.setFirstname(name.split(" ")[0]);
        user.setLastname(name.split(" ")[1]);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setUsername(uname);
        StateMaster state = new StateMaster();
        state.setStateId(stateid);
        user.setState(state);
        GroupMaster group = new GroupMaster();
        group.setGroupId(6);
        user.setGroup(group);
        CityMaster city = new CityMaster();
        city.setCityId(cityid);
        user.setCity(city);

        req.setData(user);
        System.out.println("name " + name);
        System.out.println("cdi " + req.getData());
        response = client.adduser(req, javax.ws.rs.core.Response.class);
        response1 = response.readEntity(gresStates);
        if(response1.isStatus()){
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Registration completed! Login to continue.");
//            return "signin.jsf";
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Registration not completed! ");
        }
    }
}
