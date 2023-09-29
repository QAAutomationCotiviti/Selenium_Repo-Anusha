package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserFactory {
    public static WebDriver driver;
    public static WebDriver WebDriver(String browserName) {
        switch(browserName.toLowerCase()){
            case "chrome":driver =new ChromeDriver();
            break;
            case "edge":driver =new EdgeDriver();
            break;
            case "firefox":driver =new FirefoxDriver();
            break;
            default:
                System.out.println("Invalid browser name" +browserName);
//                exit(1);
        }return driver;

    }
}
