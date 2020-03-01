package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SecondAutomatedTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void mySecondTest() {
        driver.navigate().to("http://www.seleniumhq.org/");

        String pageTitle = driver.getTitle();
        String title = "SeleniumHQ Browser Automation";

        assertEquals(pageTitle, title);

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
