import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithChrome {
    public static void main(String[] args){

        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        //driver.close();
        //WebElement search = driver.findElement(By.id("APjFqb"));
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.sendKeys("Test");
        search.sendKeys(Keys.ENTER);

    }
}
