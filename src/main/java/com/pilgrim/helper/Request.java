/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.pilgrim.helper;


import java.io.Serializable;

/**
 *
 * @author Maitrayee
 * @param <T>
 */

public class Request<T> implements Serializable {
    private T data;

    public Request() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
