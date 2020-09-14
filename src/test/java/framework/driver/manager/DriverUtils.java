package framework.driver.manager;

import io.qameta.allure.Step;

public class DriverUtils {
    // This class is created for setting special configuration of driver

    @Step("Maximizing browser window")
    public static void setInitialConfiguration() {

        DriverManager.getWebDriver().manage().window().maximize();
    }

    @Step("Navigating to URL: {pageUrl}")
    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
