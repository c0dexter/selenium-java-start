package framework.page.objects;

import framework.tests.DriverManager;
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
        return banner.isDisplayed();
    }
}
