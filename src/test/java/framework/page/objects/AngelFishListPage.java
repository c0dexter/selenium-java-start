package framework.page.objects;

import framework.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AngelFishListPage extends BasePage {

    //Page Object
    @FindBy(css = "a.Button[href$='EST-1']")
    WebElement largeAngelfishAddToCardButton;
    @FindBy(css = "a.Button[href$='EST-2']")
    WebElement smallAngelfishAddToCardButton;

    public ShoppingCartPage clickLargeAngelfishAddToCartButton() {
        WaitForElement.waitUntilElementIsClickable(largeAngelfishAddToCardButton);
        largeAngelfishAddToCardButton.click();
        log().info("Clicked on Large Angel Fish 'Add to card' button");
        return new ShoppingCartPage();
    }

    public ShoppingCartPage clickSmallAngelfishAddToCartButton() {
        WaitForElement.waitUntilElementIsClickable(smallAngelfishAddToCardButton);
        smallAngelfishAddToCardButton.click();
        log().info("Clicked on Small Angel Fish 'Add to card' button");
        return new ShoppingCartPage();
    }
}
