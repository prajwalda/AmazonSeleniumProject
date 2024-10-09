package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.CheckoutPayment;
import pageObject.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TC009_ValidatePaymentCheckout extends BaseClass {

    @Test
    public void validatePayment() throws InterruptedException {

        logger.info("***** Starting TC009_ValidatePaymentCheckout *****");

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicked on MyAccount link");

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        logger.info("Providing Customer details");

        regPage.setTxtEmail("xvskhan@gmail.com");
        logger.info("Entered email");
        regPage.setBtn_continue();
        logger.info("Clicked on Continue button");

        regPage.setTxtPassword("123456789");
        logger.info("Entered password");
        regPage.setBtn_submit();
        logger.info("Clicked on Submit button");

        hp.setTxtSearch("iphone 15 plus");
        logger.info("Entered search text: 'iphone 15 plus'");
        hp.clickBtnSearch();
        logger.info("Clicked on Search button");

        CheckoutPayment payment = new CheckoutPayment(driver);

        payment.clickDetailsPage();
        logger.info("Clicked on product details page link");

        Set<String> windowHandle = driver.getWindowHandles();
        List<String> page = new ArrayList<>(windowHandle);
        if (page.size() == 2) {
            driver.switchTo().window(page.get(1));
            logger.info("Switched to product details window");
        }

        payment.clickBuyNowBtn();
        logger.info("Clicked on Buy Now button");

        payment.clickUpiBtn();
        logger.info("Clicked on UPI option");

        Thread.sleep(3000);  // For demonstration only; prefer WebDriverWait for real scenarios
        payment.setTxtUpiId("9172799805@apl");
        logger.info("Entered UPI ID");

        payment.clickVerifyBtn();
        logger.info("Clicked on Verify button");

        payment.clickSubmitBtn();
        logger.info("Clicked on Submit button");

        // Explicit wait for URL navigation to the expected checkout URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isUrlCorrect = wait.until(ExpectedConditions.urlContains("/gp/buy/spc/handlers"));
        logger.info("Checking if the current URL contains '/gp/buy/spc/handlers'");

        Assert.assertTrue(isUrlCorrect, "URL did not contain the expected substring '/gp/buy/spc/handlers'");
        logger.info("***** TC009_ValidatePaymentCheckout completed successfully *****");
    }
}
