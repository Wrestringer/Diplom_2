package site.nomoreparties.stellarburgers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.RegisteredUser;
import models.User;
import org.junit.After;
import org.junit.Before;

import static constants.Messages.SUCCESS_CREATE_USER_MESSAGE_RESPONSE;
import static constants.Uri.STELLARBURGERS_NOMOREPARTIES_PROD;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsUser.sendDeleteUserRequest;
import static site.nomoreparties.stellarburgers.steps.StepsUser.sendPostRequestToCreateUser;
import static utils.Utils.randomString;

public class BaseTest {

    private static final String RANDOM_EMAIL_OF_USER = randomString() + "@ya.ru";
    private static final String RANDOM_LOGIN_OF_USER = randomString();
    private static final String RANDOM_PASSWORD_OF_USER = randomString();
    protected User user;
    protected RegisteredUser registeredUser;

    @Before
    public void setUp() {
        RestAssured.baseURI= STELLARBURGERS_NOMOREPARTIES_PROD;

        user = new User(RANDOM_EMAIL_OF_USER, RANDOM_LOGIN_OF_USER, RANDOM_PASSWORD_OF_USER);

        Response response = sendPostRequestToCreateUser(user);
        compareMessageFromResponse(response, 200, SUCCESS_CREATE_USER_MESSAGE_RESPONSE);

        registeredUser = response.as(RegisteredUser.class);
    }

    @After
    public void tearDown() {
        sendDeleteUserRequest(user, registeredUser.getAccessToken());
    }
}
