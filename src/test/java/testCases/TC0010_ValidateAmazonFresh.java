package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;

public class TC0010_ValidateAmazonFresh extends BaseClass{

    @Test(priority = 1)
    public void validateAmazonFresh() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.clickAmazonPayLink();

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.in/amazonpay/home?ref_=nav_cs_apay"));
        driver.navigate().to("https://www.amazon.in/");
    }
}
