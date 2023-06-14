/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.ClientsClient;
import com.pilgrim.helper.Response;
import com.pligrim.models.PilgrimMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author maitr
 */
@Named(value = "pilgrimBean")
@SessionScoped
public class PilgrimBean implements Serializable {

    javax.ws.rs.core.Response response;
    ClientsClient client;

    Response<Collection<PilgrimMaster>> respilgrims;
    GenericType<Response<Collection<PilgrimMaster>>> grespilgrims;
    Collection<PilgrimMaster> pilgrims;
    
    int timeslotType;
    int timeslots;
    ArrayList weekdays = new ArrayList<>();
    
    public PilgrimBean() {
        client = new ClientsClient();
        grespilgrims = new GenericType<Response<Collection<PilgrimMaster>>>() {
        };
        pilgrims = new ArrayList<>();

        weekdays.add("Sunday");
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");
    }

    public Collection<PilgrimMaster> getPilgrims() {
        response = client.getPilgrims(javax.ws.rs.core.Response.class);
        respilgrims = response.readEntity(grespilgrims);
        pilgrims = respilgrims.getResult();
        return pilgrims;
    }

    public void setPilgrims(Collection<PilgrimMaster> pilgrims) {
        this.pilgrims = pilgrims;
    }

    public int getTimeslotType() {
        return timeslotType;
    }

    public void setTimeslotType(int timeslotType) {
        this.timeslotType = timeslotType;
    }

    public int getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(int timeslots) {
        this.timeslots = timeslots;
    }

    public ArrayList getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(ArrayList weekdays) {
        this.weekdays = weekdays;
    }

    public void addTimeslots() {
        timeslots++;
    }
}
