package com.fparareda.charging.controller;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ChargingControllerTest {

    private static final String MARSROVER_CHARGING = "/api/v1/charge/3";

    @Test
    public void when_put_marsrovers_in_charge_thenSuccess() {
        String token = obtainAccessToken("testjwtclientid", "XY7kmzoNzl100","user2", "pwd2");

        given().header(new Header("Authorization", "Bearer " + token))
                .when().put(MARSROVER_CHARGING)
                .then()
                .assertThat()
                .body("id", equalTo(3))
                .body("charging", equalTo(true));

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
