package automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverUtils {

    static WebDriver driver;

    public static void createDriver(){

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            System.out.println("Error on properties: "+ e.toString());
        }


        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();

        }
        else if (browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver");
            driver = new FirefoxDriver();

        }
        else if (browserName.equals("safari")){
            System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
            driver = new SafariDriver();

        }
        else if(browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver");
            driver = new EdgeDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

    }

    public static WebDriver getDriver(){
        return driver;
    }


    public static void selenium_Grid_Driver(){

        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setBrowserName("chrome");
        cap.setCapability(CapabilityType.BROWSER_NAME,"firefox");


        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.179:4444"),cap);
        } catch (MalformedURLException e) {
            System.out.println("Error occurred on Selenium Grid setup: "+ e.toString());
        }

    }





}
