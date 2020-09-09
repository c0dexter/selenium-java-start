package framework.driver.manager;

import framework.driver.BrowserFactory;
import framework.driver.BrowserType;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserTypeToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (driver == null) {
            BrowserFactory browserFactory = new BrowserFactory(getBrowserTypeToRun(), getIsRemoteRun());
            driver = browserFactory.getBrowser();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();

        // Dla geckodriver wywołanie metody close(),
        // powoduje też zabicie instancji drivera (dodatkowo wywołuje metodę quit()),
        // gdy mamy tylko jedno okno przeglądarki). Dlatego ten przypadek należy obsłużyć aby pozbyć się błędu dla FF.
        if (!getBrowserTypeToRun().equals(BrowserType.FIREFOX)){
            driver.quit();
        }

        // Przypisane wartości null jest konieczne, ponieważ w pamięci Javy po wykonaniu metody quit(),
        // dalej znajduje się obiekt klasy WebDrivera, i musimy go po prostu z fizycznie usunąć.
        // Inaczej przy kolejnym wywołaniu metody getDriver(),
        // metoda nie zwróci nam nowego obiektu, lecz stary, który już wyłączył okno przeglądarki.
        driver = null;
    }
}
