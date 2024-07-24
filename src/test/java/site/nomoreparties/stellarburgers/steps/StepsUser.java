package site.nomoreparties.stellarburgers.steps;

import models.RegisteredUser;
import models.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepsUser {


    @Step("Send POST request to /api/auth/register")
    public static Response sendPostRequestToCreateUser(User user){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
    }


    @Step("Send DELETE request to /api/auth/user")
    public static void sendDeleteUserRequest(User user, String token){
        given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .body(user)
                .when()
                .delete("/api/auth/user")
                .then().statusCode(202);
    }


    @Step("Send POST request to /api/auth/login")
    public static Response sendPostRequestToLogInUser(User user){
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post("/api/auth/login");
    }


    @Step("Send PATCH request to /api/auth/user")
    public static Response sendPatchRequestToCorrectUserData(User user, String token){
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .body(user)
                .patch("/api/auth/user");
    }


}
