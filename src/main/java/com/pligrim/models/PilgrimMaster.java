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
public class PilgrimMaster implements Serializable {
    
    private Integer pilgrimId;
    
    private String pilgrimName;
    
    private String address;
    
    private String pilgrimImage;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private CityMaster city;
    
    private StateMaster state;
    
    private UserMaster user;
    
    private Collection<PilgrimTimeslots> pilgrimTimeslotsCollection;
    
    private Collection<AdvertisementMaster> advertisementMasterCollection;
    
    private Collection<FeedbackMaster> feedbackMasterCollection;
    
    private Collection<CommissionMaster> commissionMasterCollection;
    
    private Collection<PilgrimTickets> pilgrimTicketsCollection;
    
    private Collection<PaymentMaster> paymentMasterCollection;
    
    private Collection<PilgrimRooms> pilgrimRoomsCollection;
    
    private Collection<BookingMaster> bookingMasterCollection;
    
    private Collection<PilgrimImages> pilgrimImagesCollection;

    public PilgrimMaster(Integer pilgrimId, String pilgrimName, String address, String pilgrimImage, Date createdDate, Date updatedDate, CityMaster city, StateMaster state, UserMaster user) {
        this.pilgrimId = pilgrimId;
        this.pilgrimName = pilgrimName;
        this.address = address;
        this.pilgrimImage = pilgrimImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.city = city;
        this.state = state;
        this.user = user;
    }

    public PilgrimMaster(String pilgrimName, String address, String pilgrimImage, Date createdDate, Date updatedDate, CityMaster city, StateMaster state, UserMaster user) {
        this.pilgrimName = pilgrimName;
        this.address = address;
        this.pilgrimImage = pilgrimImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.city = city;
        this.state = state;
        this.user = user;
    }

    public Integer getPilgrimId() {
        return pilgrimId;
    }

    public void setPilgrimId(Integer pilgrimId) {
        this.pilgrimId = pilgrimId;
    }

    public String getPilgrimName() {
        return pilgrimName;
    }

    public void setPilgrimName(String pilgrimName) {
        this.pilgrimName = pilgrimName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPilgrimImage() {
        return pilgrimImage;
    }

    public void setPilgrimImage(String pilgrimImage) {
        this.pilgrimImage = pilgrimImage;
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

    public CityMaster getCity() {
        return city;
    }

    public void setCity(CityMaster city) {
        this.city = city;
    }

    public StateMaster getState() {
        return state;
    }

    public void setState(StateMaster state) {
        this.state = state;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }

    @JsonbTransient
    public Collection<PilgrimTimeslots> getPilgrimTimeslotsCollection() {
        return pilgrimTimeslotsCollection;
    }

    public void setPilgrimTimeslotsCollection(Collection<PilgrimTimeslots> pilgrimTimeslotsCollection) {
        this.pilgrimTimeslotsCollection = pilgrimTimeslotsCollection;
    }

    @JsonbTransient
    public Collection<AdvertisementMaster> getAdvertisementMasterCollection() {
        return advertisementMasterCollection;
    }

    public void setAdvertisementMasterCollection(Collection<AdvertisementMaster> advertisementMasterCollection) {
        this.advertisementMasterCollection = advertisementMasterCollection;
    }

    @JsonbTransient
    public Collection<FeedbackMaster> getFeedbackMasterCollection() {
        return feedbackMasterCollection;
    }

    public void setFeedbackMasterCollection(Collection<FeedbackMaster> feedbackMasterCollection) {
        this.feedbackMasterCollection = feedbackMasterCollection;
    }

    @JsonbTransient
    public Collection<CommissionMaster> getCommissionMasterCollection() {
        return commissionMasterCollection;
    }

    public void setCommissionMasterCollection(Collection<CommissionMaster> commissionMasterCollection) {
        this.commissionMasterCollection = commissionMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimTickets> getPilgrimTicketsCollection() {
        return pilgrimTicketsCollection;
    }

    public void setPilgrimTicketsCollection(Collection<PilgrimTickets> pilgrimTicketsCollection) {
        this.pilgrimTicketsCollection = pilgrimTicketsCollection;
    }

    @JsonbTransient
    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimRooms> getPilgrimRoomsCollection() {
        return pilgrimRoomsCollection;
    }

    public void setPilgrimRoomsCollection(Collection<PilgrimRooms> pilgrimRoomsCollection) {
        this.pilgrimRoomsCollection = pilgrimRoomsCollection;
    }

    @JsonbTransient
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimImages> getPilgrimImagesCollection() {
        return pilgrimImagesCollection;
    }

    public void setPilgrimImagesCollection(Collection<PilgrimImages> pilgrimImagesCollection) {
        this.pilgrimImagesCollection = pilgrimImagesCollection;
    }
}
