package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoverTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {

        WebElement userOneAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        WebElement userTwoAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        WebElement userThreeAvatar = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));

        WebElement userOneCaption = driver.findElement(By.xpath("//*[@id='content']/div/div[1]//h5"));
        WebElement userTwoCaption = driver.findElement(By.xpath("//*[@id='content']/div/div[2]//h5"));
        WebElement userThreeCaption = driver.findElement(By.xpath("//*[@id='content']/div/div[3]//h5"));

        Actions actions = new Actions(driver);

        actions.moveToElement(userOneAvatar).perform();
        assertEquals(userOneCaption.getText(), "name: user1");
        assertEquals(userTwoCaption.getText(), "");
        assertEquals(userThreeCaption.getText(), "");
        sleep();

        actions.moveToElement(userTwoAvatar).perform();
        assertEquals(userOneCaption.getText(), "");
        assertEquals(userTwoCaption.getText(), "name: user2");
        assertEquals(userThreeCaption.getText(), "");
        sleep();

        actions.moveToElement(userThreeAvatar).perform();
        assertEquals(userOneCaption.getText(), "");
        assertEquals(userTwoCaption.getText(), "");
        assertEquals(userThreeCaption.getText(), "name: user3");
        sleep();

    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
