package com.hexacta;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("Hello RESTEasy"));
    }

    @Test
    public void testHelloWithParameterEndpoint() {
        var name = UUID.randomUUID().toString();;
        given()
                .when().get("/hello/" + name)
                .then()
                .statusCode(200)
                .body(is("hola " + name));
    }

}