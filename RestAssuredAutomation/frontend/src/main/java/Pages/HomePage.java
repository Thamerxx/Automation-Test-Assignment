package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://subscribe.stctv.com/sa-en");
    }

    public void selectCountry(String country) {
        WebElement countryElement = driver.findElement(By.xpath("//a[contains(text(), '" + country + "')]"));
        countryElement.click();
    }
}
