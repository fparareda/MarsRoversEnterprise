package com.fparareda.navigation.controller;

import com.fparareda.common.model.Position;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class NavigationControllerTest {

    private static final String MARSROVER_NAVIGATION = "/api/v1/navigation/2";

    @Test
    public void when_the_marsrovers_is_moved_thenSuccess() {
        String token = obtainAccessToken("testjwtclientid", "XY7kmzoNzl100","user2", "pwd2");

        given().header(new Header("Authorization", "Bearer " + token))
                .contentType(ContentType.JSON)
                .body(new Position(1l, 987.34f, 764.23f))
                .when().put(MARSROVER_NAVIGATION)
                .then()
                .assertThat()
                .body("id", equalTo(2))
                .body("position.latitude", equalTo(987.34f))
                .body("position.longitude", equalTo(764.23f))
                .body("charging", equalTo(false));
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
