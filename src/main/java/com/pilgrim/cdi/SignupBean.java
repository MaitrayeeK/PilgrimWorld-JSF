/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.pilgrim.cdi;

import com.pilgrim.clients.AdminClient;
import com.pilgrim.helper.Request;
import com.pilgrim.helper.Response;
import com.pilgrim.record.KeepRecord;
import com.pligrim.models.CityMaster;
import com.pligrim.models.GroupMaster;
import com.pligrim.models.StateMaster;
import com.pligrim.models.UserMaster;
import java.io.File;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.ws.rs.core.GenericType;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author maitr
 */
@Named(value = "signupBean")
@SessionScoped
public class SignupBean implements Serializable {

    AdminClient client;
    javax.ws.rs.core.Response response;
    Response response1;

    Response<Collection<StateMaster>> resStates;
    GenericType<Response<Collection<StateMaster>>> gresStates;
    Response<Collection<CityMaster>> resCities;
    GenericType<Response<Collection<CityMaster>>> gresCities;
    GenericType<Response> gresponse1;

    Response<Boolean> resIfExists;
    GenericType<Response<Boolean>> gresIfExists;

    Collection<StateMaster> states;
    Collection<CityMaster> cities;

    Pbkdf2PasswordHashImpl pb;

    String firstName, lastName, uname, email, password, address;
    Integer stateid, isClient;
    Integer cityid;
    UploadedFile userImage;
    boolean isLoggedin;

    public SignupBean() {
        client = new AdminClient();
        gresStates = new GenericType<Response<Collection<StateMaster>>>() {
        };
        gresCities = new GenericType<Response<Collection<CityMaster>>>() {
        };
        gresponse1 = new GenericType<Response>() {
        };
        resIfExists = new Response<>();
        gresIfExists = new GenericType<Response<Boolean>>() {
        };
        pb = new Pbkdf2PasswordHashImpl();
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Response<Collection<StateMaster>> getResStates() {
        return resStates;
    }

    public Collection<StateMaster> getStates() {
        response = client.getAllState(javax.ws.rs.core.Response.class);
        resStates = response.readEntity(gresStates);
        states = (Collection<StateMaster>) resStates.getResult();
        return states;
    }

    public void setStates(Collection<StateMaster> states) {
        this.states = states;
    }

    public void setResStates(Response<Collection<StateMaster>> resStates) {
        this.resStates = resStates;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Response<Collection<CityMaster>> getResCities() {
        return resCities;
    }

    public void setResCities(Response<Collection<CityMaster>> resCities) {
        this.resCities = resCities;
    }

    public Collection<CityMaster> getCities() {
        return cities;
    }

    public void setCities(Collection<CityMaster> cities) {
        this.cities = cities;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = pb.generate(password.toCharArray());
    }

    public UploadedFile getUserImage() {
        return userImage;
    }

    public void setUserImage(UploadedFile userImage) {
        this.userImage = userImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIsLoggedin() {
        isLoggedin = KeepRecord.isIsLoggedin();
        return isLoggedin;
    }

    public void setIsLoggedin(boolean isLoggedin) {
        this.isLoggedin = isLoggedin;
    }

    public Integer getIsClient() {
        return isClient;
    }

    public void setIsClient(Integer isClient) {
        this.isClient = isClient;
    }

    public void onStateChange() {
        if (stateid != null && !stateid.equals("")) {
            response = client.getAllCitiesByState(javax.ws.rs.core.Response.class, String.valueOf(stateid));
            resCities = response.readEntity(gresCities);
            cities = (List<CityMaster>) resCities.getResult();
        } else {
            cities = new ArrayList<CityMaster>();
        }
    }

    public void checkUsernameExists(FacesContext ctx, UIComponent component, Object value) {
        String username = (String) value;
        if (!username.equals("")) {
            response = client.checkifUsernameExists(javax.ws.rs.core.Response.class, username);
            resIfExists = response.readEntity(gresIfExists);
            if(resIfExists.getResult().equals(true)) {
                FacesMessage msg = new FacesMessage("Username already exists!");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void checkEmailExists(FacesContext ctx, UIComponent component, Object value) {
        String emailValue = (String) value;
        if (!emailValue.equals("")) {
            response = client.checkifEmailExists(javax.ws.rs.core.Response.class, emailValue);
            resIfExists = response.readEntity(gresIfExists);
            if(resIfExists.getResult().equals(true)) {
                FacesMessage msg = new FacesMessage("Email already exists!");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    public void onSubmit() {

        try {
            InputStream imageInputStream = userImage.getInputStream();
            String uploadedImageName = userImage.getFileName();

            String ext = uploadedImageName.substring(uploadedImageName.indexOf("."), uploadedImageName.length());
            Random random = new Random();
            String imageName = uname + "_" + random.nextInt(1000) + ext;
            System.out.println("Image Name: " + imageName);

            File uploadedImage = new File("D:\\Sem8\\Project\\PilgrimWorldf\\src\\main\\webapp\\images\\users\\" + imageName);
            Files.copy(imageInputStream, uploadedImage.toPath(), StandardCopyOption.REPLACE_EXISTING);

            Request req = new Request();
            UserMaster user = new UserMaster();
            user.setFirstname(firstName);
            user.setLastname(lastName);
            user.setUsername(uname);

            user.setUserImage(imageName);

            user.setAddress(address);
            StateMaster state = new StateMaster();
            state.setStateId(stateid);
            user.setState(state);
            CityMaster city = new CityMaster();
            city.setCityId(cityid);
            user.setCity(city);

            user.setEmail(email);
            user.setPassword(password);

            GroupMaster group = new GroupMaster();
            if (isClient != null) {
                group.setGroupId(2);
            } else {
                group.setGroupId(3);
            }
            user.setGroup(group);

            req.setData(user);

            response = client.adduser(req, javax.ws.rs.core.Response.class);
            response1 = response.readEntity(gresponse1);
            if (response1.isStatus()) {
                addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Registration completed! Login to continue.");
//            return "signin.jsf";
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Registration not completed! ");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String isPilgrimClient() {
        isClient = 1;
        return "signup.jsf?faces-redirect=true";
    }
}
