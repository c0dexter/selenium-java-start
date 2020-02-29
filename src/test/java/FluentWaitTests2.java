import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class FluentWaitTests2 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_loading/2");
    }

    @Test
    public void fluentWaitWithExceptionTest(){
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, 5);
        fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        WebElement helloWorldMessage = driver.findElement(By.cssSelector("#finish h4"));
        assertTrue(helloWorldMessage.isDisplayed());
   }

    @AfterClass
    public void afterClass() {
        driver.close();
        driver.quit();
    }
}
