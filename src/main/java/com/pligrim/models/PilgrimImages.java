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
public class PilgrimImages implements Serializable {

    private Integer pilgrimImageId;
    
    private String image;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;

    public PilgrimImages() {
    }

    public PilgrimImages(Integer pilgrimImageId, String image, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.pilgrimImageId = pilgrimImageId;
        this.image = image;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public PilgrimImages(String image, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.image = image;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public Integer getPilgrimImageId() {
        return pilgrimImageId;
    }

    public void setPilgrimImageId(Integer pilgrimImageId) {
        this.pilgrimImageId = pilgrimImageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
