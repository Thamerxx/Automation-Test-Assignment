package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class SubscriptionPage {
    WebDriver driver;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getSubscriptionPackages() {
        return driver.findElements(By.cssSelector(".subscription-package"));
    }

    public String getPackageType(WebElement packageElement) {
        return packageElement.findElement(By.cssSelector(".package-type")).getText();
    }

    public String getPackagePrice(WebElement packageElement) {
        return packageElement.findElement(By.cssSelector(".package-price")).getText();
    }

    public String getPackageCurrency(WebElement packageElement) {
        return packageElement.findElement(By.cssSelector(".package-currency")).getText();
    }
}
