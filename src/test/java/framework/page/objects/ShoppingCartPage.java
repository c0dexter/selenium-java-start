package framework.page.objects;

import framework.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = "a[href$='newOrderForm=']")
    WebElement proceedToCheckoutButton;

    public void clickProceedToCheckoutButton() {    // TODO: tu będzie zwrócenie wartości CheckoutPage dla pozytywnego testu (nie ma dodanego takiego PageObject jeszcze)
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Clicked on the Proceed To Checkout Button");
    }
}
