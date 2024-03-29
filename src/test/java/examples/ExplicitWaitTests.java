package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import static org.testng.Assert.*;

public class ExplicitWaitTests {

    private WebDriver driver;

//    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

//    @Test
    public void waitForDisappearingElement() {
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement removeButton = driver.findElement(By.cssSelector("button[id='btn']"));
        removeButton.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkbox));
        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");
    }

//    @Test
    public void waitForPresenceOfTheElement() {
        WebElement checkbox = driver.findElement(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());

        WebElement removeOrAddButton = driver.findElement(By.cssSelector("button[id='btn']"));
        removeOrAddButton.click();

        WaitUntil waitUntil = new WaitUntil(driver);
        waitUntil.waitUntilElementIsInvisible(checkbox);

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");

        removeOrAddButton.click();

        checkbox = waitUntil.waitUntilPresenceOfElementLocated(By.id("checkbox"));

        assertTrue(checkbox.isDisplayed());
        assertFalse(checkbox.isSelected());
    }


    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
