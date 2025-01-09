package com.payd.xchange.controller;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;

public class ExchangeControllerTest extends BaseIT {

    @Test
    void exchangeShouldSuccess() {
        given(this.spec)
                .contentType(ContentType.JSON)
                .body(dto)
                .filter(document("{methodName}"))
                .when()
                .post("/exchange")
                .then()
                .assertThat()
                .statusCode(200)
                .body("rate", notNullValue())
                .body("rate", equalTo(35.6F));
    }

    @Test
    void convertShouldSuccess() {
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
    }

}
