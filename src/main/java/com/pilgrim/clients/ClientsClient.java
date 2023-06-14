/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package com.pilgrim.clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ClientResource [client]<br>
 * USAGE:
 * <pre>
 *        ClientsClient client = new ClientsClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class ClientsClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PilgrimWorld/resources";

    public ClientsClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("client");
    }

    public <T> T removePilgrimImages(Class<T> responseType, String pimagesid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("pilgrimImages/delete/{0}", new Object[]{pimagesid})).request().delete(responseType);
    }

    public <T> T updatePilgrimImages(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimImages/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addPilgrimRooms(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimRooms/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removeAdvertisement(Class<T> responseType, String advertisementid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("advertisements/delete/{0}", new Object[]{advertisementid})).request().delete(responseType);
    }

    public <T> T getPilgrimsByState(Class<T> responseType, String stateid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrims/getByState/{0}", new Object[]{stateid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPilgrimRooms(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimRooms/getByPilgrim/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPilgrimsByCity(Class<T> responseType, String cityid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrims/getByCity/{0}", new Object[]{cityid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addPilgrim(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrims/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updatePilgrim(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrims/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateAdvertisement(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("advertisements/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addPilgrimTimeslotsDetails(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslotsDetails/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateDiscount(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("discounts/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removePilgrimTicket(Class<T> responseType, String pticketid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("pilgrimTickets/delete/{0}", new Object[]{pticketid})).request().delete(responseType);
    }

    public <T> T getPilgrimsByStateCity(Class<T> responseType, String stateid, String cityid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrims/getByStateCity/{0}/{1}", new Object[]{stateid, cityid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T updatePilgrimRooms(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimRooms/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addPilgrimImages(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimImages/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removeDiscount(Class<T> responseType, String discountid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("discounts/delete/{0}", new Object[]{discountid})).request().delete(responseType);
    }

    public <T> T getTicketsByPilgrim(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimTickets/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPilgrimsById(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrims/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAdvertisementByPilgrim(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("advertisements/getByPilgrim/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T updatePilgrimTimeslots(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslots/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removePilgrimTimeslots(Class<T> responseType, String ptimeslotsid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("pilgrimTimeslots/delete/{0}", new Object[]{ptimeslotsid})).request().delete(responseType);
    }

    public <T> T getTicketsByPTimeSlotsDetails(Class<T> responseType, String ptimeslotsdetailsid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimTickets/getByPTimeSlotsDetails/{0}", new Object[]{ptimeslotsdetailsid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPilgrimTimeslots(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimTimeslots/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPilgrimRoomsById(Class<T> responseType, String proomid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimRooms/{0}", new Object[]{proomid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addPilgrimTimeslots(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslots/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getDiscounts(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("discounts");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addPilgrimTicket(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTickets/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getAdvertisements(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("advertisements");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T removePilgrimTimeslotsDetails(Class<T> responseType, String ptimeslotsdetailsid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("pilgrimTimeslotsDetails/delete/{0}", new Object[]{ptimeslotsdetailsid})).request().delete(responseType);
    }

    public <T> T removePilgrim(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("pilgrims/delete/{0}", new Object[]{pilgrimid})).request().delete(responseType);
    }

    public <T> T getPilgrimTimeslotsDetails(Class<T> responseType, String ptimeslotsid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimTimeslotsDetails/{0}", new Object[]{ptimeslotsid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addDiscount(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("discounts/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimImages(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("pilgrimImages/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T updatepilgrimTimeslotsDetails(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslotsDetails/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updatePilgrimTicket(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTickets/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removePilgrimRooms(Class<T> responseType, String proomsid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("pilgrimRooms/delete/{0}", new Object[]{proomsid})).request().delete(responseType);
    }

    public <T> T addAdvertisement(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("advertisements/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrims(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("pilgrims");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
