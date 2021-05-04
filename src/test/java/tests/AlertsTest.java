package tests;

import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsTest extends BaseTest {


    @Test
    public void TestAutomat() {

        //Skip Sign In Button
        WebElement SkipSignInWeb = driver.findElement(By.id("btn2"));
        SkipSignInWeb.click();

        WebElement SwitchToWeb = driver.findElement(By.xpath("//a[contains(text(),'Swi')]"));
        Actions Action = new Actions(driver);
        Action.moveToElement(SwitchToWeb).perform();
        // perform() vs build().perform() - metoda perform face implicit si build

        WebElement SwitchToAlertsWeb = driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        SwitchToAlertsWeb.click();
        //driver.get("http://demo.automationtesting.in/Alerts.html"); // pt a scapa de reclame
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html"); // pt a scapa de reclame
        //dif.get() vs navigate().to() - driver.get() e de preferat sa se puna la inceput a.i. el se asigura
        // ca acceseaza URL+asteapta sa se incarce pagina , pe cand driver.navigate().to() face strict navigarea la URL
        new WebDriverWait(driver, 15).until(ExpectedConditions.titleIs("Alerts"));

        WebElement Alerta1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        Alerta1.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement ButonAlerta2 = driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        ButonAlerta2.click();

        WebElement Alerta2 = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        Alerta2.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement ButonAlerta3 = driver.findElement(By.xpath("//a[@href='#Textbox']"));
        ButonAlerta3.click();

        WebElement Alerta3 = driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        Alerta3.click();
        new WebDriverWait(driver, 15).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("Pot sa scriu orice");
        driver.switchTo().alert().accept();

        driver.close();
    }
}
