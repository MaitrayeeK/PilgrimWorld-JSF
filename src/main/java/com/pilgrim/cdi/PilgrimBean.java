/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.ClientsClient;
import com.pilgrim.helper.Response;
import com.pligrim.models.PilgrimImages;
import com.pligrim.models.PilgrimMaster;
import com.pligrim.models.PilgrimTickets;
import com.pligrim.models.PilgrimTimeslots;
import com.pligrim.models.PilgrimTimeslotsDetails;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ws.rs.core.GenericType;
import org.primefaces.event.SelectEvent;

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

    Response<PilgrimMaster> resSelectedPilgrim;
    GenericType<Response<PilgrimMaster>> gresSelectedPilgrim;
    PilgrimMaster selectedPilgrim;

    Response<Collection<PilgrimImages>> resSelectedPilgrimImages;
    GenericType<Response<Collection<PilgrimImages>>> gresSelectedPilgrimImages;
    Collection<PilgrimImages> selectedPilgrimImages;

    Response<Collection<PilgrimTimeslots>> resSelectedPilgrimTimeSlots;
    GenericType<Response<Collection<PilgrimTimeslots>>> gresSelectedPilgrimTimeSlots;
    Collection<PilgrimTimeslots> selectedPilgrimTimeSlots;
    
    Response<Collection<PilgrimTimeslotsDetails>> resSelectedPTimeSlotsDetails;
    GenericType<Response<Collection<PilgrimTimeslotsDetails>>> gresSelectedPTimeSlotsDetails;
    Collection<PilgrimTimeslotsDetails> selectedPTimeSlotsDetails;
    
    Response<PilgrimTickets> resSelectedPilgrimTicket;
    GenericType<Response<PilgrimTickets>> gresSelectedPilgrimTicket;
    PilgrimTickets selectedPilgrimTicket;
    

    int timeslotType;
    int timeslots;
    ArrayList weekdays = new ArrayList<>();
    
    Date bookingdate;
    Integer pilgrimtimeslotsdetailsid;
    Float pilgrimTicketPrice;
    
    public PilgrimBean() {
        client = new ClientsClient();
        grespilgrims = new GenericType<Response<Collection<PilgrimMaster>>>() {
        };
        pilgrims = new ArrayList<>();

        gresSelectedPilgrim = new GenericType<Response<PilgrimMaster>>() {
        };
        selectedPilgrim = new PilgrimMaster();

        gresSelectedPilgrimImages = new GenericType<Response<Collection<PilgrimImages>>>() {
        };
        selectedPilgrimImages = new ArrayList<>();

        gresSelectedPilgrimTimeSlots = new GenericType<Response<Collection<PilgrimTimeslots>>>() {
        };
        selectedPilgrimTimeSlots = new ArrayList<>();
        
        gresSelectedPTimeSlotsDetails = new GenericType<Response<Collection<PilgrimTimeslotsDetails>>>(){};
        selectedPTimeSlotsDetails = new ArrayList<>();
        
        gresSelectedPilgrimTicket = new GenericType<Response<PilgrimTickets>>(){};
        selectedPilgrimTicket = new PilgrimTickets();

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

    public PilgrimMaster getSelectedPilgrim() {
        return selectedPilgrim;
    }

    public void setSelectedPilgrim(PilgrimMaster selectedPilgrim) {
        this.selectedPilgrim = selectedPilgrim;
    }

    public Collection<PilgrimImages> getSelectedPilgrimImages() {
        return selectedPilgrimImages;
    }

    public void setSelectedPilgrimImages(Collection<PilgrimImages> selectedPilgrimImages) {
        this.selectedPilgrimImages = selectedPilgrimImages;
    }

    public Collection<PilgrimTimeslots> getSelectedPilgrimTimeSlots() {
        return selectedPilgrimTimeSlots;
    }

    public void setSelectedPilgrimTimeSlots(Collection<PilgrimTimeslots> selectedPilgrimTimeSlots) {
        this.selectedPilgrimTimeSlots = selectedPilgrimTimeSlots;
    }

    public Collection<PilgrimTimeslotsDetails> getSelectedPTimeSlotsDetails() {
        return selectedPTimeSlotsDetails;
    }

    public void setSelectedPTimeSlotsDetails(Collection<PilgrimTimeslotsDetails> selectedPTimeSlotsDetails) {
        this.selectedPTimeSlotsDetails = selectedPTimeSlotsDetails;
    }

    public Integer getPilgrimtimeslotsdetailsid() {
        return pilgrimtimeslotsdetailsid;
    }

    public void setPilgrimtimeslotsdetailsid(Integer pilgrimtimeslotsdetailsid) {
        this.pilgrimtimeslotsdetailsid = pilgrimtimeslotsdetailsid;
    }

    public Date getDate() {
        return bookingdate;
    }

    public void setDate(Date bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Float getPilgrimTicketPrice() {
        return pilgrimTicketPrice;
    }

    public void setPilgrimTicketPrice(Float pilgrimTicketPrice) {
        this.pilgrimTicketPrice = pilgrimTicketPrice;
    }

    public String gotoSinglePilgrim(Integer pilgrimid) {
        bookingdate = null;
        pilgrimtimeslotsdetailsid = null;
        
        response = client.getPilgrimsById(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrim = response.readEntity(gresSelectedPilgrim);
        selectedPilgrim = resSelectedPilgrim.getResult();

        //getting selected pilgrim images
        response = client.getPilgrimImages(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrimImages = response.readEntity(gresSelectedPilgrimImages);
        selectedPilgrimImages = resSelectedPilgrimImages.getResult();

        //getting selected pilgrim timeslots
        response = client.getPilgrimTimeslots(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrimTimeSlots = response.readEntity(gresSelectedPilgrimTimeSlots);
        selectedPilgrimTimeSlots = resSelectedPilgrimTimeSlots.getResult();

        return "singlepilgrim.jsf?faces-redirect=true";
    }

    public void onDateSelect(SelectEvent<Date> event) {
        for (PilgrimTimeslots ts : selectedPilgrimTimeSlots) {
            if (ts.getFromDate() == null && ts.getToDate() == null) {
                Calendar c = Calendar.getInstance();
                c.setTime(event.getObject());
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                System.out.println("Weekday: " + dayOfWeek);
                
                if(dayOfWeek == ts.getWeekday()) {
                    System.out.println("TimeSlotId: " + ts.getTimeslotsId() + " WeekDay: " + ts.getWeekday());
                    
                    //getting pilgrim timeslos details
                    response = client.getPilgrimTimeslotsDetails(javax.ws.rs.core.Response.class, String.valueOf(ts.getTimeslotsId()));
                    resSelectedPTimeSlotsDetails = response.readEntity(gresSelectedPTimeSlotsDetails);
                    selectedPTimeSlotsDetails = resSelectedPTimeSlotsDetails.getResult();
                }
            }
        }

    }
    
    public void onTimeSlotChange() {
        System.out.println("TimeslotDetailId: " + pilgrimtimeslotsdetailsid);
        response = client.getTicketsByPTimeSlotsDetails(javax.ws.rs.core.Response.class, String.valueOf(pilgrimtimeslotsdetailsid));
        resSelectedPilgrimTicket = response.readEntity(gresSelectedPilgrimTicket);
        selectedPilgrimTicket = resSelectedPilgrimTicket.getResult();
        
        System.out.println("TicketId: " + selectedPilgrimTicket.getTicketId() + " PTimeSlotsDetailsId: " + 
                selectedPilgrimTicket.getTimeslotsDetails().getTimeslotsDetailsId() + 
                " TicketPrice: " + selectedPilgrimTicket.getPrice());
        
        pilgrimTicketPrice = selectedPilgrimTicket.getPrice();
    }
}
