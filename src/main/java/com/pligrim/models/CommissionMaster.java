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
public class CommissionMaster implements Serializable {
    
    private Integer commissionId;
    
    private float commissionPerPerson;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;
    
    private PilgrimTickets ticket;
    
    private Collection<ProfitMaster> profitMasterCollection;

    public CommissionMaster() {
    }

    public CommissionMaster(Integer commissionId, float commissionPerPerson, Date createdDate, Date updatedDate, PilgrimMaster pilgrim, PilgrimTickets ticket) {
        this.commissionId = commissionId;
        this.commissionPerPerson = commissionPerPerson;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
        this.ticket = ticket;
    }

    public CommissionMaster(float commissionPerPerson, Date createdDate, Date updatedDate, PilgrimMaster pilgrim, PilgrimTickets ticket) {
        this.commissionPerPerson = commissionPerPerson;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
        this.ticket = ticket;
    }

    public Integer getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Integer commissionId) {
        this.commissionId = commissionId;
    }

    public float getCommissionPerPerson() {
        return commissionPerPerson;
    }

    public void setCommissionPerPerson(float commissionPerPerson) {
        this.commissionPerPerson = commissionPerPerson;
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

    @JsonbTransient
    public Collection<ProfitMaster> getProfitMasterCollection() {
        return profitMasterCollection;
    }

    public void setProfitMasterCollection(Collection<ProfitMaster> profitMasterCollection) {
        this.profitMasterCollection = profitMasterCollection;
    }
}
