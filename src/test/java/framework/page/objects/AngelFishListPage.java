package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishListPage {

    private Logger logger = LogManager.getRootLogger();

    //Page Object
    @FindBy(css = "a.Button[href$='EST-1']")
    WebElement largeAngelfishAddToCardButton;
    @FindBy(css = "a.Button[href$='EST-2']")
    WebElement smallAngelfishAddToCardButton;

    public AngelFishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public void clickLargeAngelfishAddToCartButton() {
        largeAngelfishAddToCardButton.click();
    }

    public ShoppingCartPage clickSmallAngelfishAddToCartButton() {
        WaitForElement.waitUntilElementIsClickable(smallAngelfishAddToCardButton);
        smallAngelfishAddToCardButton.click();
        logger.info("Clicked on Small Angel Fish 'Add to card' button");
        return new ShoppingCartPage();
    }
}
