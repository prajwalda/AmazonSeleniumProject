package testCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;

import java.util.List;

public class TC008_ValidateAutoCompleteInSearchField extends BaseClass{

    @Test(priority = 1)
    public void testAutoCompleteInSearchField() throws InterruptedException {
        HomePage hp = new HomePage(driver);

        hp.setTxtSearch("shirts");
        Thread.sleep(3000);

        List<WebElement> list = hp.getSearchAutoSuggestionList();

        Boolean found = true;
        for(WebElement it : list){
            found = it.getText().contains("shirts");
        }

        Assert.assertEquals(found,true);
        driver.navigate().to("https://www.amazon.in/");
    }
}
