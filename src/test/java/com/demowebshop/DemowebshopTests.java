package com.demowebshop;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class DemowebshopTests {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
    }

    @Test
    void addToCartAnonymTest() {
        String body = "product_attribute_72_5_18=65" +
                "&product_attribute_72_6_19=54" +
                "&product_attribute_72_3_20=57" +
                "&product_attribute_72_8_30=94" +
                "&addtocart_72.EnteredQuantity=3";

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(body)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is("(3)"));
    }

    @Test
    void changeAddressTest() {
        String cookieValue = "930055ECD04E072FB7BA311C7403B6320D74F74788EC5C7429EC39A912FAA194AD0B" +
                "0ED8668AF24506BDA3AFC489D78B8BBB891792C2A445F69E6602D392C9AD8EED72ABAFE1C8969F711" +
                "704C1842A55B653D38DD6BD1A4B7C2342A5498C51A2C36C5987480B3AC1D88E14ABCA561FDDF0BA84" +
                "574A08264D9E5D8448157426F9;",
        body = "product_attribute_72_5_18=65" +
                "&product_attribute_72_6_19=91" +
                "&product_attribute_72_3_20=58" +
                "&product_attribute_72_8_30=93" +
                "&product_attribute_72_8_30=94" +
                "&product_attribute_72_8_30=95" +
                "&addtocart_72.UpdatedShoppingCartItemId=3781168&addtocart_72.EnteredQuantity=55";

        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", cookieValue)
                .body(body)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message",is("The product has been added to your \u003ca href=\"/cart\"\u003eshopping cart\u003c/a\u003e"));
    }
}
