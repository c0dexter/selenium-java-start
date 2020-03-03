package framework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishListPage {
    WebDriver driver;

    //Page Object
    @FindBy(css = "a.Button[href$='EST-1']")
    WebElement largeAngelfishAddToCardButton;
    @FindBy(css = "a.Button[href$='EST-2']")
    WebElement smallAngelfishAddToCardButton;

    public AngelFishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLargeAngelfishAddToCartButton() {
        largeAngelfishAddToCardButton.click();
    }

    public void clickSmallAngelfishAddToCartButton() {
        smallAngelfishAddToCardButton.click();
    }
}
