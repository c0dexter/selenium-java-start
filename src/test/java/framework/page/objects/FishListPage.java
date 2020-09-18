package framework.page.objects;

import framework.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FishListPage extends BasePage {

    //Page Object
    @FindBy(css = "a[href$='FI-SW-01']")
    WebElement angelfishProductId;
    @FindBy(css = "#a[href$='FI-SW-02']")
    WebElement tigerSharkProductId;
    @FindBy(css = "a[href$='FI-FW-01']")
    WebElement koiProductId;
    @FindBy(css = "a[href$='FI-FW-02']")
    WebElement goldfishProductId;

    public AngelFishListPage clickOnAngelFishProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        angelfishProductId.click();
        log().info("Clicked on Small Angel Fish Product ID");
        return new AngelFishListPage();
    }

    public void clickOnTigerSharkProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        tigerSharkProductId.click();
        log().info("Clicked on Tiger Shark Product ID");
    }

    public void clickOnKoiProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        koiProductId.click();
        log().info("Clicked on Koi Product ID");
    }

    public void clickOnGoldFishProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        goldfishProductId.click();
        log().info("Clicked on Goldfish Product ID");
    }
}
