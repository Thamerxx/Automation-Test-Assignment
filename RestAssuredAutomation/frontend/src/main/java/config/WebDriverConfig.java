package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverConfig {
    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        return new ChromeDriver();
    }
}
