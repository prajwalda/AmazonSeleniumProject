package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCases.BaseClass;

import java.time.Duration;

public class AddToCartPage extends BasePage {
    WebDriverWait wait;

    public AddToCartPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @FindBy(id = "a-autoid-3-announce")
    WebElement btnAddToCart;

    @FindBy(id = "nav-cart-count")
    WebElement cartCount;

    @FindBy(xpath = "(//input[contains(@name, 'submit.delete')])[1]")
    WebElement btnDeleteFirstItemInCart;



    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement btnClickToCart;

    public void clickAddToCartBtn(){
        wait.until(ExpectedConditions.visibilityOf(cartCount));
        btnAddToCart.click();
    }

    public int getCartCount(){
        wait.until(ExpectedConditions.visibilityOf(cartCount));
        return Integer.parseInt(cartCount.getText());
    }

    public void clickBtnDeleteItemInCart(){
        wait.until(ExpectedConditions.visibilityOf(btnAddToCart));
        btnDeleteFirstItemInCart.click();
    }

    public void clickBtnToCartPage(){
        wait.until(ExpectedConditions.visibilityOf(btnClickToCart));
        btnClickToCart.click();
    }
}
