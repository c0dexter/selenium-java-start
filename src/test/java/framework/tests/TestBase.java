package framework.tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import framework.driver.BrowserType;
import framework.driver.manager.DriverManager;
import framework.driver.manager.DriverUtils;
import org.testng.annotations.*;

import java.util.Properties;

import static framework.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Parameters("browser") // Zaciągane z all_test_suite.xml
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) { // Optional, bo test może NIE być odpalony z XMLa)
        DriverManager.setWebDriver(browserType); // Jeśli nie jest odpalony z XMLa, wtedy parametr jest nullem -> obsługa w DriverManager
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
