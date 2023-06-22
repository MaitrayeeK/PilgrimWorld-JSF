/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.AdminClient;
import com.pilgrim.clients.ClientsClient;
import com.pilgrim.helper.Response;
import com.pilgrim.helper.Request;
import com.pilgrim.record.KeepRecord;
import com.pligrim.models.PilgrimImages;
import com.pligrim.models.PilgrimMaster;
import com.pligrim.models.PilgrimRooms;
import com.pligrim.models.PilgrimTickets;
import com.pligrim.models.PilgrimTimeslots;
import com.pligrim.models.PilgrimTimeslotsDetails;
import com.pligrim.models.UserMaster;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.core.GenericType;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    AdminClient adminClient;
    PilgrimMaster pilgrimMaster;
    PilgrimImages pilgrimImages;
    PilgrimTimeslots pilgrimTimeslots;
    PilgrimTimeslotsDetails pilgrimTimeslotsDetails;
    PilgrimTickets pilgrimTickets;
    PilgrimRooms pilgrimRooms;
    UploadedFile mainfile;
    UploadedFiles subfiles;
    ArrayList<String> pilgrimImageList = new ArrayList<>();
    Integer cityId;

    int timeslotType = 1;
    int timeslots;
    ArrayList weekdays = new ArrayList<>();

    Collection<PilgrimMaster> pilgrims;
    Response<Collection<PilgrimMaster>> resPilgrims;
    GenericType<Response<Collection<PilgrimMaster>>> gresPligrims;

    Collection<PilgrimTimeslots> pilgrimTimeslotses;
    Response<Collection<PilgrimTimeslots>> rpilgrimTimeslotses;
    GenericType<Response<Collection<PilgrimTimeslots>>> grpilgrimTimeslotses;

    Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailses;
    Response<Collection<PilgrimTimeslotsDetails>> rpilgrimTimeslotsDetailses;
    GenericType<Response<Collection<PilgrimTimeslotsDetails>>> grpilgrimTimeslotsDetailses;

    Collection<PilgrimTickets> pilgrimTicketses;
    Response<Collection<PilgrimTickets>> rpilgrimTicketses;
    GenericType<Response<Collection<PilgrimTickets>>> grpilgrimTicketses;

    Collection<PilgrimRooms> pilgrimRoomses;
    Response<Collection<PilgrimRooms>> rpilgrimRoomses;
    GenericType<Response<Collection<PilgrimRooms>>> grpilgrimRoomses;

    Response<UserMaster> resUser;
    GenericType<Response<UserMaster>> gresUser;
    UserMaster loggedInUser;

    UploadedFile pilgrimImage;

    int notpilgrim = 0;

    public PilgrimBean() {
        client = new ClientsClient();
        adminClient = new AdminClient();
        pilgrimMaster = new PilgrimMaster();
        pilgrimTimeslots = new PilgrimTimeslots();
        pilgrimTimeslotsDetails = new PilgrimTimeslotsDetails();
        pilgrimTickets = new PilgrimTickets();

        weekdays.add("Sunday");
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");

        gresPligrims = new GenericType<Response<Collection<PilgrimMaster>>>() {
        };
        gresUser = new GenericType<Response<UserMaster>>() {
        };

        grpilgrimTimeslotses = new GenericType<Response<Collection<PilgrimTimeslots>>>() {
        };
        grpilgrimTimeslotsDetailses = new GenericType<Response<Collection<PilgrimTimeslotsDetails>>>() {
        };
        grpilgrimTicketses = new GenericType<Response<Collection<PilgrimTickets>>>() {
        };

        response = adminClient.getUserByUsername(javax.ws.rs.core.Response.class, KeepRecord.getUsername());
        resUser = response.readEntity(gresUser);
        loggedInUser = resUser.getResult();

        response = client.getPilgrimsByUser(javax.ws.rs.core.Response.class, String.valueOf(loggedInUser.getUserId()));
        resPilgrims = response.readEntity(gresPligrims);
        pilgrimMaster = ((ArrayList<PilgrimMaster>) resPilgrims.getResult()).get(0);
    }

    public PilgrimMaster getPilgrimMaster() {
        return pilgrimMaster;
    }

    public void setPilgrimMaster(PilgrimMaster pilgrimMaster) {
        this.pilgrimMaster = pilgrimMaster;
    }

    public PilgrimImages getPilgrimImages() {
        return pilgrimImages;
    }

    public void setPilgrimImages(PilgrimImages pilgrimImages) {
        this.pilgrimImages = pilgrimImages;
    }

    public PilgrimTimeslots getPilgrimTimeslots() {
        return pilgrimTimeslots;
    }

    public void setPilgrimTimeslots(PilgrimTimeslots pilgrimTimeslots) {
        this.pilgrimTimeslots = pilgrimTimeslots;
    }

    public PilgrimTimeslotsDetails getPilgrimTimeslotsDetails() {
        return pilgrimTimeslotsDetails;
    }

    public void setPilgrimTimeslotsDetails(PilgrimTimeslotsDetails pilgrimTimeslotsDetails) {
        this.pilgrimTimeslotsDetails = pilgrimTimeslotsDetails;
    }

    public PilgrimTickets getPilgrimTickets() {
        return pilgrimTickets;
    }

    public void setPilgrimTickets(PilgrimTickets pilgrimTickets) {
        this.pilgrimTickets = pilgrimTickets;
    }

    public UploadedFile getMainfile() {
        return mainfile;
    }

    public void setMainfile(UploadedFile mainfile) {
        this.mainfile = mainfile;
    }

    public UploadedFiles getSubfiles() {
        return subfiles;
    }

    public void setSubfiles(UploadedFiles subfiles) {
        this.subfiles = subfiles;
    }

    public ArrayList<String> getPilgrimImageList() {
        return pilgrimImageList;
    }

    public void setPilgrimImageList(ArrayList<String> pilgrimImageList) {
        this.pilgrimImageList = pilgrimImageList;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public ArrayList getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(ArrayList weekdays) {
        this.weekdays = weekdays;
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

    public void addTimeslots() {
        timeslots++;
    }

    public Response<Collection<PilgrimMaster>> getResPilgrims() {
        return resPilgrims;
    }

    public void setResPilgrims(Response<Collection<PilgrimMaster>> resPilgrims) {
        this.resPilgrims = resPilgrims;
    }

    public GenericType<Response<Collection<PilgrimMaster>>> getGresPligrims() {
        return gresPligrims;
    }

    public void setGresPligrims(GenericType<Response<Collection<PilgrimMaster>>> gresPligrims) {
        this.gresPligrims = gresPligrims;
    }

    public Collection<PilgrimMaster> getPilgrims() {
        response = client.getPilgrims(javax.ws.rs.core.Response.class);
        resPilgrims = response.readEntity(gresPligrims);
        pilgrims = resPilgrims.getResult();
        return pilgrims;
    }

    public void setPilgrims(Collection<PilgrimMaster> pilgrims) {
        this.pilgrims = pilgrims;
    }

    public int getNotpilgrim() {
        return notpilgrim;
    }

    public void setNotpilgrim(int notpilgrim) {
        this.notpilgrim = notpilgrim;
    }

    public Collection<PilgrimTimeslots> getPilgrimTimeslotses() {
        response = client.getPilgrimTimeslots(javax.ws.rs.core.Response.class, String.valueOf(pilgrimMaster.getPilgrimId()));
        rpilgrimTimeslotses = response.readEntity(grpilgrimTimeslotses);
        pilgrimTimeslotses = rpilgrimTimeslotses.getResult();
        return pilgrimTimeslotses;
    }

    public void setPilgrimTimeslotses(Collection<PilgrimTimeslots> pilgrimTimeslotses) {
        this.pilgrimTimeslotses = pilgrimTimeslotses;
    }

    public Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetailses() {
        response = client.getAllTimeslotsDetails(javax.ws.rs.core.Response.class);
        rpilgrimTimeslotsDetailses = response.readEntity(grpilgrimTimeslotsDetailses);
        pilgrimTimeslotsDetailses = rpilgrimTimeslotsDetailses.getResult();
        return pilgrimTimeslotsDetailses;
    }

    public void setPilgrimTimeslotsDetailses(Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailses) {
        this.pilgrimTimeslotsDetailses = pilgrimTimeslotsDetailses;
    }

    public Collection<PilgrimTickets> getPilgrimTicketses() {
        response = client.getTicketsByPilgrim(javax.ws.rs.core.Response.class, String.valueOf(pilgrimMaster.getPilgrimId()));
        rpilgrimTicketses = response.readEntity(grpilgrimTicketses);
        pilgrimTicketses = rpilgrimTicketses.getResult();
        return pilgrimTicketses;
    }

    public void setPilgrimTicketses(Collection<PilgrimTickets> pilgrimTicketses) {
        this.pilgrimTicketses = pilgrimTicketses;
    }

    public UploadedFile getPilgrimImage() {
        return pilgrimImage;
    }

    public void setPilgrimImage(UploadedFile pilgrimImage) {
        this.pilgrimImage = pilgrimImage;
    }

    public PilgrimRooms getPilgrimRooms() {
        return pilgrimRooms;
    }

    public void setPilgrimRooms(PilgrimRooms pilgrimRooms) {
        this.pilgrimRooms = pilgrimRooms;
    }

    public Collection<PilgrimRooms> getPilgrimRoomses() {
        response = client.getPilgrimRooms(javax.ws.rs.core.Response.class, String.valueOf(pilgrimMaster.getPilgrimId()));
        rpilgrimRoomses = response.readEntity(grpilgrimRoomses);
        pilgrimRoomses = rpilgrimRoomses.getResult();
        return pilgrimRoomses;
    }

    public void setPilgrimRoomses(Collection<PilgrimRooms> pilgrimRoomses) {
        this.pilgrimRoomses = pilgrimRoomses;
    }
    
    public String onSubmit() throws IOException {
        InputStream imageInputStream = pilgrimImage.getInputStream();
        String imageName = pilgrimImage.getFileName();
        imageName = imageName.substring(imageName.indexOf("."), imageName.length());
        Random random = new Random();
        pilgrimMaster.setPilgrimImage(pilgrimMaster.getPilgrimName() + "_" + random.nextInt(1000) + imageName);

        File uploadedImage = new File("D:\\Sem8\\Project\\PilgrimWorldf\\src\\main\\webapp\\images\\pilgrims\\" + imageName);
        Files.copy(imageInputStream, uploadedImage.toPath(), StandardCopyOption.REPLACE_EXISTING);

        Request req = new Request();
        UserMaster user = new UserMaster();
        user.setUserId(loggedInUser.getUserId());
        pilgrimMaster.setUser(user);
        req.setData(pilgrimMaster);
        client.addPilgrim(req, javax.ws.rs.core.Response.class);
        return "ClientUI/index.jsf";
    }

    public void onSubmitAddTimeslots() {
        System.out.println("Her add timeslots");
        Request req = new Request();
        if (timeslotType == 2) {
            pilgrimTimeslots.setWeekday(null);
        } else if (pilgrimTimeslots.getWeekday() != null) {
            pilgrimTimeslots.setWeekday(pilgrimTimeslots.getWeekday() + 1);
        }
        System.out.println(pilgrimTimeslots.getWeekday());
        pilgrimTimeslots.setPilgrim(pilgrimMaster);
        req.setData(pilgrimTimeslots);
        client.addPilgrimTimeslots(req, javax.ws.rs.core.Response.class);
    }

    public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream imageInputStream = event.getFile().getInputStream();
            String imageName = event.getFile().getFileName();
            imageName = imageName.substring(imageName.indexOf("."), imageName.length());
            Random random = new Random();
            pilgrimMaster.setPilgrimImage(pilgrimMaster.getPilgrimName() + "_" + random.nextInt(1000) + imageName);

            File uploadedImage = new File("D:\\Sem8\\Project\\PilgrimWorldf\\src\\main\\webapp\\images\\pilgrims\\" + imageName);
            Files.copy(imageInputStream, uploadedImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(PilgrimBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onSubmitAddTimeslotDetails() {
        System.out.println("Her add timeslots details");
        Request req = new Request();
        System.out.println(pilgrimTimeslots.getTimeslotsId());
        pilgrimTimeslotsDetails.setTimeslots(pilgrimTimeslots);
        req.setData(pilgrimTimeslotsDetails);
        client.addPilgrimTimeslotsDetails(req, javax.ws.rs.core.Response.class);
        req.setData(null);

    }

    public void onSubmitAddTicketDetails() {
        Request req = new Request();
        pilgrimTickets.setPilgrim(pilgrimMaster);
        pilgrimTickets.setTimeslotsDetails(pilgrimTimeslotsDetails);
        req.setData(pilgrimTickets);
        client.addPilgrimTicket(req, javax.ws.rs.core.Response.class);
        req.setData(null);

    }
    
    public void AddRooms() {
        Request req = new Request();
        pilgrimTickets.setPilgrim(pilgrimMaster);
        pilgrimTickets.setTimeslotsDetails(pilgrimTimeslotsDetails);
        req.setData(pilgrimTickets);
        client.addPilgrimTicket(req, javax.ws.rs.core.Response.class);
        req.setData(null);

    }
}
