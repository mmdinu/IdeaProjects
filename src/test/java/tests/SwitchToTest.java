package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToTest {
    public WebDriver driver;

// sau facut modificari cu parintele BaseTest

    @Test
    public void TestAutomat() {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();


        WebElement SwitchToWeb = driver.findElement(By.xpath("//a[contains(text(),'Swi')]"));
        Actions Action=new Actions(driver);
        Action.moveToElement(SwitchToWeb).perform();
//        perform() vs build() - perform() este metoda care face implicit si build!

        WebElement SwitchToAlertWeb=driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        SwitchToAlertWeb.click();
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        new WebDriverWait(driver,15).until(ExpectedConditions.titleIs("Alerts"));

        WebElement AlertOne=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        AlertOne.click();
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement ButonAlertaTwo=driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        ButonAlertaTwo.click();

        WebElement AlertTwo=driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        AlertTwo.click();
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement ButonAlertaThree=driver.findElement(By.xpath("//a[@href='#Textbox']"));
        ButonAlertaThree.click();

        WebElement AlertaThree=driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        AlertaThree.click();
        new WebDriverWait(driver,15).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("You can write anything!");
        driver.switchTo().alert().accept();

        driver.close();



    }

}
