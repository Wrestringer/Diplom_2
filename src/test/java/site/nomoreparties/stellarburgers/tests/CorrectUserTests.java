package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;

import static constants.Messages.*;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsUser.*;
import static utils.Utils.randomString;

public class CorrectUserTests extends BaseTest {

    @Test
    @DisplayName("Изменение пользователя /api/auth/user")
    @Description("Изменнеие имени пользователя с авторизацией")
    public void patchCorrectUserNameWithAuthTest() {

        user.setName(randomString());

        Response response = sendPatchRequestToCorrectUserData(user, registeredUser.getAccessToken());
        compareMessageFromResponse(response, 200, SUCCESS_CORRECT_USER_MESSAGE_RESPONSE);

    }

    @Test
    @DisplayName("Изменение пользователя /api/auth/user")
    @Description("Изменнеие почты пользователя с авторизацией")
    public void patchCorrectUserEmailWithAuthTest() {

        user.setEmail(randomString() + "@ya.ru");

        Response response = sendPatchRequestToCorrectUserData(user, registeredUser.getAccessToken());
        compareMessageFromResponse(response, 200, SUCCESS_CORRECT_USER_MESSAGE_RESPONSE);

    }

    @Test
    @DisplayName("Изменение пользователя /api/auth/user")
    @Description("Изменнеие пароля пользователя с авторизацией")
    public void patchCorrectUserPasswordWithAuthTest() {

        user.setPassword(randomString());

        Response response = sendPatchRequestToCorrectUserData(user, registeredUser.getAccessToken());
        compareMessageFromResponse(response, 200, SUCCESS_CORRECT_USER_MESSAGE_RESPONSE);

    }

    @Test
    @DisplayName("Изменение пользователя /api/auth/user")
    @Description("Изменнеие пользователя без авторизации")
    public void patchCorrectUserWithoutAuthTest() {

        Response response = sendPatchRequestToCorrectUserData(user, "");
        compareMessageFromResponse(response, 401, FAIL_DO_SOMETHING_WITH_USER_WITHOUT_AUTH_MESSAGE_RESPONSE);

    }

}
