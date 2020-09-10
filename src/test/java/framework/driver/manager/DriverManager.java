package framework.driver.manager;

import framework.driver.BrowserFactory;
import framework.driver.BrowserType;
import org.openqa.selenium.WebDriver;

import static configuration.TestRunProperties.getBrowserTypeToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(new BrowserFactory(getBrowserTypeToRun(), getIsRemoteRun()).getBrowser());
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();

        // Dla geckodriver wywołanie metody close(),
        // powoduje też zabicie instancji drivera (dodatkowo wywołuje metodę quit()),
        // gdy mamy tylko jedno okno przeglądarki). Dlatego ten przypadek należy obsłużyć aby pozbyć się błędu dla FF.
        if (!getBrowserTypeToRun().equals(BrowserType.FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }

        // Wywołanie metody remove() z klasy ThreadLocal dla danego wątku w celu usunięcia WebDrivera dla aktualnego wątku
        webDriverThreadLocal.remove();
    }
}
