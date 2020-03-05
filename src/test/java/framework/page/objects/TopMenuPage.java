package framework.page.objects;

import framework.driver.DriverManager;
import framework.waits.WaitForElement;
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
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
    }
}
