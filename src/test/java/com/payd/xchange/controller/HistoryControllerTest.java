package com.payd.xchange.controller;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;

public class HistoryControllerTest extends BaseIT {

    @Test
    void findAllShouldSuccess() {
        given(this.spec)
                .contentType(ContentType.JSON)
                .body(dto)
                .filter(document("{methodName}"))
                .when()
                .post("/convert")
                .then()
                .assertThat()
                .statusCode(200)
                .body("rate", notNullValue())
                .body("rate", equalTo(35.6F));


        given(this.spec)
                .contentType(ContentType.JSON)
                .filter(document("{methodName}"))
                .when()
                .get("/find-all")
                .then()
                .assertThat()
                .statusCode(200)
                .body("$.size()", greaterThan(0));
    }
}
