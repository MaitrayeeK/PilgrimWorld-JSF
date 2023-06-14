/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.ClientsClient;
import com.pilgrim.clients.CustomerClient;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;
import com.pilgrim.record.KeepRecord;
import com.pligrim.models.BookingMaster;
import com.pligrim.models.PilgrimImages;
import com.pligrim.models.PilgrimMaster;
import com.pligrim.models.PilgrimRooms;
import com.pligrim.models.PilgrimTickets;
import com.pligrim.models.PilgrimTimeslots;
import com.pligrim.models.PilgrimTimeslotsDetails;
import com.pligrim.models.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Dell
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {

    ClientsClient client;
    CustomerClient customerClient;
    javax.ws.rs.core.Response response;

    BookingMaster booking;
    Integer timeslotsDetailsId;
    Integer pilgrimRoomId;

    Response resAddBooking;
    GenericType<Response> gresAddBooking;

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

    Response<Collection<PilgrimRooms>> resSelectedPilgrimRooms;
    GenericType<Response<Collection<PilgrimRooms>>> gresSelectedPilgrimRooms;
    Collection<PilgrimRooms> selectedPilgrimRooms;

    Response<PilgrimRooms> resSelectedRoom;
    GenericType<Response<PilgrimRooms>> gresSelectedRoom;

    public BookingBean() {
        client = new ClientsClient();
        customerClient = new CustomerClient();
        booking = new BookingMaster();

        gresAddBooking = new GenericType<Response>() {
        };

        gresSelectedPilgrim = new GenericType<Response<PilgrimMaster>>() {
        };
        selectedPilgrim = new PilgrimMaster();

        gresSelectedPilgrimImages = new GenericType<Response<Collection<PilgrimImages>>>() {
        };
        selectedPilgrimImages = new ArrayList<>();

        gresSelectedPilgrimTimeSlots = new GenericType<Response<Collection<PilgrimTimeslots>>>() {
        };
        selectedPilgrimTimeSlots = new ArrayList<>();

        gresSelectedPTimeSlotsDetails = new GenericType<Response<Collection<PilgrimTimeslotsDetails>>>() {
        };
        selectedPTimeSlotsDetails = new ArrayList<>();

        gresSelectedPilgrimTicket = new GenericType<Response<PilgrimTickets>>() {
        };
        selectedPilgrimTicket = new PilgrimTickets();

        gresSelectedPilgrimRooms = new GenericType<Response<Collection<PilgrimRooms>>>() {
        };
        selectedPilgrimRooms = new ArrayList<>();

        gresSelectedRoom = new GenericType<Response<PilgrimRooms>>() {
        };
    }

    public BookingMaster getBooking() {
        return booking;
    }

    public void setBooking(BookingMaster booking) {
        this.booking = booking;
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

    public PilgrimTickets getSelectedPilgrimTicket() {
        return selectedPilgrimTicket;
    }

    public void setSelectedPilgrimTicket(PilgrimTickets selectedPilgrimTicket) {
        this.selectedPilgrimTicket = selectedPilgrimTicket;
    }

    public Collection<PilgrimRooms> getSelectedPilgrimRooms() {
        return selectedPilgrimRooms;
    }

    public void setSelectedPilgrimRooms(Collection<PilgrimRooms> selectedPilgrimRooms) {
        this.selectedPilgrimRooms = selectedPilgrimRooms;
    }

    public Integer getTimeslotsDetailsId() {
        return timeslotsDetailsId;
    }

    public void setTimeslotsDetailsId(Integer timeslotsDetailsId) {
        this.timeslotsDetailsId = timeslotsDetailsId;
    }

    public Integer getPilgrimRoomId() {
        return pilgrimRoomId;
    }

    public void setPilgrimRoomId(Integer pilgrimRoomId) {
        this.pilgrimRoomId = pilgrimRoomId;
    }

    public String gotoSinglePilgrim(Integer pilgrimid) {

        //get selected pilgrim
        response = client.getPilgrimsById(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrim = response.readEntity(gresSelectedPilgrim);
        selectedPilgrim = resSelectedPilgrim.getResult();

        //get selected pilgrim images
        response = client.getPilgrimImages(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrimImages = response.readEntity(gresSelectedPilgrimImages);
        selectedPilgrimImages = resSelectedPilgrimImages.getResult();

        //get selected pilgrim timeslots
        response = client.getPilgrimTimeslots(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrimTimeSlots = response.readEntity(gresSelectedPilgrimTimeSlots);
        selectedPilgrimTimeSlots = resSelectedPilgrimTimeSlots.getResult();

        //get selected pilgrim rooms
        response = client.getPilgrimRooms(javax.ws.rs.core.Response.class, String.valueOf(pilgrimid));
        resSelectedPilgrimRooms = response.readEntity(gresSelectedPilgrimRooms);
        selectedPilgrimRooms = resSelectedPilgrimRooms.getResult();

        return "singlepilgrim.jsf?faces-redirect=true";
    }

    public void onBookingDateChange(SelectEvent<Date> event) {
        for (PilgrimTimeslots ts : selectedPilgrimTimeSlots) {
            if (ts.getFromDate() == null && ts.getToDate() == null) {
                Calendar c = Calendar.getInstance();
                c.setTime(event.getObject());
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                System.out.println("Weekday: " + dayOfWeek);

                if (dayOfWeek == ts.getWeekday()) {
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
        System.out.println("TimeslotDetailId: " + timeslotsDetailsId);
        response = client.getTicketsByPTimeSlotsDetails(javax.ws.rs.core.Response.class, String.valueOf(timeslotsDetailsId));
        resSelectedPilgrimTicket = response.readEntity(gresSelectedPilgrimTicket);
        selectedPilgrimTicket = resSelectedPilgrimTicket.getResult();

        System.out.println("TicketId: " + selectedPilgrimTicket.getTicketId() + " PTimeSlotsDetailsId: "
                + selectedPilgrimTicket.getTimeslotsDetails().getTimeslotsDetailsId()
                + " TicketPrice: " + selectedPilgrimTicket.getPrice());
    }

    public void onRoomChange() {
        //get room by roomid
        response = client.getPilgrimRoomsById(javax.ws.rs.core.Response.class, String.valueOf(pilgrimRoomId));
        resSelectedRoom = response.readEntity(gresSelectedRoom);
        booking.setPilgrimRoom(resSelectedRoom.getResult());
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void onBook() {

        UserMaster user = new UserMaster();
        user.setUserId(KeepRecord.getUserid());
        booking.setUser(user);

        PilgrimMaster pilgrim = new PilgrimMaster();
        pilgrim.setPilgrimId(selectedPilgrim.getPilgrimId());
        booking.setPilgrim(pilgrim);

        PilgrimTimeslotsDetails timeslotsdetails = new PilgrimTimeslotsDetails();
        timeslotsdetails.setTimeslotsDetailsId(timeslotsDetailsId);
        booking.setTimeslotsDetails(timeslotsdetails);

        booking.setTicket(selectedPilgrimTicket);
        booking.setCreatedDate(new Date());
        booking.setUpdatedDate(new Date());

        float ticketprice = selectedPilgrimTicket.getPrice() * booking.getNoOfPerson();
        float roomprice = booking.getPilgrimRoom().getPrice() * booking.getTotalRooms();
        booking.setTotalPrice(ticketprice + roomprice);

        System.out.println("TicketPrice: " + ticketprice);
        System.out.println("RoomPrice: " + roomprice);
        System.out.println("TotalPrice: " + booking.getTotalPrice());

        System.out.println("User: " + booking.getUser().getUserId());
        System.out.println("Pilgrim: " + booking.getPilgrim().getPilgrimId());
        System.out.println("TimeSlotsDetailsId: " + booking.getTimeslotsDetails().getTimeslotsDetailsId());
        System.out.println("TicketId: " + booking.getTicket().getTicketId());
        System.out.println("RoomId: " + booking.getPilgrimRoom().getPilgrimRoomId());

        Request<BookingMaster> requestbody = new Request<>();
        requestbody.setData(booking);

        //add booking
        response = customerClient.addBooking(requestbody, javax.ws.rs.core.Response.class);
        resAddBooking = response.readEntity(gresAddBooking);
        if(resAddBooking.isStatus()){
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", resAddBooking.getMessage());
        }
        else{
            addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", resAddBooking.getMessage());
        }
        
    }

}
