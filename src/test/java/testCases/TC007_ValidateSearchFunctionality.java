package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;

public class TC007_ValidateSearchFunctionality extends BaseClass{

    @Test
    public void validateSearchFunctionality() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        hp.setTxtSearch("iphone");
        hp.clickBtnSearch();
        Thread.sleep(3000);

        int qty = Integer.parseInt(hp.getSearchResult().substring(8,11));
        Assert.assertTrue(qty >= 1);
        driver.navigate().to("https://www.amazon.in/");
    }
}
