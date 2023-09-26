import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddRemoveCart {
    public void validlogin(WebDriver driver) {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement pswd = driver.findElement(By.id("password"));
        pswd.sendKeys("secret_sauce");
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
    }

    public  static void selectsort(WebDriver driver, String text) {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText(text);
    }

    public static void detailsOfProduct(WebDriver driver) {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item"));
        System.out.println("List of all Products:");

        for (WebElement productElement : productElements) {
            WebElement productNameElement = productElement.findElement(By.className("inventory_item_name"));
            String productName = productNameElement.getText();

            WebElement prodDescription = productElement.findElement(By.className("inventory_item_desc"));
            String description = prodDescription.getText();

            WebElement productPrice = productElement.findElement(By.className("inventory_item_price"));
            String price = productPrice.getText();

            System.out.println(productName);
            System.out.println(description);
            System.out.println(price);
        }

    }

    public static void addtocart(WebDriver driver) {
        WebElement cartbtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        cartbtn.click();

        WebElement removebtn = driver.findElement(By.id("remove-sauce-labs-backpack"));
        String remove= removebtn.getText();

        if (remove.contains("Remove")) {
            System.out.println("item added to cart");
        }
        else {
            System.out.println("item not added to cart");
        }
    }
    public static void removecart(WebDriver driver){
        WebElement carticon = driver.findElement(By.id("shopping_cart_container"));
        carticon.click();

        WebElement removebtn = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removebtn.click();
        List<WebElement> cartList = driver.findElements(By.className("cart-item"));

        if(cartList.isEmpty()) {
            System.out.println("item removed from cart");
        }
        else {
            System.out.println("item still in cart");
        }
    }
    public static void checkoutbtn(WebDriver driver){
        WebElement checkoutbtn=driver.findElement(By.id("checkout"));
        checkoutbtn.click();
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        AddRemoveCart obj = new AddRemoveCart();
        obj.validlogin(driver);

        selectsort(driver, "Price (low to high)");
        selectsort(driver, "Price (high to low)");
        selectsort(driver, "Name (A to Z)");
        selectsort(driver, "Name (Z to A)");

        detailsOfProduct(driver);

        addtocart(driver);
        removecart(driver);
        checkoutbtn(driver);

    }
}
