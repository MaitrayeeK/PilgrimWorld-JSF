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
public class CityMaster implements Serializable {
    
    private Integer cityId;
    
    private String cityName;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private StateMaster state;
    
    private Collection<UserMaster> userMasterCollection;

    private Collection<PilgrimMaster> pilgrimMasterCollection;

    public CityMaster() {
    }

    public CityMaster(Integer cityId, String cityName, Date createdDate, Date updatedDate, StateMaster state) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.state = state;
    }

    public CityMaster(String cityName, Date createdDate, Date updatedDate, StateMaster state) {
        this.cityName = cityName;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.state = state;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    @JsonbTransient
    public Collection<UserMaster> getUserMasterCollection() {
        return userMasterCollection;
    }

    public void setUserMasterCollection(Collection<UserMaster> userMasterCollection) {
        this.userMasterCollection = userMasterCollection;
    }

    @JsonbTransient
    public Collection<PilgrimMaster> getPilgrimMasterCollection() {
        return pilgrimMasterCollection;
    }

    public void setPilgrimMasterCollection(Collection<PilgrimMaster> pilgrimMasterCollection) {
        this.pilgrimMasterCollection = pilgrimMasterCollection;
    }
}
