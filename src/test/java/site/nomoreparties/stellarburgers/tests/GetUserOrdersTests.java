package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;

import static constants.Messages.*;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsOrder.sendGetRequestToGetOrdersUser;

public class GetUserOrdersTests extends BaseTest {

    @Test
    @DisplayName("Получение заказов пользователя /api/orders")
    @Description("Получение заказов пользователя с авторизацией")
    public void getOrdersUserWithAuthTest() {

        Response response = sendGetRequestToGetOrdersUser(registeredUser.getAccessToken());
        compareMessageFromResponse(response, 200, SUCCESS_CORRECT_USER_MESSAGE_RESPONSE);

    }

    @Test
    @DisplayName("Получение заказов пользователя /api/orders")
    @Description("Получение заказов пользователя без авторизации")
    public void getOrdersUserWithoutAuthTest() {

        Response response = sendGetRequestToGetOrdersUser("");
        compareMessageFromResponse(response, 401, FAIL_DO_SOMETHING_WITH_USER_WITHOUT_AUTH_MESSAGE_RESPONSE);

    }

}
