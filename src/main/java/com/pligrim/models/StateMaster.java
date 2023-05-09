/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pligrim.models;

import java.util.Date;

/**
 *
 * @author Maitrayee
 */
public class StateMaster {
    
    private Integer stateId;
    
    private String stateName;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    
//    private Collection<PilgrimMaster> pilgrimMasterCollection;
//    private Collection<CityMaster> cityMasterCollection;
//    private Collection<UserMaster> userMasterCollection;

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
}
