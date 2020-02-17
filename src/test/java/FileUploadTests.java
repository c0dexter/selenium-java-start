import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest(){
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        WebElement submitButton = driver.findElement(By.id("file-submit"));

        chooseFileButton.sendKeys("/home/c0dexter/IdeaProjects/Selenium/FirstProject/test_files/some_text");
        submitButton.click();
        sleep();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-file"));
        assertEquals(uploadedFiles.getText(), "some_text");
    }

    private void sleep(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

}
