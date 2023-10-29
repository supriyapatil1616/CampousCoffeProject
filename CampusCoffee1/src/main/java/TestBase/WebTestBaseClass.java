package TestBase;

import Utility.DriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class WebTestBaseClass {
    public static Properties prop;
    public static WebDriver driver;

    public WebTestBaseClass() {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initilization() {
        String browserName = prop.getProperty("browserName");
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {

        } else {
            throw new RuntimeException("Please select the correct browser");
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DriverUtility.PAGE_LODE_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DriverUtility.IMPLICIT_WAIT));

    }
}
