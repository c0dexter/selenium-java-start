package framework.driver.manager;

public class DriverUtils {
    // This class is created for setting special configuration of driver

    public static void setInitialConfiguration() {

        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String pageUrl) {
        DriverManager.getWebDriver().navigate().to(pageUrl);
    }
}
