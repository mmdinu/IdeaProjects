package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver){
        this.driver=driver;
    }

    public void ClickElement(WebElement element){
        element.click();
    }

    public void ValidateErrorMessage(WebElement element, String value){
        Assert.assertEquals(value, element.getText());
    }

    public void FillElement(WebElement element, String value){
        element.sendKeys(value);
    }

    public void HoverElement(WebElement element){
        Actions Action=new Actions(driver);
        Action.moveToElement(element).perform();
    }

    public void DropDownSelectByText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void DropDownSelectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }



}
