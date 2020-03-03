package framework.page.objects;

import framework.tests.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {
    //Page Object
    @FindBy(css = "a[href$='FI-SW-01']")
    WebElement angelfishProductId;
    @FindBy(css = "#a[href$='FI-SW-02']")
    WebElement tigerSharkProductId;
    @FindBy(css = "a[href$='FI-FW-01']")
    WebElement koiProductId;
    @FindBy(css = "a[href$='FI-FW-02']")
    WebElement goldfishProductId;

    public FishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public void clickOnAngelFishProductId() {
        angelfishProductId.click();
    }

    public void clickOnTigerSharkProductId() {
        angelfishProductId.click();
    }

    public void clickOnKoiProductId() {
        angelfishProductId.click();
    }

    public void clickOnGoldFishProductId() {
        angelfishProductId.click();
    }


}
