package framework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
    WebDriver driver;

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement banner;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean isBannerAfterLoginDisplayed() {
        return banner.isDisplayed();
    }
}
