package in.reqres.tests;

import in.reqres.model.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.helpers.Endpoints.*;
import static in.reqres.specs.Specs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;


public class RestArruredTests {

    @Test
    @DisplayName("Check single resource")
    @Severity(SeverityLevel.NORMAL)
    void getSingleResourceTest() {
        step("Verify year and pantoneValue", () -> {
            SingleResourceResp resp = given()
                    .spec(baseRequestSpec)
                    .get(SINGLE_RESOURCE)
                    .then()
                    .spec(baseResponseSpecCode200)
                    .extract().as(SingleResourceResp.class);
            assertThat(resp.getData().getYear()).isEqualTo(2001);
            assertThat(resp.getData().getPantoneValue()).isEqualTo("17-2031");
        });
    }

    @Test
    @DisplayName("Check post create")
    @Severity(SeverityLevel.NORMAL)
    void postCreateTest() {
        String name = "morpheus";
        String job = "leader";

        step("Check new username and job", () -> {
            CreateUserPayload data = new CreateUserPayload();
            data.setName(name);
            data.setJob(job);
            PostCreatedResp resp = given()
                    .spec(baseRequestSpec)
                    .body(data)
                    .when()
                    .post(UPDATE_USERS)
                    .then()
                    .spec(baseResponseSpecCode201)
                    .extract().as(PostCreatedResp.class);
            assertThat(resp.getName()).isEqualTo(name);
            assertThat(resp.getJob()).isEqualTo(job);
        });
    }

    @Test
    void putUpdateTest() {
        String name = "morpheus";
        String job = "zion resident";

        step("Check new username and job", () -> {
            CreateUserPayload data = new CreateUserPayload();
            data.setName(name);
            data.setJob(job);
            PutUpdateResp resp = given()
                    .spec(baseRequestSpec)
                    .body(data)
                    .when()
                    .put(PUT_DELETE_USERS)
                    .then()
                    .spec(baseResponseSpecCode200)
                    .extract().as(PutUpdateResp.class);
            assertThat(resp.getName()).isEqualTo(name);
            assertThat(resp.getJob()).isEqualTo(job);
        });
    }

    @Test
    void deleteTest() {

        step("Check delete users", () -> {
            given()
                    .spec(baseRequestSpec)
                    .when()
                    .delete(PUT_DELETE_USERS)
                    .then()
                    .spec(baseResponseSpecCode204);
        });
    }

    @Test
    void postSuccessfulRegisterTest() {
        String email = "eve.holt@reqres.in";
        String password = "pistol";

        step("Check normal registration", () -> {
            RegisterPayload data = new RegisterPayload();
            data.setEmail(email);
            data.setPassword(password);
            RegisterPayload.RegisterResponse response = given()
                    .spec(baseRequestSpec)
                    .body(data)
                    .when()
                    .post(REGISTER)
                    .then()
                    .spec(baseResponseSpecCode200)
                    .extract().as(RegisterPayload.RegisterResponse.class);
            assertThat(response.getToken()).isNotNull();
            assertThat(response.getId()).isNotNull();
        });
    }

    @Test
    void postUnsuccessfulRegisterTest() {
        String email = "sydney@fife";

        step("Check bad registration", () -> {
            RegisterPayload data = new RegisterPayload();
            data.setEmail(email);
            RegisterPayload.RegisterResponse response = given()
                    .spec(baseRequestSpec)
                    .body(data)
                    .when()
                    .post(REGISTER)
                    .then()
                    .spec(baseResponseSpecCode400)
                    .extract().as(RegisterPayload.RegisterResponse.class);
            assertThat(response.getError()).isNotNull();
            assertThat(response.getError()).isEqualTo("Missing password");
        });
    }
}
