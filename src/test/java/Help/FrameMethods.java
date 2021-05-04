package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver){
        this.driver=driver;
    }

    public void SwitchById(String id){
        driver.switchTo().frame(id);
    }

    public void SwitchDefault(){
        driver.switchTo().defaultContent();
    }

    public void SwitchByElement(By identificator){
        driver.switchTo().frame(driver.findElement(identificator));

    }

}
