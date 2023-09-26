import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class weatherForescasting {
    weatherForescasting(WebDriver d, String s){
        WebDriver driver=d;
        String searching=s;
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.sendKeys(searching);
        search.sendKeys(Keys.ENTER);

        String temperature = driver.findElement(By.id("gi")).getText();
        String day = driver.findElement(By.id("wob_dts")).getText();
        String weather = driver.findElement(By.id("wob_dc")).getText();
        String location = driver.findElement(By.xpath("//span[@class='BBwThe']")).getText();

        System.out.println("For "+ day);
        System.out.println("Temperature is :"+ temperature + "°C");
        System.out.println("Weather is :"+ weather);
        System.out.println("Location is :"+ location + "\n");
    }
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement translate = driver.findElement(By.xpath("//*[@id='SIvCob']/a"));
        translate.click();

        weatherForescasting today= new weatherForescasting(driver,"Weather Today");
        WebElement cleaning = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        cleaning.clear();
        weatherForescasting tomorrow= new weatherForescasting(driver,"Weather Tomorrow");

    }
}

