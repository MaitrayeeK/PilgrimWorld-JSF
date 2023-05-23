/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author maitr
 */
@Named(value = "pilgrimBean")
@SessionScoped
public class PilgrimBean implements Serializable {

    String timeslotType;
    int timeslots;
    
    public PilgrimBean() {
    }

    public String getTimeslotType() {
        System.out.println(timeslotType);
        return timeslotType;
    }

    public void setTimeslotType(String timeslotType) {
        System.out.println(timeslotType);
        this.timeslotType = timeslotType;
    }

    public int getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(int timeslots) {
        this.timeslots = timeslots;
    }
    
    
}
