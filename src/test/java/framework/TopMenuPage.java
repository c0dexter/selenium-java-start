package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopMenuPage {
    WebDriver driver;

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignOnLink(){
        WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signOnLink.click();
    }
}
