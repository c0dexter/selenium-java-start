package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object of first page
public class LandingPage {
    WebDriver driver;

    // PageFactory
    @FindBy(css = "#Content a")
    WebElement enterStoreLink;

    LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing elements in the constructor
    }

    public void clickOnEnterStoreLink() {
        enterStoreLink.click();
    }
}
