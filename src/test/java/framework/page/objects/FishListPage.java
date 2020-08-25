package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    private Logger logger = LogManager.getRootLogger();

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

    public AngelFishListPage clickOnAngelFishProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        angelfishProductId.click();
        logger.info("Clicked on Small Angel Fish Product ID");
        return new AngelFishListPage();
    }

    public void clickOnTigerSharkProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        tigerSharkProductId.click();
        logger.info("Clicked on Tiger Shark Product ID");
    }

    public void clickOnKoiProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        koiProductId.click();
        logger.info("Clicked on Koi Product ID");
    }

    public void clickOnGoldFishProductId() {
        WaitForElement.waitUntilElementIsClickable(angelfishProductId);
        goldfishProductId.click();
        logger.info("Clicked on Goldfish Product ID");
    }
}
