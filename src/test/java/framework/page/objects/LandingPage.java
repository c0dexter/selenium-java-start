package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object of first page
public class LandingPage {

    private Logger logger = LogManager.getLogger(LandingPage.class);

    // PageFactory
    @FindBy(css = "#Content a")
    WebElement enterStoreLink;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    @Step("Click on Enter Store link")
    public TopMenuPage clickOnEnterStoreLink() {
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        logger.info("Clicked on Enter Store link");
        return new TopMenuPage();
    }
}
