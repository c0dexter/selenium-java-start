package framework.page.objects;

import framework.generic.assertions.AssertWebElement;
import framework.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    
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

    @Step("Type into User Name Field {username}")
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        log().info("Typed into User Name Field {}", username);
        return this;
    }

    @Step("Type into Password Field: {password}")
    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field {}", password);
        return this;
    }

    @Step("Click on Login Button")
    public FooterPage clickOnLoginButton() {
        signOnButton.click();
        log().info("Clicked on Login Button");
        return new FooterPage();
    }

    @Step("Getting warning message from Login Page")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        AssertWebElement.assertThat(messageLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

    @Step("Click on the fish button")
    public FishListPage clickOnFish() {
        WaitForElement.waitUntilElementIsClickable(fishButton);
        fishButton.click();
        log().info("Clicked on Fish Button");
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
