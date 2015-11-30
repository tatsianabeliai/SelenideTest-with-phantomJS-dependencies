import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.testng.BrowserPerClass;
import core.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FactoryHomePage;
import pages.FactoryRegistrationPage;
import pages.StaticHomePage;
import pages.StaticRegistrationPage;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@Listeners(BrowserPerClass.class)
public class SelenideExamplesTest extends TestBase {
    private FactoryHomePage homePage;
    private FactoryRegistrationPage registrationPage;

    @BeforeMethod
    public void setup() {
        registrationPage = open("login", FactoryRegistrationPage.class);
    }

    @Test
    public void simpleLoginTest() {
        $("#username").val("tomsmith");
        $("#password").val("SuperSecretPassword!");
        $("button[type='submit']").click();
        $("#flash").should(appear, cssClass("success"), text("You logged into a secure area!"));
    }

    @Test
    public void staticPageLoginTest() {
        StaticRegistrationPage.login("tomsmith", "SuperSecretPassword!");
        $(StaticHomePage.FLASH).should(appear, cssClass("success"), text("You logged into a secure area!"));
    }

    @Test
    public void staticPageLogoutTest() {
        StaticRegistrationPage.login("tomsmith", "SuperSecretPassword!");
        StaticHomePage.logout();
        $(StaticRegistrationPage.FLASH).should(appear, cssClass("success"), text("You logged out of the secure area!"));
    }

    @Test
    public void factoryPageLoginTest() {
        homePage = registrationPage.login("tomsmith", "SuperSecretPassword!");
        homePage.flash.should(appear, cssClass("success"), text("You logged into a secure area!"));
    }

    @Test
    public void factoryPageLogoutTest() {
        homePage = registrationPage.login("tomsmith", "SuperSecretPassword!");
        registrationPage = homePage.logout();
        registrationPage.flash.should(appear, cssClass("success"), text("You logged out of the secure area!"));
    }

    @Test
    public void theInternetLinksCheckerTest() throws IOException {
        open("");
        List<String> data = helpers.Helpers.readAllLines("./src/main/resources/theInternetLinks.txt");
        String[] links = data.toArray(new String[data.size()]);
        $$("ul > li >a").shouldHave(CollectionCondition.texts(links));
    }

}
