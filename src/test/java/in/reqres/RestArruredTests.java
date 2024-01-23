package in.reqres;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;


public class RestArruredTests {

    @Test
    void getSingleResourceTest() {
        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.year", is(2001))
                .body("data.pantone_value",is("17-2031"));
    }

    @Test
    void postCreateTest() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }

    @Test
    void putUpdateTest() {
        String data = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";

        given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }

    @Test
    void deleteTest() {
        given()
                .log().uri()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

    @Test
    void postSuccessfulRegisterTest() {
        String data = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    void postUnsuccessfulRegisterTest() {
        String data = "{ \"email\": \"sydney@fife\" }";

        given()
                .log().uri()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
