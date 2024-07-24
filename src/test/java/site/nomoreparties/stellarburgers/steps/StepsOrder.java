package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.Order;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StepsOrder {

    @Step("Send GET request to /api/orders")
    public static Response sendGetRequestToGetOrdersUser(String token){
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .get("/api/orders");
    }

    @Step("Send POST request to /api/orders")
    public static Response sendPostRequestToCreateOrder(String token, Order order){
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .and()
                .body(order)
                .post("/api/orders");
    }

}
