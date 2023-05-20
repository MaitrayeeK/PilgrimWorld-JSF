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
public class PilgrimRooms implements Serializable {
    
    private Integer pilgrimRoomId;
    
    private int noOfRooms;
    
    private int roomType;
    
    private float price;
    
    private Date createdDate;
    
    private Date updatedDate;
    
    private PilgrimMaster pilgrim;

    public PilgrimRooms() {
    }

    public PilgrimRooms(Integer pilgrimRoomId, int noOfRooms, int roomType, float price, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.pilgrimRoomId = pilgrimRoomId;
        this.noOfRooms = noOfRooms;
        this.roomType = roomType;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public PilgrimRooms(int noOfRooms, int roomType, float price, Date createdDate, Date updatedDate, PilgrimMaster pilgrim) {
        this.noOfRooms = noOfRooms;
        this.roomType = roomType;
        this.price = price;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.pilgrim = pilgrim;
    }

    public Integer getPilgrimRoomId() {
        return pilgrimRoomId;
    }

    public void setPilgrimRoomId(Integer pilgrimRoomId) {
        this.pilgrimRoomId = pilgrimRoomId;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
