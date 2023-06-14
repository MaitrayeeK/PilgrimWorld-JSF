/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package com.pilgrim.clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:CustomerResource
 * [customer]<br>
 * USAGE:
 * <pre>
 *        CustomerClient client = new CustomerClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dell
 */
public class CustomerClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PilgrimWorld/resources";

    public CustomerClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("customer");
    }

    public <T> T addBooking(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("bookings/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateBooking(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("bookings/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPaymentsByPilgrim(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("payments/getByPilgrim").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getBookingsByPilgrim(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("bookings/getByPilgrim/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPaymentsByUser(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("payments/getByUser").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addFeedback(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("feedbacks/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removeFeedback(Class<T> responseType, String feedbackid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("feedbacks/delete/{0}", new Object[]{feedbackid})).request().delete(responseType);
    }

    public <T> T getPaymentsByBooking(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("payments/getByBooking").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getPayments(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("payments");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T removeBooking(Class<T> responseType, String bookingid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("bookings/delete/{0}", new Object[]{bookingid})).request().delete(responseType);
    }

    public <T> T getFeedbacks(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("feedbacks");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T updatePayment(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("payments/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getFeedbacksByUser(Class<T> responseType, String userid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbacks/getByUser/{0}", new Object[]{userid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getBookings(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("bookings");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getBookingByUser(Class<T> responseType, String userid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("bookings/getByUser/{0}", new Object[]{userid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getFeedbacksByPilgrim(Class<T> responseType, String pilgrimid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("feedbacks/getByPilgrim/{0}", new Object[]{pilgrimid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T addPayment(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("payments/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T updateFeedback(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("feedbacks/update").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T removePayment(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("payments/delete").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public void close() {
        client.close();
    }
    
}
