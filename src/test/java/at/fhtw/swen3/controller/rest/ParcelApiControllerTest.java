package at.fhtw.swen3.controller.rest;

import at.fhtw.swen3.persistence.entities.HopArrivalEntity;
import at.fhtw.swen3.persistence.entities.ParcelEntity;
import at.fhtw.swen3.persistence.entities.RecipientEntity;
import at.fhtw.swen3.services.ParcelService;
import at.fhtw.swen3.services.dto.Parcel;
import at.fhtw.swen3.services.dto.Recipient;
import at.fhtw.swen3.services.impl.ParcelServiceImpl;
import at.fhtw.swen3.util.UuidGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.util.Json;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParcelApiControllerTest {
    static String BASEURL = "http://swkomspringbootdeploy-env.eba-ua9zansy.us-east-1.elasticbeanstalk.com/parcel";
    Parcel parcel;
    ObjectMapper objectMapper;
    @BeforeEach
    void init(){
        Recipient recipient = new Recipient();
        recipient.setName("Rudi");
        recipient.setStreet("Hauptstrasse 2");
        recipient.postalCode("A-1020");
        recipient.city("Vienna");
        recipient.country("Austria");

        parcel = new Parcel();
        parcel.setWeight((float)1);
        parcel.setRecipient(recipient);
        parcel.setSender(recipient);
    }

    @Test
    void OK_submitParcel() throws IOException, InterruptedException {
        objectMapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASEURL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(parcel)))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(201, response.statusCode());
        assertTrue(response.body().contains("trackingId"));
    }

    @Test
    void FAIL_submitParcel() throws IOException, InterruptedException {
        objectMapper = new ObjectMapper();
        parcel.setWeight((float)-1);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASEURL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(parcel)))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(400, response.statusCode());
        assertTrue(response.body().contains("error"));
    }

    @Test
    void OK_transitionParcel() throws IOException, InterruptedException {
        String uuid = UuidGenerator.generateTrackingId();
        StringBuilder builder = new StringBuilder();
        builder.append(BASEURL);
        builder.append("/" + uuid);
        objectMapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(builder.toString()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(parcel)))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(201, response.statusCode());
        assertTrue(response.body().contains("trackingId"));
    }

    @Test
    void FAIL_transitionParcel() throws IOException, InterruptedException {
        String uuid = UuidGenerator.generateTrackingId();
        parcel.setWeight((float)-1);
        StringBuilder builder = new StringBuilder();
        builder.append(BASEURL);
        builder.append("/" + uuid);
        objectMapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(builder.toString()))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(parcel)))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(201, response.statusCode());
        assertTrue(response.body().contains("trackingId"));
    }
}