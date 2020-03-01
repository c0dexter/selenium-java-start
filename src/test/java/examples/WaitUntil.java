package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {
    private WebDriverWait webDriverWait;

    // Constructor with one parameter 'driver' for initialize WebDriverWait
    public WaitUntil(WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 15);
    }

    // Method for waiting and returning WebElement after reloading page to avoid the StaleElementReferenceException error
    public WebElement waitUntilPresenceOfElementLocated(By by) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    // Method for waiting during a some WebElement is visible
    public void waitUntilElementIsInvisible(WebElement checkboxBeforeClick) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(checkboxBeforeClick));
    }
}
