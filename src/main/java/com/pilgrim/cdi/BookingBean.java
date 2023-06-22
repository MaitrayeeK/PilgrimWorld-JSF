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
import javax.annotation.PostConstruct;
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
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.hbar.HorizontalBarChartDataSet;
import org.primefaces.model.charts.hbar.HorizontalBarChartModel;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author Dell
 */
@Named(value = "bookingBean")
@SessionScoped
public class BookingBean implements Serializable {

    private HorizontalBarChartModel hbarModel;
    
    ClientsClient client;
    CustomerClient customerClient;
    AdminClient adminClient;
    javax.ws.rs.core.Response response;

    BookingMaster booking;
    Integer timeslotsDetailsId;
    Integer pilgrimRoomId;
    Float totalTicketPrice;
    Float totalRoomPrice;
    BookingMaster selectedBooking;

    Response<Float> resRevenue;
    GenericType<Response<Float>> gresRevenue;
    Float revenue;

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
    
    @PostConstruct
    public void init() {
        createHorizontalBarModel();
    }

    public BookingBean() {
        client = new ClientsClient();
        customerClient = new CustomerClient();
        adminClient = new AdminClient();
        booking = new BookingMaster();
        selectedBooking = new BookingMaster();

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
        gresRevenue = new GenericType<Response<Float>>() {
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
        response = customerClient.getBookings(javax.ws.rs.core.Response.class);
        resBookings = response.readEntity(gresBookings);
        bookings = resBookings.getResult();
        return bookings;
    }

    public void setBookings(List<BookingMaster> bookings) {
        this.bookings = bookings;
    }

    public BookingMaster getSelectedBooking() {
        return selectedBooking;
    }

    public void setSelectedBooking(BookingMaster selectedBooking) {
        this.selectedBooking = selectedBooking;
    }

    public Float getRevenue() {
        response = customerClient.getPaymentRevenue(javax.ws.rs.core.Response.class);
        resRevenue = response.readEntity(gresRevenue);
        revenue = resRevenue.getResult();
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public HorizontalBarChartModel getHbarModel() {
        return hbarModel;
    }

    public void setHbarModel(HorizontalBarChartModel hbarModel) {
        this.hbarModel = hbarModel;
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
        
        getBookings();

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
    
    public void createHorizontalBarModel() {
        hbarModel = new HorizontalBarChartModel();
        ChartData data = new ChartData();

        HorizontalBarChartDataSet hbarDataSet = new HorizontalBarChartDataSet();
        hbarDataSet.setLabel("My First Dataset");

        List<Number> values = new ArrayList<>();
        values.add(65);
        values.add(59);
        values.add(80);
        values.add(81);
        values.add(56);
        values.add(55);
        values.add(40);
        hbarDataSet.setData(values);

        List<String> bgColor = new ArrayList<>();
        bgColor.add("rgba(255, 99, 132, 0.2)");
        bgColor.add("rgba(255, 159, 64, 0.2)");
        bgColor.add("rgba(255, 205, 86, 0.2)");
        bgColor.add("rgba(75, 192, 192, 0.2)");
        bgColor.add("rgba(54, 162, 235, 0.2)");
        bgColor.add("rgba(153, 102, 255, 0.2)");
        bgColor.add("rgba(201, 203, 207, 0.2)");
        hbarDataSet.setBackgroundColor(bgColor);

        List<String> borderColor = new ArrayList<>();
        borderColor.add("rgb(255, 99, 132)");
        borderColor.add("rgb(255, 159, 64)");
        borderColor.add("rgb(255, 205, 86)");
        borderColor.add("rgb(75, 192, 192)");
        borderColor.add("rgb(54, 162, 235)");
        borderColor.add("rgb(153, 102, 255)");
        borderColor.add("rgb(201, 203, 207)");
        hbarDataSet.setBorderColor(borderColor);
        hbarDataSet.setBorderWidth(1);

        data.addChartDataSet(hbarDataSet);

        List<String> labels = new ArrayList<>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        data.setLabels(labels);
        hbarModel.setData(data);

        //Options
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        linearAxes.setOffset(true);
        linearAxes.setBeginAtZero(true);
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        linearAxes.setTicks(ticks);
        cScales.addXAxesData(linearAxes);
        options.setScales(cScales);

        Title title = new Title();
        title.setDisplay(true);
        title.setText("Horizontal Bar Chart");
        options.setTitle(title);

        hbarModel.setOptions(options);
    }

}
