package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;

import java.util.List;

import static constants.Ingredients.*;
import static constants.Messages.SUCCESS_CORRECT_USER_MESSAGE_RESPONSE;
import static constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsOrder.sendPostRequestToCreateOrder;

public class CreateOrderWithoutAuthTests extends BaseTest {

    Order order;


    @Before
    public void setUp() {
        RestAssured.baseURI= STELLARBURGERS_NOMOREPARTIES_PROD;
    }


    @Test
    @DisplayName("Создание заказа /api/orders")
    @Description("Создание заказа авторизованного пользователя с параметрами")
    public void postCreateOrderWithAuthTest() {

        order = new Order();
        order.setIngredients(List.of(INGREDIENT_BUN_R2D2, INGREDIENT_SAUCE_SPICYX, INGREDIENT_SAUCE_GALAXY));

        Response response = sendPostRequestToCreateOrder("", order);
        compareMessageFromResponse(response, 200, SUCCESS_CORRECT_USER_MESSAGE_RESPONSE);
    }

    @After
    public void tearDown() {
    }
}
