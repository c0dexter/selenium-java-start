package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

    private WebDriver driver;

//    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://przyklady.javastart.pl/test/hover_mouse.html");
    }

//    @Test
    public void makeImagesBiggerByMovingScrollOnElement() {
        WebElement smileyIcon1 = driver.findElement(By.id("smiley"));
        WebElement smileyIcon2 = driver.findElement(By.id("smiley2"));

        Actions actions = new Actions(driver);

        // chain of actions by dots. "build()" is provided for building actions and "perform()" to executing them
        actions.moveToElement(smileyIcon1).moveToElement(smileyIcon2).build().perform();

    }

//    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
