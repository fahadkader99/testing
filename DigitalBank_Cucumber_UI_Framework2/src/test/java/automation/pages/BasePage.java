package automation.pages;

import automation.utils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public abstract class BasePage {

     WebDriver driver;


    BasePage(){
        driver = DriverUtils.getDriver();
        PageFactory.initElements(driver,this);
    }

}
