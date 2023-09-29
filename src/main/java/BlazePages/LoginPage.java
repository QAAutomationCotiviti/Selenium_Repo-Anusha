package BlazePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import browser.browserFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //Define methods to interact with sign-up page elements
    public WebElement loginField(){
        return driver.findElement(By.id("login2"));
    }

    public WebElement getUsernameField(){
        return driver.findElement(By.id("loginusername"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("loginpassword"));
    }
    public WebElement getLoginBtn(){
        return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
    }
}
