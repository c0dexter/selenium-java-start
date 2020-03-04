package framework.page.objects;

import framework.driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {

    // PageFactory
    @FindBy(css = "#MenuContent a[href*='signonForm']")
    WebElement signOnLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public void clickOnSignOnLink() {
        signOnLink.click();
    }
}
