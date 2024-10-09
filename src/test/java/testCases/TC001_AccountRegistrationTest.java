package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass{

    @Test
    void verify_account_registration(){

        logger.info("***** Starting TC001_AccountRegistrationTest *****");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            logger.info("Providing Customer details");

            regPage.setTxtEmail("xvskhan@gmail.com");
            regPage.setBtn_continue();
            regPage.setTxtPassword("123456789");
            regPage.setBtn_submit();

            logger.info("Validating expected message...");
            Assert.assertEquals(regPage.getTxtVerifyName(),"Hello, prajwal");


        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();
        }
    }
}
