package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.RegisteredUser;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;

import static constants.Messages.*;
import static constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsUser.*;
import static utils.Utils.randomString;

public class LogInUserTests extends BaseTest {


    @Test
    @DisplayName("Авторизация пользователя /api/auth/login")
    @Description("Авторизация пользователя с корректными данными")
    public void postAuthUserWithCorrectDataTest() {

        Response response = sendPostRequestToLogInUser(user);
        compareMessageFromResponse(response, 200, SUCCESS_LOGIN_USER_MESSAGE_RESPONSE);

    }

    @Test
    @DisplayName("Авторизация пользователя /api/auth/login")
    @Description("Авторизация пользователя с некорректными данными")
    public void postAuthUserWithIncorrectDataTest() {

        user.setName(randomString());
        user.setPassword(randomString());

        Response response = sendPostRequestToLogInUser(user);
        compareMessageFromResponse(response, 401, FAIL_LOGIN_INCORRECT_USER_MESSAGE_RESPONSE);

    }

}
