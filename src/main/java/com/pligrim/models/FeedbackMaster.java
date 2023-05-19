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
public class FeedbackMaster implements Serializable {
    
    private Integer feedbackId;
    
    private String feedback;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;
    
    private UserMaster user;

    public FeedbackMaster() {
    }

    public FeedbackMaster(Integer feedbackId, String feedback, Date createdDate, Date updatedDate, PilgrimMaster pilgrim, UserMaster user) {
        this.feedbackId = feedbackId;
        this.feedback = feedback;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
        this.user = user;
    }

    public FeedbackMaster(String feedback, Date createdDate, Date updatedDate, PilgrimMaster pilgrim, UserMaster user) {
        this.feedback = feedback;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
        this.user = user;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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

    public UserMaster getUser() {
        return user;
    }

    public void setUser(UserMaster user) {
        this.user = user;
    }
}
