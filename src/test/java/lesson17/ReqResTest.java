package lesson17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqResTest {
    @BeforeAll
    static void seyUp(){
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test
    void successfulLogin() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";
        given()
                .contentType(JSON)// указываем, что в запросе будет применён формат JSON
                .body(data)
                .when()
                .post("api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void negativeLogin() {
        String data = "{ \"email\": \"peter@klaven\" }";
        given()
                .contentType(JSON)
                .body(data)
                .when()
                .post("api/login")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}