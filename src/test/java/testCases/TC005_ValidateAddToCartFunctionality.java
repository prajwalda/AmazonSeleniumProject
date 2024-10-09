package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.AddToCartPage;
import pageObject.HomePage;

public class TC005_ValidateAddToCartFunctionality extends BaseClass{
    @Test
    public void validateAddToCartFunctionality(){
        logger.info("***** Starting TC005_ValidateAddToCartFunctionality *****");

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

            hp.setTxtSearch("Apple iPhone 16 (128 GB) - Pink");

            hp.clickBtnSearch();

            AddToCartPage cartPage = new AddToCartPage(driver);
            int initialCartCount = cartPage.getCartCount();
            logger.info("Added item to the cart");
            cartPage.clickAddToCartBtn();
            Thread.sleep(5000);

            int updatedCartCount = cartPage.getCartCount();
            Assert.assertTrue(updatedCartCount > initialCartCount);
            driver.navigate().to("https://www.amazon.in/");
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();
        }
    }
}
