import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginWithMultipleDataTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        String[][] testData={
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"},
                {"performance_glitch_user","secret_sauce"},
        };
        List<String> results=new ArrayList<>();

        for(String[] data: testData) {
            String username = data[0];
            String password = data[1];


            //locate the username and password
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));

            usernameField.sendKeys(username);
            passwordField.sendKeys(password);

            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                results.add("Login successful for user: " + username);

                try{
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                WebElement hamburgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
                hamburgerMenu.click();

                WebElement logoutOption = driver.findElement(By.id("logout_sidebar_link"));
                logoutOption.click();


            } else {
                results.add("Login failed for user: " + username);
            }
        }

        //close the browser
        driver.quit();

        for (String result : results){
            System.out.println(result);
        }


    }
}
