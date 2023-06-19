/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.AdminClient;
import com.pilgrim.clients.ClientsClient;
import com.pilgrim.clients.CustomerClient;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;
import com.pilgrim.record.KeepRecord;
import com.pligrim.models.BookingMaster;
import com.pligrim.models.PaymentMaster;
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
import java.util.List;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    AdminClient adminClient;
    javax.ws.rs.core.Response response;

    BookingMaster booking;
    Integer timeslotsDetailsId;
    Integer pilgrimRoomId;
    Float totalTicketPrice;
    Float totalRoomPrice;

    Response resAdd;
    GenericType<Response> gresAdd;

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

    Response<UserMaster> resLoggedinUser;
    GenericType<Response<UserMaster>> gresLoggedinUser;

    Response<List<BookingMaster>> resBookings;
    GenericType<Response<List<BookingMaster>>> gresBookings;
    List<BookingMaster> bookings;

    public BookingBean() {
        client = new ClientsClient();
        customerClient = new CustomerClient();
        adminClient = new AdminClient();
        booking = new BookingMaster();

        gresAdd = new GenericType<Response>() {
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

        gresLoggedinUser = new GenericType<Response<UserMaster>>() {
        };

        gresBookings = new GenericType<Response<List<BookingMaster>>>() {
        };
        bookings = new ArrayList<>();
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

    public Float getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice(Float totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }

    public Float getTotalRoomPrice() {
        return totalRoomPrice;
    }

    public void setTotalRoomPrice(Float totalRoomPrice) {
        this.totalRoomPrice = totalRoomPrice;
    }

    public List<BookingMaster> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingMaster> bookings) {
        this.bookings = bookings;
    }

    public String gotoSinglePilgrim(Integer pilgrimid) {

        booking = new BookingMaster();
        timeslotsDetailsId = null;
        pilgrimRoomId = null;
        selectedPilgrimTicket.setPrice(0);

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

    public String onBook() {

        response = adminClient.getUserByUsername(javax.ws.rs.core.Response.class, KeepRecord.getUsername());
        resLoggedinUser = response.readEntity(gresLoggedinUser);
        booking.setUser(resLoggedinUser.getResult());

//        PilgrimMaster pilgrim = new PilgrimMaster();
//        pilgrim.setPilgrimId(selectedPilgrim.getPilgrimId());
        booking.setPilgrim(selectedPilgrim);

        PilgrimTimeslotsDetails timeslotsdetails = new PilgrimTimeslotsDetails();
        timeslotsdetails.setTimeslotsDetailsId(timeslotsDetailsId);
        booking.setTimeslotsDetails(timeslotsdetails);

        booking.setTicket(selectedPilgrimTicket);
        booking.setCreatedDate(new Date());
        booking.setUpdatedDate(new Date());

        totalTicketPrice = selectedPilgrimTicket.getPrice() * booking.getNoOfPerson();

        if (booking.getPilgrimRoom().getPilgrimRoomId() != null) {
            totalRoomPrice = booking.getPilgrimRoom().getPrice() * booking.getTotalRooms();
            booking.setTotalPrice(totalTicketPrice + totalRoomPrice);
        } else {
            booking.setTotalPrice(totalTicketPrice);
        }

        Request<BookingMaster> requestbody = new Request<>();
        requestbody.setData(booking);

        //add booking
        response = customerClient.addBooking(requestbody, javax.ws.rs.core.Response.class);
        resAdd = response.readEntity(gresAdd);
        if (resAdd.isStatus()) {
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", resAdd.getMessage());
            return "checkout.jsf?faces-redirect=true";
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", resAdd.getMessage());
            return null;
        }
    }

    public String onPay() {
        
        response = customerClient.getBookings(javax.ws.rs.core.Response.class);
        resBookings = response.readEntity(gresBookings);
        bookings = resBookings.getResult();

        PaymentMaster payment = new PaymentMaster();
        payment.setUser(booking.getUser());
        payment.setPilgrim(booking.getPilgrim());
        payment.setBooking(bookings.get(bookings.size() - 1));
        payment.setTotalPrice(booking.getTotalPrice());
        payment.setCreatedDate(new Date());
        payment.setUpdatedDate(new Date());

        Request<PaymentMaster> requestbody = new Request<>();
        requestbody.setData(payment);

        response = customerClient.addPayment(requestbody, javax.ws.rs.core.Response.class);
        resAdd = response.readEntity(gresAdd);
        if (resAdd.isStatus()) {

            //sending booking information via email to user
            try {

                Properties properties = new Properties();
                properties.put("mail.smtp.auth", true);
                properties.put("mail.smtp.starttls.enable", true);
                properties.put("mail.smtp.port", "587");
                properties.put("mail.smtp.host", "smtp.gmail.com");

                String username = "rencylakhani129@gmail.com";
                String password = "nqxhpzweevmmgzsy";

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                String recipient_email = booking.getUser().getEmail();
                String sender_email = "rencylakhani129@gmail.com";

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(sender_email));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient_email));
                message.setSubject("Booking Information");

                String email_body = null;

                if (booking.getPilgrimRoom().getPilgrimRoomId() != null) {
                    email_body = "<h3>Booking Information</h3>\n"
                            + "        <h4>Booking Date: " + booking.getBookingDate() + "</h4>\n"
                            + "        <h4>No of Person: " + booking.getNoOfPerson() + "</h4>\n"
                            + "        <h4>Total Ticket Price: " + totalTicketPrice + "</h4>\n"
                            + "        <h4>Room: " + booking.getPilgrimRoom().getRoomType() + "</h4>\n"
                            + "        <h4>Total Rooms: " + booking.getTotalRooms() + "</h4>\n"
                            + "        <h4>Total Room Price: " + totalRoomPrice + "</h4>\n"
                            + "        <h4>Total Booking Price: " + booking.getTotalPrice() + "</h4>";
                } else {
                    email_body = "<h3>Booking Information</h3>\n"
                            + "        <h4>Booking Date: " + booking.getBookingDate() + "</h4>\n"
                            + "        <h4>No of Person: " + booking.getNoOfPerson() + "</h4>\n"
                            + "        <h4>Total Ticket Price: " + totalTicketPrice + "</h4>\n"
                            + "        <h4>Total Booking Price: " + booking.getTotalPrice() + "</h4>";
                }

                message.setContent(email_body, "text/html");

                Transport.send(message);
                System.out.println("Mail sent successfully!!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return "successpayment.jsf?faces-redirect=true";
        } else {
            return null;
        }
    }

}
