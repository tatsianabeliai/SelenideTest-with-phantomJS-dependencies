package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeTest;

public class TestBase {

    @BeforeTest
    public void configure() {
        Configuration.timeout = 10000;
        Configuration.baseUrl = "http://the-internet.herokuapp.com/";
        Configuration.browser = WebDriverRunner.FIREFOX;
    }
}
