package lesson18;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DemoWebShopTest {
    @BeforeAll
    static void seyUp() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com/";
    }

    @Test
    void addToCart() {
        String data = "product_attribute_72_5_18=52&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";
        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body(data)
                        .when()
                        .post("addproducttocart/details/72/1")
                        .then()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                        .body("updatetopcartsectionhtml", is("(1)"))
                        .extract().response();
        System.out.println(response.asString());
    }

    @Test
    void addToCartWithCookie() {
        String data = "product_attribute_72_5_18=52&product_attribute_72_6_19=54&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";
        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body(data)
                        .cookie("Nop.customer=4ef7af8e-fe1e-44da-99de-e537158c51f0;")
                        .when()
                        .post("addproducttocart/details/72/1")
                        .then()
                        .statusCode(200)
                        .body("success", is(true))
                        .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                        .body("updatetopcartsectionhtml", is("(32)"))
                        .extract().response();
        System.out.println(response.asString());
    }
}
