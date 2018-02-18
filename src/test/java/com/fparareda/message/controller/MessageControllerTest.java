package com.fparareda.message.controller;

import com.fparareda.common.exception.EntityNotFoundException;
import com.fparareda.common.model.MarsRover;
import com.fparareda.messages.model.Message;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MessageControllerTest {

    private static final String MARSROVER_MESSAGE = "/api/v1/message/2";

    @Test
    public void when_send_message_to_mars_thenSuccess() throws EntityNotFoundException {
        String token = obtainAccessToken("testjwtclientid", "XY7kmzoNzl100","user2", "pwd2");
        MarsRover marsRover = findMarsRover(2l);
        given().header(new Header("Authorization", "Bearer " + token))
                .contentType(ContentType.JSON)
                .body(new Message(1l, marsRover, new Date(), "Hello Mars!"))
                .when().put(MARSROVER_MESSAGE)
                .then()
                .assertThat()
                .body("message", equalTo("Hello Mars!"));
    }

    private MarsRover findMarsRover(Long marsRoversId) throws EntityNotFoundException {
        return new MarsRover(1l, null, false);
    }

    private String obtainAccessToken(
            String clientId, String secret, String username, String password) {

        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        Response response = RestAssured.given()
                .auth().preemptive().basic(clientId, secret)
                .and().with().params(params).when()
                .post("http://localhost:8080/oauth/token");
        return response.jsonPath().getString("access_token");
    }
}
