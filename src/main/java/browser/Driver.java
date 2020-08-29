package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver driver;

    public Driver(WebDriver driver) {
        Driver.driver = driver;
    }
//    static Properties environment = PropertiesReader.loadProperties(System.getProperty("user.dir") + "/src/main/java/properties/Environment.properties");
//    static String url = environment.getProperty("URL");
//    static String wait = environment.getProperty("implicitlyWait");

    public static void openBrowser(String browserName) {
        switch (browserName.toUpperCase()) {
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new ChromeDriver();
                break;
            case "OPERA":
                WebDriverManager.operadriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName.toUpperCase());
        }
        // maximize browser's window on start
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void Visit(String url) {
        driver.get(url);
    }

    public static void CloseBrowser() {
        driver.quit();
    }
}
