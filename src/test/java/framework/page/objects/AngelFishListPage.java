package framework.page.objects;

import framework.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishListPage {

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

    public void clickSmallAngelfishAddToCartButton() {
        smallAngelfishAddToCardButton.click();
    }
}
