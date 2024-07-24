package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import site.nomoreparties.stellarburgers.BaseTest;

import java.util.List;

import static constants.Ingredients.*;

import static constants.Messages.*;
import static site.nomoreparties.stellarburgers.steps.StepsCompare.compareMessageFromResponse;
import static site.nomoreparties.stellarburgers.steps.StepsOrder.sendPostRequestToCreateOrder;
import static utils.Utils.randomString;


@RunWith(Parameterized.class)
public class CreateOrderWithAuthTests extends BaseTest {

    Order order;

    @Parameterized.Parameter
    public List <String> ingredients;
    @Parameterized.Parameter(1)
    public int code;
    @Parameterized.Parameter(2)
    public String message;

    @Parameterized.Parameters(name = "{index} Сценарий проверки с токеном: {0} и хэшом игредиентов: {0}. Код ответа: {1}. Сообщение из ответа: {2}.")
    public static Object[][] data() {
        return new Object[][] {
                { List.of(INGREDIENT_BUN_R2D2, INGREDIENT_SAUCE_SPICYX, INGREDIENT_SAUCE_GALAXY), 200, SUCCESS_CORRECT_USER_MESSAGE_RESPONSE},
                { null, 400, FAIL_CREATE_ORDER_WITHOUT_INGREDIENTS_MESSAGE_RESPONSE},
                { List.of(randomString(), randomString(), randomString()), 500, ""}
        };
    }




    @Test
    @DisplayName("Создание заказа /api/orders")
    @Description("Создание заказа авторизованного пользователя с параметрами")
    public void postCreateOrderWithAuthTest() {

        order = new Order();
        order.setIngredients(ingredients);

        Response response = sendPostRequestToCreateOrder(registeredUser.getAccessToken(), order);
        compareMessageFromResponse(response, code, message);
    }

}
