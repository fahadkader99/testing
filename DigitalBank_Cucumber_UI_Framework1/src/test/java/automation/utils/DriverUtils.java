package automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverUtils {

    static WebDriver driver;

    public static void createDriver(){

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")){

            System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
            driver = new ChromeDriver();

        }else if (browserName.equals("firefox")){

            System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver");
            driver = new FirefoxDriver();

        }else if (browserName.equals("edge")){

            System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver");
            driver = new EdgeDriver();

        }else if (browserName.equals("safari")){

            System.setProperty("webdriver.safari.driver","/usr/bin/safaridriver");
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));


    }


    public static WebDriver getDriver(){
        return driver;
    }

    public static void create_SauceLab_Driver(){
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("latest");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-ashikulf-f0f7d");
        sauceOptions.put("accessKey", "9eb8ce2f-a625-440f-a74e-adedaad222e7");
        sauceOptions.put("name", "First Remote Test");

        options.setCapability("sauce:options", sauceOptions);
        URL url = null;
        try {
            url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new RemoteWebDriver(url, options);
    }


    public static void create_BrowserStack_Driver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");

        try {
            driver = new RemoteWebDriver(new URL("https://ashikul_D9s6Gm:yqnw6qM3JEyfA1F7MADq@hub-cloud.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }



}
