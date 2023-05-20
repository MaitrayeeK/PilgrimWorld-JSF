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
 * @author Maitrayee
 */
public class UserMaster implements Serializable {
    
    private Integer userId;
    
    private String firstname;
    
    private String lastname;
    
    private String username;
    
    private String email;
    
    private String password;
    
    private String userImage;
    
    private String address;
    
    private CityMaster city;
    
    private GroupMaster group;
    
    private StateMaster state;    
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private Collection<PilgrimMaster> pilgrimMasterCollection;
    
    private Collection<FeedbackMaster> feedbackMasterCollection;
    
    private Collection<PaymentMaster> paymentMasterCollection;
    
    private Collection<BookingMaster> bookingMasterCollection;

    public UserMaster() {
    }

    public UserMaster(Integer userId, String firstname, String lastname, String username, String email, String password, String address, CityMaster city, GroupMaster group, StateMaster state, Date createdDate, Date updatedDate) {
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.group = group;
        this.state = state;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UserMaster(String firstname, String lastname, String username, String email, String password, String address, CityMaster city, GroupMaster group, StateMaster state, Date createdDate, Date updatedDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.city = city;
        this.group = group;
        this.state = state;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public StateMaster getState() {
        return state;
    }

    public void setState(StateMaster state) {
        this.state = state;
    }

    public CityMaster getCity() {
        return city;
    }

    public void setCity(CityMaster city) {
        this.city = city;
    }

    public GroupMaster getGroup() {
        return group;
    }

    public void setGroup(GroupMaster group) {
        this.group = group;
    }

    @JsonbTransient
    public Collection<PilgrimMaster> getPilgrimMasterCollection() {
        return pilgrimMasterCollection;
    }

    public void setPilgrimMasterCollection(Collection<PilgrimMaster> pilgrimMasterCollection) {
        this.pilgrimMasterCollection = pilgrimMasterCollection;
    }

    @JsonbTransient
    public Collection<FeedbackMaster> getFeedbackMasterCollection() {
        return feedbackMasterCollection;
    }

    public void setFeedbackMasterCollection(Collection<FeedbackMaster> feedbackMasterCollection) {
        this.feedbackMasterCollection = feedbackMasterCollection;
    }

    @JsonbTransient
    public Collection<PaymentMaster> getPaymentMasterCollection() {
        return paymentMasterCollection;
    }

    public void setPaymentMasterCollection(Collection<PaymentMaster> paymentMasterCollection) {
        this.paymentMasterCollection = paymentMasterCollection;
    }

    @JsonbTransient
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }
}
