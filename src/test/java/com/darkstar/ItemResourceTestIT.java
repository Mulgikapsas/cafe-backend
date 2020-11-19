package com.darkstar;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ItemResourceTestIT {

    @Test
    public void testMetricEndpoint() {
        given()
                .when().get("/metrics")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    public void testItemsEndpoint() {
        given()
                .when().get("/api/items")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

}
