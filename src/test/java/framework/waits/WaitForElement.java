package framework.waits;

import framework.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), 10);
    }

    public static void waitUntilElementIsVisible(WebElement webElement) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementIsClickable(WebElement webElement) {
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    // Dobrą praktyką jest wstawianie metod na czekanie w momencie przed wykonaniem jakiegoś przeładowania na stronie,
    // na przykład przed kliknięciem w link, którego naciśniecie spowoduje przejście do innej strony.
}
