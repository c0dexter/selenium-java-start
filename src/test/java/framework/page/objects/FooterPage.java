package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Banner img[src*='dog']")
    WebElement banner;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public Boolean isBannerAfterLoginDisplayed() {
        WaitForElement.waitUntilElementIsVisible(banner);
        boolean isDisplayed = banner.isDisplayed();
        logger.info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;
    }
}
