/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pligrim.models;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class ProfitMaster implements Serializable {
    
    private Integer profitId;
    
    private float profit;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private CommissionMaster commission;
    
    private PaymentMaster payment;

    public ProfitMaster() {
    }

    public ProfitMaster(Integer profitId, float profit, Date createdDate, Date updatedDate, CommissionMaster commission, PaymentMaster payment) {
        this.profitId = profitId;
        this.profit = profit;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.commission = commission;
        this.payment = payment;
    }

    public ProfitMaster(float profit, Date createdDate, Date updatedDate, CommissionMaster commission, PaymentMaster payment) {
        this.profit = profit;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.commission = commission;
        this.payment = payment;
    }

    public Integer getProfitId() {
        return profitId;
    }

    public void setProfitId(Integer profitId) {
        this.profitId = profitId;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
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

    public CommissionMaster getCommission() {
        return commission;
    }

    public void setCommission(CommissionMaster commission) {
        this.commission = commission;
    }

    public PaymentMaster getPayment() {
        return payment;
    }

    public void setPayment(PaymentMaster payment) {
        this.payment = payment;
    }
}
