package configuration;

import framework.driver.BrowserType;

public class TestRunProperties {
    public static BrowserType getBrowserTypeToRun(){
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

    public static boolean getIsRemoteRun(){
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }

    public static String getGridUrl() {
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }
}
