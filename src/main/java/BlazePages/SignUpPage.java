package BlazePages;

import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    private WebDriver driver;

    public SignUpPage(WebDriver driver){
        this.driver=driver;
    }

    //Define methods to interact with sign-up page elements
    public WebElement signUpField(){
        return driver.findElement(By.id("signin2"));
    }

    public WebElement getUsernameField(){
        return driver.findElement(By.id("sign-username"));
    }
    public WebElement getPasswordField(){
        return driver.findElement(By.id("sign-password"));
    }
    public WebElement getSignUpBtn(){
        return driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
    }
//    private void handleModalDialog(){
//        By modalMessageLocator = By.xpath("//*[@onclick='logIn()']");
//        By okButtonLocator = (By.xpath("//button[@class='btn btn-secondary']"));
//
//        WebDriverWait wait =new WebDriverWait((driver, Duration.ofSeconds(10)));
//        wai
//    }
}
