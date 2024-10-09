package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage{

    WebDriverWait wait;
    public AccountRegistrationPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='ap_email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement btn_continue;

    @FindBy(xpath = "//h4[normalize-space()='There was a problem']")
    WebElement err_message_email;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    WebElement btn_submit;

    @FindBy(xpath = "//input[@id='ap_password']")
    WebElement txtPassword;

    @FindBy(xpath = "//h4[normalize-space()='There was a problem']")
    WebElement err_message_password;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement txtVerifyName;

    @FindBy(xpath = "//div[contains(text(),'Enter your email or mobile phone number')]")
    WebElement errorMsgForEmptyField;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement elementToHover;

    @FindBy(xpath = "//span[normalize-space()='Sign Out']")
    WebElement signOut;

    public void setTxtEmail(String email){
        wait.until(ExpectedConditions.visibilityOf(txtEmail));
        txtEmail.sendKeys(email);
    }

    public boolean checkEmailPresent(){
        return txtEmail.isDisplayed();
    }

    public void setBtn_continue(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_continue));
        btn_continue.click();
    }

    public String getErrMessage(){
        wait.until(ExpectedConditions.visibilityOf(err_message_email));
        return err_message_email.getText();
    }

    public void setTxtPassword(String pwd){
        wait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(pwd);
    }

    public void setBtn_submit(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_submit));
        btn_submit.click();
    }

    public String getErrMessagePasswordPage(){
        wait.until(ExpectedConditions.visibilityOf(err_message_password));
        return err_message_password.getText();
    }

    public String getTxtVerifyName(){
        wait.until(ExpectedConditions.visibilityOf(txtVerifyName));
        return txtVerifyName.getText();
    }

    public String getErrMsgForEmptyField(){
        return errorMsgForEmptyField.getText();
    }

    public void hoverElementOnProfile(){
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        signOut.click();
    }
}
