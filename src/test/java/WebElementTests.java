import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WebElementTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void typingIntoWebElementTest() {
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("Selenium Start");

        String typeUserNameValue = userNameField.getAttribute("value");
        assertEquals(typeUserNameValue, "Selenium Start");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
