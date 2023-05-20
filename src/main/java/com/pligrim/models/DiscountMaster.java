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
public class DiscountMaster implements Serializable {
    
    private Integer discountId;
    
    private int discountType;
    
    private int discount;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private Collection<BookingMaster> bookingMasterCollection;

    public DiscountMaster() {
    }

    public DiscountMaster(Integer discountId, int discountType, int discount, Date createdDate, Date updatedDate) {
        this.discountId = discountId;
        this.discountType = discountType;
        this.discount = discount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public DiscountMaster(int discountType, int discount, Date createdDate, Date updatedDate) {
        this.discountType = discountType;
        this.discount = discount;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public int getDiscountType() {
        return discountType;
    }

    public void setDiscountType(int discountType) {
        this.discountType = discountType;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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
    public Collection<BookingMaster> getBookingMasterCollection() {
        return bookingMasterCollection;
    }

    public void setBookingMasterCollection(Collection<BookingMaster> bookingMasterCollection) {
        this.bookingMasterCollection = bookingMasterCollection;
    }
}
