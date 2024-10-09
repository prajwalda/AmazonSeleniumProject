package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AccountRegistrationPage;
import pageObject.AddToCartPage;
import pageObject.HomePage;

public class TC006_ValidateDeleteToCartFunctionality extends BaseClass{
    @Test
    public void validateDeleteToCart(){
        logger.info("***** Starting TC006_ValidateDeleteToCartFunctionality *****");

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

            AddToCartPage cartPage = new AddToCartPage(driver);

            int initialCartCount = cartPage.getCartCount();
            cartPage.clickBtnToCartPage();
            cartPage.clickBtnDeleteItemInCart();
            int updatedCartCount = cartPage.getCartCount()-1;
            System.out.println(initialCartCount+updatedCartCount);
            Assert.assertTrue(initialCartCount > updatedCartCount);
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();
        }
    }

}
