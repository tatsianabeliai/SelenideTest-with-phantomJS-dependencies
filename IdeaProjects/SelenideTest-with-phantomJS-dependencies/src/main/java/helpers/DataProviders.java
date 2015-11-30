package helpers;

import org.testng.annotations.DataProvider;

public class DataProviders {
    private static final String REGISTRATION_DATA_FILE = "/RegistrationData.csv";

    @DataProvider(name = "registrationData")
    public Object[][] getRegistrationData() {
        return new Object[][] {
                {},
                {}
        };
    }
}
