package constants;

public class Messages {
    public static final String SUCCESS_CREATE_USER_MESSAGE_RESPONSE = "{success=true";
    public static final String FAIL_CREATE_USER_ALREADY_EXIST_MESSAGE_RESPONSE = "{success=false, message=User already exists}";
    public static final String FAIL_CREATE_INCORRECT_USER_MESSAGE_RESPONSE = "{success=false, message=Email, password and name are required fields}";
    public static final String SUCCESS_LOGIN_USER_MESSAGE_RESPONSE = "{success=true";
    public static final String FAIL_LOGIN_INCORRECT_USER_MESSAGE_RESPONSE = "{success=false, message=email or password are incorrect}";
    public static final String SUCCESS_CORRECT_USER_MESSAGE_RESPONSE = "{success=true";
    public static final String FAIL_DO_SOMETHING_WITH_USER_WITHOUT_AUTH_MESSAGE_RESPONSE = "{success=false, message=You should be authorised}";
    public static final String FAIL_CREATE_ORDER_WITHOUT_INGREDIENTS_MESSAGE_RESPONSE = "{success=false, message=Ingredient ids must be provided}";

}