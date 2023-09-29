package function;

import BlazePages.SignUpPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpFunctions {
    private WebDriver driver;
    private SignUpPage signUpPage;

    public SignUpFunctions(WebDriver driver){
        this.driver=driver;
        signUpPage=new SignUpPage(driver);
    }

    //define methods for signup actions
    public void signUp(String username, String password){
        signUpPage.signUpField().click();
        signUpPage.getUsernameField().sendKeys(username);
        signUpPage.getPasswordField().sendKeys(password);

        WebElement getSignUpBtn= signUpPage.getSignUpBtn();
        JavascriptExecutor javaexe = (JavascriptExecutor)driver;
        javaexe.executeScript("arguments[0].click();",getSignUpBtn);

//        handleModalDialog();
    }
}
