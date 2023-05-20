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
public class AdvertisementMaster implements Serializable {
    
    private Integer advertisementId;
    
    private String adImage;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;

    public AdvertisementMaster() {
    }

    public AdvertisementMaster(Integer advertisementId, String adImage, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.advertisementId = advertisementId;
        this.adImage = adImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public AdvertisementMaster(String adImage, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.adImage = adImage;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
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
}
