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
public class StateMaster implements Serializable {
    
    private Integer stateId;
    
    private String stateName;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private Collection<PilgrimMaster> pilgrimMasterCollection;
    
    private Collection<CityMaster> cityMasterCollection;
    
    private Collection<UserMaster> userMasterCollection;

    public StateMaster() {
    }

    public StateMaster(Integer stateId, String stateName, Date createdDate, Date updatedDate) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public StateMaster(String stateName, Date createdDate, Date updatedDate) {
        this.stateName = stateName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
    public Collection<PilgrimMaster> getPilgrimMasterCollection() {
        return pilgrimMasterCollection;
    }

    public void setPilgrimMasterCollection(Collection<PilgrimMaster> pilgrimMasterCollection) {
        this.pilgrimMasterCollection = pilgrimMasterCollection;
    }

    @JsonbTransient
    public Collection<CityMaster> getCityMasterCollection() {
        return cityMasterCollection;
    }

    public void setCityMasterCollection(Collection<CityMaster> cityMasterCollection) {
        this.cityMasterCollection = cityMasterCollection;
    }

    @JsonbTransient
    public Collection<UserMaster> getUserMasterCollection() {
        return userMasterCollection;
    }

    public void setUserMasterCollection(Collection<UserMaster> userMasterCollection) {
        this.userMasterCollection = userMasterCollection;
    }
}
