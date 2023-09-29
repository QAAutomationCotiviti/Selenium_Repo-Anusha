import browser.browserFactory;
import function.LoginFunctions;
import function.SignUpFunctions;
import org.openqa.selenium.WebDriver;

public class SignUpAndLoginAutomation {
    public static void main(String[] args) {

        //choose the browser here
        String browserName="chrome";

        //Create the webdriver instance using browserfactory
        WebDriver driver= browserFactory.WebDriver(browserName);

        //open your website
        driver.get("https://www.demoblaze.com/");

        //create instance of functions classes
        SignUpFunctions signUpFunctions=new SignUpFunctions(driver);
        LoginFunctions loginFunctions=new LoginFunctions(driver);

        //perform signup
        signUpFunctions.signUp("adminone","adminone");

        //perform login
        loginFunctions.login("adminone","adminone");

        //close browser
        driver.quit();

    }
}
