package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import config.WebDriverConfig;
import Pages.HomePage;
import Pages.SubscriptionPage;

import java.util.List;

public class SubscriptionTest {
    WebDriver driver;
    HomePage homePage;
    SubscriptionPage subscriptionPage;

    @BeforeClass
    public void setUp() {
        driver = WebDriverConfig.getDriver();
        homePage = new HomePage(driver);
        subscriptionPage = new SubscriptionPage(driver);
    }

    @Test
    public void validateSubscriptionPackagesForSaudiArabia() {
        homePage.navigateToHomePage();
        homePage.selectCountry("Saudi Arabia");
        List<WebElement> packages = subscriptionPage.getSubscriptionPackages();
        for (WebElement packageElement : packages) {
            String type = subscriptionPage.getPackageType(packageElement);
            String price = subscriptionPage.getPackagePrice(packageElement);
            String currency = subscriptionPage.getPackageCurrency(packageElement);
            // Validate type, price, and currency
            Assert.assertNotNull(type);
            Assert.assertNotNull(price);
            Assert.assertEquals(currency, "SAR");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
