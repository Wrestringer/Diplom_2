package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;

import static constants.Messages.FAIL_CREATE_INCORRECT_USER_MESSAGE_RESPONSE;
import static constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsUser.sendPostRequestToCreateUser;
import static utils.Utils.randomString;

public class RegistrationUserNegativeTests extends BaseTest {

    private static final String RANDOM_EMAIL_OF_USER = randomString() + "@ya.ru";
    private static final String RANDOM_LOGIN_OF_USER = randomString();
    User user;

    @Before
    public void setUp() {
        RestAssured.baseURI= STELLARBURGERS_NOMOREPARTIES_PROD;
    }

    @Test
    @DisplayName("Создание пользователя /api/auth/register")
    @Description("Создаение пользователя без пароля")
    public void postCreateUserWithoutPasswordTest() {
        user = new User(RANDOM_EMAIL_OF_USER, RANDOM_LOGIN_OF_USER, null);

        Response response = sendPostRequestToCreateUser(user);
        compareMessageFromResponse(response, 403, FAIL_CREATE_INCORRECT_USER_MESSAGE_RESPONSE);

    }

    @After
    public void tearDown() {
    }

}
