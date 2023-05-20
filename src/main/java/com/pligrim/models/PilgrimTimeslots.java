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
public class PilgrimTimeslots implements Serializable {
    
    private Integer timeslotsId;
    
    private int weekDate;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;
    
    private Collection<PilgrimTimeslotsDetails> pilgrimTimeslotsDetailsCollection;

    public PilgrimTimeslots() {
    }

    public PilgrimTimeslots(Integer timeslotsId, int weekDate, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.timeslotsId = timeslotsId;
        this.weekDate = weekDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public PilgrimTimeslots(int weekDate, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.weekDate = weekDate;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public Integer getTimeslotsId() {
        return timeslotsId;
    }

    public void setTimeslotsId(Integer timeslotsId) {
        this.timeslotsId = timeslotsId;
    }

    public int getWeekDate() {
        return weekDate;
    }

    public void setWeekDate(int weekDate) {
        this.weekDate = weekDate;
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
