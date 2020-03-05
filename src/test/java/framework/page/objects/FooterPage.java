package framework.page.objects;

import framework.driver.DriverManager;
import framework.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement banner;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public Boolean isBannerAfterLoginDisplayed() {
        WaitForElement.waitUntilElementIsVisible(banner);
        return banner.isDisplayed();
    }
}
