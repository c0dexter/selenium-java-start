package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {
    WebDriver driver;

    // PageFactory
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signOnLink;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing elements in the constructor
    }

    public void clickOnSignOnLink() {
        signOnLink.click();
    }
}
