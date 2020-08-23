package framework.page.objects;

import framework.driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object of first page
public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    // PageFactory
    @FindBy(css = "#Content a")
    WebElement enterStoreLink;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public void clickOnEnterStoreLink() {
        enterStoreLink.click();
        logger.info("Clicked on Enter Store link");
    }
}
