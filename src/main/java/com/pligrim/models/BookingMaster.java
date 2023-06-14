/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pligrim.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;

/**
 *
 * @author Dell
 */
public class BookingMaster implements Serializable {
    
    private Integer bookingId;
    
    private Integer totalRooms;
    
    private int noOfPerson;
    
    private Date bookingDate;
    
    private float totalPrice;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimRooms pilgrimRoom;
    
    private Collection<PaymentMaster> paymentMasterCollection;
    
    private DiscountMaster discount;
    
    private PilgrimMaster pilgrim;
    
    private PilgrimTickets ticket;
    
    private PilgrimTimeslotsDetails timeslotsDetails;
    
    private UserMaster user;
    
    public BookingMaster() {
    }

    public BookingMaster(Integer bookingId, int noOfPerson, float totalPrice, Date createdDate, Date updatedDate, DiscountMaster discount, PilgrimMaster pilgrim, PilgrimTickets ticket, PilgrimTimeslotsDetails timeslotsDetails, UserMaster user) {
        this.bookingId = bookingId;
        this.noOfPerson = noOfPerson;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.discount = discount;
        this.pilgrim = pilgrim;
        this.ticket = ticket;
        this.timeslotsDetails = timeslotsDetails;
        this.user = user;
    }

    public BookingMaster(int noOfPerson, float totalPrice, Date createdDate, Date updatedDate, DiscountMaster discount, PilgrimMaster pilgrim, PilgrimTickets ticket, PilgrimTimeslotsDetails timeslotsDetails, UserMaster user) {
        this.noOfPerson = noOfPerson;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.discount = discount;
        this.pilgrim = pilgrim;
        this.ticket = ticket;
        this.timeslotsDetails = timeslotsDetails;
        this.user = user;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @JsonbTransient
    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    public DiscountMaster getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountMaster discount) {
        this.discount = discount;
    }

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrim) {
        this.pilgrim = pilgrim;
    }

    public PilgrimTickets getTicket() {
        return ticket;
    }

    public void setTicket(PilgrimTickets ticket) {
        this.ticket = ticket;
    }

    public PilgrimTimeslotsDetails getTimeslotsDetails() {
        return timeslotsDetails;
    }

    public void setTimeslotsDetails(PilgrimTimeslotsDetails timeslotsDetails) {
        this.timeslotsDetails = timeslotsDetails;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public PilgrimRooms getPilgrimRoom() {
        return pilgrimRoom;
    }

    public void setPilgrimRoom(PilgrimRooms pilgrimRoom) {
        this.pilgrimRoom = pilgrimRoom;
    }
}
