package framework.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    WebDriver driver;

    @FindBy(css = "a[href$='newOrderForm=']")
    WebElement proceedToCheckoutButton;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckoutButton(){
        proceedToCheckoutButton.click();
    }
}
