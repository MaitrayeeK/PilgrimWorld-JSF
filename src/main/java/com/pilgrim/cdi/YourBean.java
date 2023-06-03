/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Dell
 */
@Named(value = "referenceBean")
@SessionScoped
public class YourBean implements Serializable{

    private List<String> authors = new ArrayList<>();

    public void addAuthor() {
        System.out.println("Button clicked!!!");
        authors.add("riya");
    }

    public void removeAuthor(ActionEvent e) {
        String index = e.getComponent().getAttributes().get("index").toString();
        int i = Integer.parseInt(index);
        authors.remove(i);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

}
