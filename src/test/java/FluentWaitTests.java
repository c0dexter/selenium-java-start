import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class FluentWaitTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/1");
    }

    @Test
    public void fluentWaitTest() {
        WebElement text = driver.findElement(By.id("finish"));
        assertFalse(text.isDisplayed());

        WebElement startButton = driver.findElement(By.cssSelector("#start>button"));
        FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, 15);
        startButton.click();

        text = fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        // ExpectedCondition<WebElement> visibilityOfElementLocated(By locator)
        // An expectation for checking that an element is present on the DOM of a page and visible.
        // Visibility means that the element is not only displayed but also has a height and width that is greater than
        fluentWait
                .until((ExpectedConditions.visibilityOfElementLocated(By.id("finish"))));
        assertTrue(text.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
