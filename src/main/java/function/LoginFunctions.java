package function;

import BlazePages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginFunctions {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginFunctions(WebDriver driver){
        this.driver=driver;
        loginPage=new LoginPage(driver);
    }

    //define methods for signup actions
    public void login(String username, String password){
        loginPage.loginField().click();
        loginPage.getUsernameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getLoginBtn().click();
    }
}
