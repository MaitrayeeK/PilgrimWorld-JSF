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
public class PilgrimTickets implements Serializable {
    
    private Integer ticketId;
    
    private int fromAge;
    
    private int toAge;
    
    private float price;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private Collection<CommissionMaster> commissionMasterCollection;
    
    private PilgrimMaster pilgrim;
    
    private PilgrimTimeslotsDetails timeslotsDetails;
    
    private Collection<BookingMaster> bookingMasterCollection;

    public PilgrimTickets() {
    }

    public PilgrimTickets(Integer ticketId, int fromAge, int toAge, float price, Date createdDate, Date updatedDate, PilgrimMaster pilgrim, PilgrimTimeslotsDetails timeslotsDetails) {
        this.ticketId = ticketId;
        this.fromAge = fromAge;
        this.toAge = toAge;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
        this.timeslotsDetails = timeslotsDetails;
    }

    public PilgrimTickets(int fromAge, int toAge, float price, Date createdDate, Date updatedDate, PilgrimMaster pilgrim, PilgrimTimeslotsDetails timeslotsDetails) {
        this.fromAge = fromAge;
        this.toAge = toAge;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
        this.timeslotsDetails = timeslotsDetails;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public int getFromAge() {
        return fromAge;
    }

    public void setFromAge(int fromAge) {
        this.fromAge = fromAge;
    }

    public int getToAge() {
        return toAge;
    }

    public void setToAge(int toAge) {
        this.toAge = toAge;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
    public Collection<CommissionMaster> getCommissionMasterCollection() {
        return commissionMasterCollection;
    }

    public void setCommissionMasterCollection(Collection<CommissionMaster> commissionMasterCollection) {
        this.commissionMasterCollection = commissionMasterCollection;
    }

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrim) {
        this.pilgrim = pilgrim;
    }

    public PilgrimTimeslotsDetails getTimeslotsDetails() {
        return timeslotsDetails;
    }

    public void setTimeslotsDetails(PilgrimTimeslotsDetails timeslotsDetails) {
        this.timeslotsDetails = timeslotsDetails;
    }

    @JsonbTransient
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }
}
