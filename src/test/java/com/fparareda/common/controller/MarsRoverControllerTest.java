package com.fparareda.common.controller;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MarsRoverControllerTest {

    private static final String MARSROVER_FINDSECOND = "/api/v1/marsrover/2";
    private static final String MARSROVER_NO_EXIST = "/api/v1/marsrover/6584";

    @Test
    public void should_return_the_first_rover(){
        given().when().get(MARSROVER_FINDSECOND)
                .then()
                .assertThat()
                .body("id", equalTo(2))
                .body("charging", equalTo(false));
    }

    @Test
    public void should_return_the_non_existing_rover_thenError(){
        given().when().get(MARSROVER_NO_EXIST)
                .then().statusCode(400);
    }
}
