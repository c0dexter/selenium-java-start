package framework.tests;

import framework.driver.manager.DriverManager;
import framework.driver.manager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static framework.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
