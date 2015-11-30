package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static helpers.Locators.get;

public class StaticRegistrationPage {
    public final static By USER_NAME_FIELD = get("registerPage.userNameField");
    public final static By PASSWORD_FIELD = get("registerPage.passwordField");
    public final static By LOGIN_BUTTON = get("registerPage.loginButton");
    public final static By FLASH = get("registerPage.flash");

    public static void login(String user, String pass) {
        $(USER_NAME_FIELD).val(user);
        $(PASSWORD_FIELD).val(pass);
        $(LOGIN_BUTTON).click();
    }
}
