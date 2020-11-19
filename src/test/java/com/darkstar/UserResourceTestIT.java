package com.darkstar;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class UserResourceTestIT {

    @Test
    public void testMetricEndpoint() {
        given()
                .when().get("/api/assignees/1")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testItemsEndpoint() {
        given()
                .when().get("/api/customers/1")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

}
