package site.nomoreparties.stellarburgers.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Assert;

public class StepsCompare {

    @Step("Compare Message from response")
    public static void compareMessageFromResponse(Response response, int statusCode, String message){
        String messageFromResponse = response.then().statusCode(statusCode).assertThat().extract().path("").toString();
        Assert.assertTrue(messageFromResponse.contains(message));
    }

}
