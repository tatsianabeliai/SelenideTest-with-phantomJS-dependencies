package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class FactoryHomePage {

    @FindBy(id = "flash")
    public SelenideElement flash;

    @FindBy(css = "a.button")
    public SelenideElement logoutButton;

    public FactoryRegistrationPage logout() {
        logoutButton.click();
        return page(FactoryRegistrationPage.class);
    }
}
