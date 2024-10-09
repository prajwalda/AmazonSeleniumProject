package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage{
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement lnkMyaccount;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement txtSearch;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement btnSearch;

    @FindBy(xpath = "//span[normalize-space()='No results for']")
    WebElement txtNotFound;

    @FindBy(css = "div.a-section.a-spacing-small.a-spacing-top-small > span:nth-of-type(1)")
    WebElement searchResult;

    @FindBy(xpath = "//div[@id='nav-flyout-searchAjax']")
    List<WebElement> searchAutoSuggestionList;

    @FindBy(xpath = "//a[normalize-space()='Amazon Pay']")
    WebElement amazonPayBtn;

    public void clickMyAccount(){
        lnkMyaccount.click();
    }

    public void setTxtSearch(String txt){
        wait.until(ExpectedConditions.visibilityOf(txtSearch));
        txtSearch.sendKeys(txt);
    }

    public void clickBtnSearch(){
        wait.until(ExpectedConditions.visibilityOf(txtSearch));
        btnSearch.click();
    }

    public String getTxtNotFound(){
        wait.until(ExpectedConditions.visibilityOf(txtNotFound));
        return txtNotFound.getText();
    }

    public String getSearchResult(){
        return searchResult.getText();
    }

    public List<WebElement> getSearchAutoSuggestionList() {
        wait.until(ExpectedConditions.visibilityOf(txtSearch));
        wait.until(ExpectedConditions.visibilityOfAllElements(searchAutoSuggestionList)); // Ensure all suggestions are visible
        return searchAutoSuggestionList; // Return the list of suggestions
    }

    public void clickAmazonPayLink(){
        wait.until(ExpectedConditions.visibilityOf(amazonPayBtn));
        amazonPayBtn.click();
    }

}
