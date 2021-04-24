
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public WebDriver driver;


@Test
public void TestAutomat() throws InterruptedException {
 System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
    driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();


    WebElement SignInWeb = driver.findElement(By.id("btn1"));
    SignInWeb.click();


    // Test 0 - fara Email si Password introduse
    WebElement EnterButtonWeb=driver.findElement(By.id("enterbtn"));
    EnterButtonWeb.click();

    // validare mesaj eroare lipsa email si password
    WebElement DisplayedMessageWeb = driver.findElement(By.id("errormsg"));
    String ExpectedMessage = "Invalid User Name or PassWord";
    Assert.assertEquals(ExpectedMessage, DisplayedMessageWeb.getText());
    System.out.println("Invalid User Name or PassWord");


    //Test 1 - fara Password introdusa

    WebElement EmailWeb=driver.findElement(By.xpath("//input[@placeholder='E mail']"));
    String EmailValue="ioan.moldovan@yahoo.com";
    EmailWeb.sendKeys(EmailValue);

    WebElement EnterButton1Web=driver.findElement(By.id("enterbtn"));
    EnterButton1Web.click();

    // validare mesaj eroare lipsa password
    WebElement DisplayedMessage1Web = driver.findElement(By.id("errormsg"));
    String ExpectedMessage1 = "Invalid User Name or PassWord";
    Assert.assertEquals(ExpectedMessage1, DisplayedMessage1Web.getText());
    System.out.println("Invalid User Name or PassWord");
    Thread.sleep(3000);

    //Test 2 - fara Email introdus

    EmailWeb.clear();
    WebElement PasswordWeb=driver.findElement(By.xpath("//input[@placeholder='Password']"));
    String PasswordValue="12345";
    PasswordWeb.sendKeys(PasswordValue);
    WebElement EnterButton2Web=driver.findElement(By.id("enterbtn"));
    EnterButton2Web.click();

    // validare mesaj eroare lipsa Email
    WebElement DisplayedMessage2Web = driver.findElement(By.id("errormsg"));
    String ExpectedMessage2 = "Invalid User Name or PassWord";
    Assert.assertEquals(ExpectedMessage2, DisplayedMessage2Web.getText());
    System.out.println("Invalid User Name or PassWord");
    Thread.sleep(3000);

    // Test 3 - cu Email si Password introduse

    PasswordWeb.clear();
    WebElement EmailWeb1=driver.findElement(By.xpath("//input[@placeholder='E mail']"));
    String EmailValue1="ioan.moldovan@yahoo.com";
    EmailWeb1.sendKeys(EmailValue1);
    WebElement PasswordWeb1=driver.findElement(By.xpath("//input[@placeholder='Password']"));
    String PasswordValue1="123abcABC";
    PasswordWeb1.sendKeys(PasswordValue1);
    WebElement EnterButton3Web=driver.findElement(By.id("enterbtn"));
    EnterButton3Web.click();

    // validare mesaj eroare cu Email si Pssword
    WebElement DisplayedMessage3Web = driver.findElement(By.id("errormsg"));
    String ExpectedMessage3 = "Invalid User Name or PassWord";
    Assert.assertEquals(ExpectedMessage3, DisplayedMessage3Web.getText());
    System.out.println("Invalid User Name or PassWord");
    Thread.sleep(3000);

    driver.close();
    }
}
