package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    // PageFactory
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signOnLink;
    @FindBy(css = "#QuickLinks a[href*='Id=FISH']")
    WebElement fishButton;
    @FindBy(css = "#QuickLinks a[href*='Id=FISH']")
    WebElement dogsButton;
    @FindBy(css = "#QuickLinks a[href*='Id=FISH']")
    WebElement reptilesButton;
    @FindBy(css = "#QuickLinks a[href*='Id=FISH']")
    WebElement catsButton;
    @FindBy(css = "#QuickLinks a[href*='Id=FISH']")
    WebElement birdsButton;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignOnLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        logger.info("Clicked on Sign on Link");
        return new LoginPage();
    }
    @Step("Click on Fish link")
    public FishListPage clickOnFish() {
        WaitForElement.waitUntilElementIsClickable(fishButton);
        fishButton.click();
        logger.info("Clicked on TOP MENU Fish Button");
        return new FishListPage();
    }
}
