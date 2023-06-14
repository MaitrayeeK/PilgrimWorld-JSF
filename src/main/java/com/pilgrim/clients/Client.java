/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package com.pilgrim.clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:ClientResource [client]<br>
 * USAGE:
 * <pre>
 *        Client client = new Client();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author maitr
 */
public class Client {

    private WebTarget webTarget;
    private javax.ws.rs.client.Client client;
    private static final String BASE_URI = "http://localhost:8080/PilgrimWorld/resources";

    public Client() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("client");
    }

    public <T> T updatePilgrimImages(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimImages/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addPilgrimRooms(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimRooms/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removeAdvertisement(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("advertisements/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimsByState(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrims/getByState").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimRooms(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimRooms").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimsByCity(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrims/getByCity").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
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

    public <T> T deletePilgrimRooms(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimRooms/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateDiscount(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("discounts/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removePilgrimTicket(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTickets/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimsByStateCity(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrims/getByStateCity").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updatePilgrimRooms(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimRooms/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addPilgrimImages(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimImages/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removeDiscount(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("discounts/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getTicketsByPilgrim(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTickets").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getAdvertisementByPilgrim(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("advertisements/getByPilgrim").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updatePilgrimTimeslots(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslots/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removePilgrimTimeslots(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslots/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T deletePilgrim(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrims/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimTimeslots(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslots").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
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

    public <T> T removePilgrimTimeslotsDetails(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslotsDetails/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimTimeslotsDetails(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslotsDetails").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addDiscount(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("discounts/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPilgrimImages(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimImages").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updatepilgrimTimeslotsDetails(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTimeslotsDetails/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updatePilgrimTicket(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimTickets/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T deletePilgrimImages(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("pilgrimImages/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
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
