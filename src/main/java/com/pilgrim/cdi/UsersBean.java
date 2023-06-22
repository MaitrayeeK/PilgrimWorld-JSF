/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.helper.Request;
import com.pilgrim.clients.AdminClient;
import com.pilgrim.helper.Response;
import com.pilgrim.record.KeepRecord;
import com.pligrim.models.CityMaster;
import com.pligrim.models.StateMaster;
import com.pligrim.models.UserMaster;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author Dell
 */
@Named(value = "usersBean")
@SessionScoped
public class UsersBean implements Serializable {

    javax.ws.rs.core.Response response;
    AdminClient adminClient;

    Response<Collection<UserMaster>> resUsers;
    GenericType<Response<Collection<UserMaster>>> gresUsers;

    Response<Collection<UserMaster>> resClients;
    GenericType<Response<Collection<UserMaster>>> gresClients;
    Collection<UserMaster> clients;

    Collection<UserMaster> users;
    UserMaster selectedUser;
    Collection<UserMaster> filteredUsers;

    Response resUpdate;
    GenericType<Response> gresUpdate;

    Response<Collection<StateMaster>> resStates;
    GenericType<Response<Collection<StateMaster>>> gresStates;
    Response<Collection<CityMaster>> resCities;
    GenericType<Response<Collection<CityMaster>>> gresCities;

    Response<Boolean> resIfExists;
    GenericType<Response<Boolean>> gresIfExists;

    Collection<StateMaster> states;
    Collection<CityMaster> cities;

    Response<UserMaster> resUser;
    GenericType<Response<UserMaster>> gresUser;
    UserMaster loggedInUser;

    String firstName, lastName, uname, email, address;
    Integer stateid;
    Integer cityid;
    String statename, cityname;
    UploadedFile userImage;

    private PieChartModel pieModel;

    public UsersBean() {
        adminClient = new AdminClient();
        resUsers = new Response<>();
        gresUsers = new GenericType<Response<Collection<UserMaster>>>() {
        };
        users = new ArrayList<>();
        gresClients = new GenericType<Response<Collection<UserMaster>>>() {
        };
        clients = new ArrayList<>();
        selectedUser = new UserMaster();
        filteredUsers = new ArrayList<>();
        gresStates = new GenericType<Response<Collection<StateMaster>>>() {
        };
        gresCities = new GenericType<Response<Collection<CityMaster>>>() {
        };
        gresUpdate = new GenericType<Response>() {
        };
        resIfExists = new Response<>();
        gresIfExists = new GenericType<Response<Boolean>>() {
        };
        gresUser = new GenericType<Response<UserMaster>>() {
        };
        loggedInUser = new UserMaster();

        response = adminClient.getUserByUsername(javax.ws.rs.core.Response.class, KeepRecord.getUsername());
        resUser = response.readEntity(gresUser);
        loggedInUser = resUser.getResult();

        firstName = loggedInUser.getFirstname();
        lastName = loggedInUser.getLastname();
        uname = loggedInUser.getUsername();
        address = loggedInUser.getAddress();
        stateid = loggedInUser.getState().getStateId();
        statename = loggedInUser.getState().getStateName();
        cityid = loggedInUser.getCity().getCityId();
        cityname = loggedInUser.getCity().getCityName();
        email = loggedInUser.getEmail();

    }

    @PostConstruct
    public void init() {
        createPieModel();
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    public UserMaster getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserMaster selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Response<Collection<UserMaster>> getResUsers() {
        return resUsers;
    }

    public void setResUsers(Response<Collection<UserMaster>> resUsers) {
        this.resUsers = resUsers;
    }

    public Collection<UserMaster> getUsers() {
        response = adminClient.getUserByGroup(javax.ws.rs.core.Response.class, String.valueOf(4));
        resUsers = response.readEntity(gresUsers);
        users = resUsers.getResult();
        return users;
    }

    public void setUsers(Collection<UserMaster> users) {
        this.users = users;
    }

    public Collection<UserMaster> getClients() {
        response = adminClient.getUserByGroup(javax.ws.rs.core.Response.class, String.valueOf(5));
        resClients = response.readEntity(gresClients);
        clients = resClients.getResult();
        return clients;
    }

    public void setClients(Collection<UserMaster> clients) {
        this.clients = clients;
    }

    public Collection<UserMaster> getFilteredUsers() {
        return filteredUsers;
    }

    public void setFilteredUsers(Collection<UserMaster> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }

    public Collection<StateMaster> getStates() {
        response = adminClient.getAllState(javax.ws.rs.core.Response.class);
        resStates = response.readEntity(gresStates);
        states = resStates.getResult();
        return states;
    }

    public void setStates(Collection<StateMaster> states) {
        this.states = states;
    }

    public Collection<CityMaster> getCities() {
        return cities;
    }

    public void setCities(Collection<CityMaster> cities) {
        this.cities = cities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public UploadedFile getUserImage() {
        return userImage;
    }

    public void setUserImage(UploadedFile userImage) {
        this.userImage = userImage;
    }

//    public UserMaster getLoggedInUser() {
//        response = adminClient.getUserByUsername(javax.ws.rs.core.Response.class, KeepRecord.getUsername());
//        resUser = response.readEntity(gresUser);
//        loggedInUser = resUser.getResult();
//        return loggedInUser;
//    }
//
//    public void setLoggedInUser(UserMaster loggedInUser) {
//        this.loggedInUser = loggedInUser;
//    }
    public void onStateChange() {
        System.out.println("State fron onStateChange: " + stateid);
        if (stateid != null && !stateid.equals("")) {
            response = adminClient.getAllCitiesByState(javax.ws.rs.core.Response.class, String.valueOf(stateid));
            resCities = response.readEntity(gresCities);
            cities = (List<CityMaster>) resCities.getResult();
        } else {
            cities = new ArrayList<>();
        }
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public String onSubmit() {

        loggedInUser.setFirstname(firstName);
        loggedInUser.setLastname(lastName);
        loggedInUser.setUsername(uname);
        loggedInUser.setAddress(address);
        StateMaster state = new StateMaster();
        state.setStateId(stateid);
        loggedInUser.setState(state);
        CityMaster city = new CityMaster();
        city.setCityId(cityid);
        loggedInUser.setCity(city);
        loggedInUser.setEmail(email);
        loggedInUser.setUpdatedDate(new Date());

        Request<UserMaster> requestbody = new Request<>();
        requestbody.setData(loggedInUser);

        response = adminClient.updateuser(requestbody, javax.ws.rs.core.Response.class);
        resUpdate = response.readEntity(gresUpdate);
        if (resUpdate.isStatus()) {
            addMessage(FacesMessage.SEVERITY_INFO, "Info Message", resUpdate.getMessage());
            return "profile.jsf";
        } else {
            addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", resUpdate.getMessage());
            return null;
        }
    }

    private void createPieModel() {
        getClients();
        getUsers();
        
        pieModel = new PieChartModel();
        ChartData data = new ChartData();

        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        values.add(clients.size());
        values.add(users.size());
        dataSet.setData(values);

        List<String> bgColors = new ArrayList<>();
        bgColors.add("rgb(255, 99, 132)");
        bgColors.add("rgb(255, 205, 86)");
        dataSet.setBackgroundColor(bgColors);

        data.addChartDataSet(dataSet);
        List<String> labels = new ArrayList<>();
        labels.add("Client");
        labels.add("User");
        data.setLabels(labels);

        pieModel.setData(data);
    }
}
