package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPayment extends BasePage{

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPayment(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//img[@alt='Apple iPhone 15 Plus (128 GB) - Blue']")
    WebElement detailsPage;

    @FindBy(xpath = "//input[@id='buy-now-button']")
    WebElement buyNowBtn;

    @FindBy(xpath = "//span[normalize-space()='Other UPI Apps']")
    WebElement upiBtn;

    @FindBy(css = "input.a-input-text.a-form-normal.no-prefetch-on-change")
    WebElement txtUpiId;

    @FindBy(xpath = "//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']")
    WebElement btnVerify;

    @FindBy(xpath = "//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
    WebElement btnSubmit;

    public void clickDetailsPage(){
        wait.until(ExpectedConditions.visibilityOf(detailsPage));
        detailsPage.click();
    }

    public void clickBuyNowBtn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(buyNowBtn));
        buyNowBtn.click();
    }

    public void clickUpiBtn(){
        wait.until(ExpectedConditions.visibilityOf(upiBtn));
        upiBtn.click();
    }

    public void setTxtUpiId(String upiID){
        txtUpiId.sendKeys(upiID);
    }

    public void clickVerifyBtn(){
        wait.until(ExpectedConditions.visibilityOf(btnVerify));
        btnVerify.click();
    }

    public void clickSubmitBtn(){
        wait.until(ExpectedConditions.visibilityOf(btnSubmit));
        btnSubmit.click();
    }
}
