package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page Object of first page
public class LandingPage {
    WebDriver driver;

    LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnEnterStoreLink(){
        WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();
    }
}
