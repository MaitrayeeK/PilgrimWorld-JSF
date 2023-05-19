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
public class PilgrimTimeslotsDetails implements Serializable {
    
    private Integer timeslotsDetailsId;
    
    private Integer weekday;
    
    private Date fromDate;
    
    private Date toDate;
    
    private Date fromTime;
    
    private Date toTime;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimTimeslots timeslots;
    
    private Collection<PilgrimTickets> pilgrimTicketsCollection;
    
    private Collection<BookingMaster> bookingMasterCollection;

    public PilgrimTimeslotsDetails() {
    }

    public PilgrimTimeslotsDetails(Integer timeslotsDetailsId, Integer weekday, Date fromDate, Date toDate, Date fromTime, Date toTime, Date createdDate, Date updatedDate, PilgrimTimeslots timeslots) {
        this.timeslotsDetailsId = timeslotsDetailsId;
        this.weekday = weekday;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.timeslots = timeslots;
    }

    public PilgrimTimeslotsDetails(Integer weekday, Date fromDate, Date toDate, Date fromTime, Date toTime, Date createdDate, Date updatedDate, PilgrimTimeslots timeslots) {
        this.weekday = weekday;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.timeslots = timeslots;
    }

    public Integer getTimeslotsDetailsId() {
        return timeslotsDetailsId;
    }

    public void setTimeslotsDetailsId(Integer timeslotsDetailsId) {
        this.timeslotsDetailsId = timeslotsDetailsId;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
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

    public PilgrimTimeslots getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(PilgrimTimeslots timeslots) {
        this.timeslots = timeslots;
    }

    @JsonbTransient
    public Collection<PilgrimTickets> getPilgrimTicketsCollection() {
        return pilgrimTicketsCollection;
    }

    public void setPilgrimTicketsCollection(Collection<PilgrimTickets> pilgrimTicketsCollection) {
        this.pilgrimTicketsCollection = pilgrimTicketsCollection;
    }

    @JsonbTransient
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }
}
