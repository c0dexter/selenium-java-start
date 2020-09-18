package framework.page.objects;

import framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

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

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignOnLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign on Link");
        return new LoginPage();
    }

    @Step("Click on Fish link")
    public FishListPage clickOnFish() {
        WaitForElement.waitUntilElementIsClickable(fishButton);
        fishButton.click();
        log().info("Clicked on TOP MENU Fish Button");
        return new FishListPage();
    }
}
