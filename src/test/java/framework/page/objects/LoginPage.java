package framework.page.objects;

import framework.driver.manager.DriverManager;
import framework.generic.assertions.AssertWebElement;
import framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // Logowanie przebigu testu - inicjalizowanie loggera
    private Logger logger = LogManager.getLogger(LoginPage.class);

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

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
        return this;
    }

    @Step("Type into Password Field: {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public FooterPage clickOnLoginButton() {
        signOnButton.click();
        logger.info("Clicked on Login Button");
        return new FooterPage();
    }

    @Step("Getting warning message from Login Page")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        logger.info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

    @Step("Click on the fish button")
    public FishListPage clickOnFish() {
        WaitForElement.waitUntilElementIsClickable(fishButton);
        fishButton.click();
        logger.info("Clicked on Fish Button");
        return new FishListPage();
    }

    @Step("Click on the dog button")
    public void clickOnDogs() {
        dogsButton.click();
    }

    @Step("Click on the cats button")
    public void clickOnCats() {
        catsButton.click();
    }

    @Step("Click on the reptiles button")
    public void clickOnReptiles() {
        reptilesButton.click();
    }

    @Step("Click on the birds button")
    public void clickOnBirds() {
        birdsButton.click();
    }

}
