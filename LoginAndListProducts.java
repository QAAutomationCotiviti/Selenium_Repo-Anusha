import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginAndListProducts {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //Define valid test data
        String username = "standard_user";
        String password = "secret_sauce";

        //Open the login page
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        //Locate elements
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"))) {
            List<WebElement> productElements = driver.findElements(By.className("inventory_item"));

            if (!productElements.isEmpty()) {
                System.out.println("Product Names: ");
                for (WebElement productElement : productElements) {
                    WebElement productNameElement = productElement.findElement(By.className("inventory_item_name"));
                    String productName = productNameElement.getText();
                    System.out.println(productName);
                }
            } else {
                System.out.println("No product found on this page");
            }

            WebElement hamburgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
            hamburgerMenu.click();

//            WebElement logoutOption = driver.findElement(By.id("logout_sidebar_link"));
//            logoutOption.click();


        } else {
            System.out.println("Login failed");
        }
        selectsort(driver, "Price (low to high)");
        selectsort(driver, "Price (high to low)");
        selectsort(driver, "Name (A to Z)");
        selectsort(driver, "Name (Z to A)");
//        driver.quit();
    }
    public  static void selectsort(WebDriver driver, String text) {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText(text);
    }
}

