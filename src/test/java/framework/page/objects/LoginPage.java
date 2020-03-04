package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Page Factory
    @FindBy(name = "username")
    WebElement usernameField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(name = "signon")
    WebElement signOnButton;
    @FindBy(css = "#Content ul[class='messages'] li")
    WebElement messageLabel;
    @FindBy(css = "#SidebarContent a[href*='Id=FISH']")
    WebElement fishButton;
    @FindBy(css = "#SidebarContent a[href*='Id=DOGS']")
    WebElement dogsButton;
    @FindBy(css = "#SidebarContent a[href*='Id=CATS']]")
    WebElement catsButton;
    @FindBy(css = "#SidebarContent a[href*='Id=REPTILES']")
    WebElement reptilesButton;
    @FindBy(css = "#SidebarContent a[href*='Id=BIRDS']")
    WebElement birdsButton;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this); // Initializing elements in the constructor
    }

    public void typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        signOnButton.click();
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        return messageLabel.getText();
    }

    public void clickOnFish() {
        fishButton.click();
    }

    public void clickOnDogs() {
        dogsButton.click();
    }

    public void clickOnCats() {
        catsButton.click();
    }

    public void clickOnReptiles() {
        reptilesButton.click();
    }

    public void clickOnBirds() {
        birdsButton.click();
    }

}
