package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href$='newOrderForm=']")
    WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public void clickProceedToCheckoutButton() {    // TODO: tu będzie zwrócenie wartości CheckoutPage dla pozytywnego testu (nie ma dodanego takiego PageObject jeszcze)
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on the Proceed To Checkout Button");
    }
}
