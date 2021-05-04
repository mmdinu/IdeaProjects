package tests;

import base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class RegisterTest extends BaseTest {


    @Test
    public void proba() {
        //inspiration: https://automationintesting.com/selenium/java/lessons/locators

        WebElement SkipSignInWeb = driver.findElement(By.id("enterimg"));
        SkipSignInWeb.click();

        WebElement FirstNameWeb=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String FirstNameValue="Ioan";
        FirstNameWeb.sendKeys(FirstNameValue);

        WebElement LastNameWeb=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String LastNameValue="Moldovan";
        LastNameWeb.sendKeys(LastNameValue);

        WebElement AddressWeb=driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String AddressValue="Str. Mircea Eliade,\nnr. 46A,\nPostal Code - 400353";
        AddressWeb.sendKeys(AddressValue);
        System.out.println(AddressValue);

        // ng - pe langa HTML si CSS pe acest site mai exista si AngularJS

        WebElement EmailAddressWeb=driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        String EmailAddressValue="ioan.moldovan@yahoo.com";
        EmailAddressWeb.sendKeys(EmailAddressValue);

        WebElement PhoneWeb=driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        String PhoneValue="0744380772";
        PhoneWeb.sendKeys(PhoneValue);

        WebElement GenderWeb=driver.findElement(By.xpath("//input[@value='Male']"));
        GenderWeb.click();


        List<WebElement> HobbiesWeb=driver.findElements(By.xpath("//input[@type='checkbox']"));
        //foreach  - e util cand nu conteaza pozitia elementului pe care vreau sa il bifez
        for (WebElement Hobby:HobbiesWeb) {

            if (Hobby.getAttribute("value").equals("Cricket")||Hobby.getAttribute("value").equals("Hockey")) {
                Hobby.click();
            }
        }

        WebElement LanguagesWeb=driver.findElement(By.id("msdd"));
        LanguagesWeb.click();

        List<WebElement>  LanguagesListWeb=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//a"));
        for (WebElement Language:LanguagesListWeb){
            if (Language.getText().equals("English") || (Language.getText().equals("German") || (Language.getText().equals("Hungarian")))){
                Language.click();
            }
        }
        FirstNameWeb.click();

        WebElement SkillsWeb=driver.findElement(By.id("Skills"));
        String SkillsValue="Microsoft Office";
        SkillsWeb.sendKeys(SkillsValue);
        FirstNameWeb.click();

        WebElement CountriesWeb=driver.findElement(By.id("countries"));
        String CountriesValue="Romania";
        CountriesWeb.sendKeys(CountriesValue);
        FirstNameWeb.click();

        WebElement YearWeb=driver.findElement(By.id("yearbox"));
        String YearValue="1964";
        YearWeb.sendKeys(YearValue);
        FirstNameWeb.click();

        WebElement MontWeb=driver.findElement(By.xpath("//*[@placeholder='Month']"));
        MontWeb.click();
        String MontValue="February";
        MontWeb.sendKeys(MontValue);
        FirstNameWeb.click();

        WebElement DayWeb=driver.findElement(By.id("daybox"));
        DayWeb.click();
        String DayValue="16";
        DayWeb.sendKeys(DayValue);
        FirstNameWeb.click();

        WebElement PasswordWeb=driver.findElement(By.id("firstpassword"));
        PasswordWeb.click();
        String PasswordValue="123abcABC";
        PasswordWeb.sendKeys(PasswordValue);
        FirstNameWeb.click();

        WebElement SecondPasswordWeb=driver.findElement(By.id("secondpassword"));
        SecondPasswordWeb.click();
        String SecondPasswordValue="123abcABC";
        SecondPasswordWeb.sendKeys(SecondPasswordValue);
        FirstNameWeb.click();

        WebElement AddImgWeb=driver.findElement(By.id("imagesrc"));
        AddImgWeb.sendKeys("C:\\Users\\mmdin\\OneDrive\\ALEX DORHA - AZIMUT VISION\\AutomationHomeWork\\Locators-in-Selenium.JPG");
        FirstNameWeb.click();

        WebElement SubmitWeb=driver.findElement(By.id("submitbtn"));
        SubmitWeb.click();

        System.out.println("\n Tests passed! \n No registration message appears,\n Nothing change when click on submit button");

        driver.close();
    }
}
