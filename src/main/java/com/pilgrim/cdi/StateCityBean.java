/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.AdminClient;
import com.pilgrim.helper.Response;
import com.pligrim.models.CityMaster;
import com.pligrim.models.StateMaster;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.SessionMap;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author maitr
 */
@Named(value = "stateCityBean")
@SessionScoped
public class StateCityBean implements Serializable{

    AdminClient client;
    javax.ws.rs.core.Response response;
    
    Response<Collection<StateMaster>> resStates;
    GenericType<Response<Collection<StateMaster>>> gresStates;
    Response<Collection<CityMaster>> resCities;
    GenericType<Response<Collection<CityMaster>>> gresCities;

    Collection<StateMaster> states;
    Collection<CityMaster> cities;

    Integer stateid;
    Integer cityid;

    public StateCityBean() {
        client = new AdminClient();
        gresStates = new GenericType<Response<Collection<StateMaster>>>() {
        };
        gresCities = new GenericType<Response<Collection<CityMaster>>>() {
        };
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
    
    public void onStateChange(Integer stateid) {
        if (stateid != null && !stateid.equals("")) {
            response = client.getAllCitiesByState(javax.ws.rs.core.Response.class, String.valueOf(stateid));
            resCities = response.readEntity(gresCities);
            cities = (List<CityMaster>) resCities.getResult();
        } else {
            cities = new ArrayList<CityMaster>();
        }
    }
    
}
