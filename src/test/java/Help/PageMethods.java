package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMethods {
    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver=driver;
    }

    public void WaitTitlePage(String title){
        new WebDriverWait(driver,15).until(ExpectedConditions.titleIs(title));

    }

    public void ValidatePageTitle(String pagetitle){
        WaitTitlePage(pagetitle);
        String Actual=driver.getTitle();
        Assert.assertEquals(pagetitle,Actual);
    }

}
