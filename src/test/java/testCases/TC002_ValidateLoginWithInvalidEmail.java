package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.HomePage;

public class TC002_ValidateLoginWithInvalidEmail extends BaseClass{


    @Test
    void verify_account_withInvalidEmail(){

        logger.info("***** Starting TC002_ValidateLoginWithInvalidEmail *****");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            logger.info("Providing Customer details");

            String emailId = "prajwasdaeqwdl@gmail.com";
//            String emailId = "";
            regPage.setTxtEmail(emailId);


            regPage.setBtn_continue();
            Thread.sleep(1000);
            logger.info("Validating expected error message...");
            if(emailId.isEmpty()){
                Assert.assertEquals(regPage.getErrMsgForEmptyField(),"Enter your email or mobile phone number");
            }
            else{
                Assert.assertEquals(regPage.getErrMessage(),"There was a problem");
            }
            Thread.sleep(1000);
            logger.info("Test Passed");
            driver.navigate().to("https://www.amazon.in/");
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();        }

    }
}
