package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;

import java.util.logging.Logger;

public class TC004_ValidateInvalidSearchText extends BaseClass{
    @Test
    public void validateInvalidSearchText(){
        logger.info("***** Starting TC004_ValidateInvalidSearchText *****");

        try {
            HomePage hp = new HomePage(driver);
            hp.setTxtSearch("asasasdasx");
            logger.info("Setting invalid search field...");
            hp.clickBtnSearch();
            logger.info("Clicked the search button");
            Assert.assertEquals(hp.getTxtNotFound(),"No results for");
            logger.info("Test Passed");
            driver.navigate().to("https://www.amazon.in/");
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();
        }
    }
}
