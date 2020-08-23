package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Logowanie przebigu testu - inicjalizowanie loggera
    private Logger logger = LogManager.getRootLogger();

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
        logger.info("Typed into User Name Field {}", username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
    }

    public void clickOnLoginButton() {
        signOnButton.click();
        logger.info("Clicked on Login Button");
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        logger.info("Returned warning message was: {}", messageLabel);
        return messageLabel.getText();
    }

    public void clickOnFish() {
        fishButton.click();
        logger.info("Clicked on Fish Button");
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
