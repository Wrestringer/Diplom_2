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

public class RegistrationUserPositiveTests extends BaseTest {


    private static final String RANDOM_EMAIL_OF_USER = randomString() + "@ya.ru";
    private static final String RANDOM_LOGIN_OF_USER = randomString();
    private static final String RANDOM_PASSWORD_OF_USER = randomString();
    User user;
    Response response;
    RegisteredUser registeredUser;

    @Before
    public void setUp() {
        RestAssured.baseURI= STELLARBURGERS_NOMOREPARTIES_PROD;
    }

    @Test
    @DisplayName("Создание пользователя /api/auth/register")
    @Description("Создаение пользователя с корректными данными")
    public void postCreateUserWithCorrectDataTest() {
        user = new User(RANDOM_EMAIL_OF_USER, RANDOM_LOGIN_OF_USER, RANDOM_PASSWORD_OF_USER);

        response = sendPostRequestToCreateUser(user);
        compareMessageFromResponse(response, 200, SUCCESS_CREATE_USER_MESSAGE_RESPONSE);

    }


    @Test
    @DisplayName("Создание пользователя /api/auth/register")
    @Description("Создаение пользователя, который уже есть в системе")
    public void postCreateUserWhatAlreadyExistTest() {
        user = new User(RANDOM_EMAIL_OF_USER, RANDOM_LOGIN_OF_USER, RANDOM_PASSWORD_OF_USER);

        response = sendPostRequestToCreateUser(user);
        compareMessageFromResponse(response, 200, SUCCESS_CREATE_USER_MESSAGE_RESPONSE);

        Response responseFromSecondCreateUser = sendPostRequestToCreateUser(user);
        compareMessageFromResponse(responseFromSecondCreateUser, 403, FAIL_CREATE_USER_ALREADY_EXIST_MESSAGE_RESPONSE);


    }



    @After
    public void tearDown() {
        registeredUser = response.as(RegisteredUser.class);
        sendDeleteUserRequest(user, registeredUser.getAccessToken());
    }


}
