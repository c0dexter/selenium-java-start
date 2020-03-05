package framework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static WebDriver driver;

    public DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "drivers/repository/chrome_v80/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        driver.quit();
        driver = null;
        //Przypisane wartości null jest konieczne, ponieważ w pamięci Javy po wykonaniu metody quit(),
        // dalej znajduje się obiekt klasy WebDrivera, i musimy go po prostu z fizycznie usunąć.
        // Inaczej przy kolejnym wywołaniu metody getDriver(),
        // metoda nie zwróci nam nowego obiektu, lecz stary, który już wyłączył okno przeglądarki.
    }
}
