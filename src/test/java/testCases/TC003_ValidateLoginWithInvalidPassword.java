package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC003_ValidateLoginWithInvalidPassword extends BaseClass{

    @Test
    void verify_account_withInvalidPassword(){

        logger.info("***** Starting TC003_ValidateLoginWithInvalidPassword *****");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            logger.info("Providing Customer details");

            regPage.setTxtEmail("xvskhan@gmail.com");
            regPage.setBtn_continue();
            regPage.setTxtPassword("123456786");
            regPage.setBtn_submit();
            logger.info("Validating expected error message...");

            String url = driver.getCurrentUrl();
            assert url != null;
            Assert.assertTrue(url.contains("https://www.amazon.in/ap/cvf/"));
            System.out.println(url);
            logger.info("Test Passed");
            driver.navigate().to("https://www.amazon.in/");
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();        }

    }
}
