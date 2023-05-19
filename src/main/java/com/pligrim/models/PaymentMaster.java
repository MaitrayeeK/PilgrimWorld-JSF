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
public class PaymentMaster implements Serializable {
    
    private Integer paymentId;
    
    private float totalPrice;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private Collection<ProfitMaster> profitMasterCollection;
    
    private BookingMaster booking;
    
    private PilgrimMaster pilgrim;
    
    private UserMaster user;

    public PaymentMaster() {
    }

    public PaymentMaster(Integer paymentId, float totalPrice, Date createdDate, Date updatedDate, BookingMaster booking, PilgrimMaster pilgrim, UserMaster user) {
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.booking = booking;
        this.pilgrim = pilgrim;
        this.user = user;
    }

    public PaymentMaster(float totalPrice, Date createdDate, Date updatedDate, BookingMaster booking, PilgrimMaster pilgrim, UserMaster user) {
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.booking = booking;
        this.pilgrim = pilgrim;
        this.user = user;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
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
    public Collection<ProfitMaster> getProfitMasterCollection() {
        return profitMasterCollection;
    }

    public void setProfitMasterCollection(Collection<ProfitMaster> profitMasterCollection) {
        this.profitMasterCollection = profitMasterCollection;
    }

    public BookingMaster getBooking() {
        return booking;
    }

    public void setBooking(BookingMaster booking) {
        this.booking = booking;
    }

    public PilgrimMaster getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(PilgrimMaster pilgrim) {
        this.pilgrim = pilgrim;
    }

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }
}
