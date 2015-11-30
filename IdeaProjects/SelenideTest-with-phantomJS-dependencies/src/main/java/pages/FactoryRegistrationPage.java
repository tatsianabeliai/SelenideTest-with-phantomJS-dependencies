package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class FactoryRegistrationPage {

    @FindBy(id = "username")
    public SelenideElement userName;

    @FindBy(id = "password")
    public SelenideElement password;

    @FindBy(css = "button[type='submit']")
    public SelenideElement loginButton;

    @FindBy(id = "flash")
    public SelenideElement flash;

    public FactoryHomePage login(String user, String pass) {
        userName.val(user);
        password.val(pass);
        loginButton.click();
        return page(FactoryHomePage.class);
    }
}
