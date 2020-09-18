package framework.page.objects;

import framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage {

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement banner;

    @Step("Getting is dog banner is displayed")
    public Boolean isBannerAfterLoginDisplayed() {
        WaitForElement.waitUntilElementIsVisible(banner);
        boolean isDisplayed = banner.isDisplayed();
        log().info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;
    }
}
