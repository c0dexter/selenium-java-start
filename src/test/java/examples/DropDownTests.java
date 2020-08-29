package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class DropDownTests {

    private WebDriver driver;

//    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");
    }

//    @Test
    public void checkboxesTest() {
        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select options = new Select(dropdownList);

        assertEquals(options.getFirstSelectedOption().getText(), "Please select an option");
        sleep();

        options.selectByValue("1");
        assertEquals(options.getFirstSelectedOption().getText(), "Option 1");
        sleep();

        options.selectByValue("2");
        assertEquals(options.getFirstSelectedOption().getText(), "Option 2");
        sleep();
    }

    // Only for learning, this practice should be avoided
    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
