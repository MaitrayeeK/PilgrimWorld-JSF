/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author maitr
 */
@Named(value = "pilgrimBean")
@SessionScoped
public class PilgrimBean implements Serializable {

    int timeslotType;
    int timeslots;
    ArrayList weekdays = new ArrayList<>();
    
    public PilgrimBean() {
        weekdays.add("Sunday");
        weekdays.add("Monday");
        weekdays.add("Tuesday");
        weekdays.add("Wednesday");
        weekdays.add("Thursday");
        weekdays.add("Friday");
        weekdays.add("Saturday");
    }

    public int getTimeslotType() {
        return timeslotType;
    }

    public void setTimeslotType(int timeslotType) {
        this.timeslotType = timeslotType;
    }

    public int getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(int timeslots) {
        this.timeslots = timeslots;
    }

    public ArrayList getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(ArrayList weekdays) {
        this.weekdays = weekdays;
    }
    
    public void addTimeslots() {
        timeslots++;
    }
}
