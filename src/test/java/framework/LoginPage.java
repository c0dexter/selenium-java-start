package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeIntoUserNameField(String username) {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);
        // NotExistingLogin
    }

    public void typeIntoPasswordField(String password) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton() {
        WebElement signOnButton = driver.findElement(By.name("signon"));
        signOnButton.click();
    }

    public String getWarningMessage() {
        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));
        return messageLabel.getText();
    }

}
