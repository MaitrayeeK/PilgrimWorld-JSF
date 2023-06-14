/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pligrim.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dell
 */
public class PilgrimTimeslots implements Serializable {
    
    private Integer timeslotsId;
   
    private Integer weekday;

    private Date fromDate;
    
    private Date toDate;
    
    private Date createdDate;
   
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;
    
    private Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailsCollection;

    public PilgrimTimeslots() {
    }

    public Integer getTimeslotsId() {
        return timeslotsId;
    }

    public void setTimeslotsId(Integer timeslotsId) {
        this.timeslotsId = timeslotsId;
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

    @JsonbTransient
    public Collection<PilgrimTimeslotsDetails> getPilgrimTimeslotsDetailsCollection() {
        return pilgrimTimeslotsDetailsCollection;
    }

    public void setPilgrimTimeslotsDetailsCollection(Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailsCollection) {
        this.pilgrimTimeslotsDetailsCollection = pilgrimTimeslotsDetailsCollection;
    }
}
