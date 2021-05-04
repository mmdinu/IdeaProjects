package tests;

import Help.ElementMethods;
import Help.FrameMethods;
import Help.PageMethods;
import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Frames extends BaseTest {
    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public FrameMethods frameMethods;

    @Test
    public void TestAutomat() {
        elementMethods=new ElementMethods(driver);
        pageMethods=new PageMethods(driver);
        frameMethods=new FrameMethods(driver);


        //Skip Sign In Button
        WebElement SkipSignInWeb = driver.findElement(By.id("btn2"));
        //SkipSignInWeb.click();
        elementMethods.ClickElement(SkipSignInWeb);

        WebElement SwitchToWeb = driver.findElement(By.xpath("//a[contains(text(),'Swi')]"));
        //Actions Action=new Actions(driver);
        //Action.moveToElement(SwitchToWeb).perform();
        elementMethods.HoverElement(SwitchToWeb);

        WebElement SwitchToFramesWeb = driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
        SwitchToFramesWeb.click();
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //new WebDriverWait(driver,15).until(ExpectedConditions.titleIs("Frames"));
        pageMethods.WaitTitlePage("Frames");

        WebElement SingleIFrame=driver.findElement(By.xpath("//a[@href='#Single']"));
        SingleIFrame.click();

        //driver.switchTo().frame("singleframe");
        frameMethods.SwitchById("singleframe");

        WebElement InputSingleFrame=driver.findElement(By.xpath("//input[@type='text']"));
        InputSingleFrame.sendKeys("EnyTextHere");

        //driver.switchTo().defaultContent();
        frameMethods.SwitchDefault();

        WebElement MultipleFrame=driver.findElement(By.xpath("//a[@href='#Multiple']"));
        MultipleFrame.click();

        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        frameMethods.SwitchByElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        frameMethods.SwitchByElement(By.xpath("//iframe[@src='SingleFrame.html']"));

        WebElement InputMultipleFrames=driver.findElement(By.xpath("//input[@type='text']"));
        InputMultipleFrames.sendKeys("EnyTextHere");

        driver.close();


    }




}
