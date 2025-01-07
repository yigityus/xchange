package com.payd.xchange.controller;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.document;

public class EchoControllerTest extends BaseIT {

    @Test
    void echoShouldSuccess() {
        given(this.spec)
                .accept(ContentType.JSON)
                .filter(document("{methodName}"))
                .when()
                .get("/echo?name=Joe")
                .then()
                .assertThat()
                .statusCode(200);
    }

}
