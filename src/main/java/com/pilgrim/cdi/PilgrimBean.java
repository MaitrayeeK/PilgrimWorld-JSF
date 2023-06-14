/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.ClientsClient;
import com.pilgrim.helper.Response;
import com.pilgrim.clients.Client;
import com.pilgrim.helper.Request;
import com.pligrim.models.PilgrimImages;
import com.pligrim.models.PilgrimMaster;
import com.pligrim.models.PilgrimTickets;
import com.pligrim.models.PilgrimTimeslots;
import com.pligrim.models.PilgrimTimeslotsDetails;
import com.pligrim.models.UserMaster;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import org.primefaces.event.SelectEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;

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

    PilgrimMaster pilgrimMaster;
    PilgrimImages pilgrimImages;
    PilgrimTimeslots pilgrimTimeslots;
    PilgrimTimeslotsDetails pilgrimTimeslotsDetails;
    PilgrimTickets pilgrimTickets;
    UploadedFile mainfile;
    UploadedFiles subfiles;
    ArrayList<String> pilgrimImageList = new ArrayList<>();
    Client client1;
    Integer cityId; 

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

    public void addTimeslots() {
        timeslots++;
    }
}
