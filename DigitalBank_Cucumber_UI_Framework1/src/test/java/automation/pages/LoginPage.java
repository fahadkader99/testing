package automation.pages;

import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "submit")
    public WebElement signInBtn;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//div[contains(@class,'register-link')]//a")
    WebElement signUpBtn;

    @FindBy(xpath = "//span[@class='badge badge-pill badge-success']")
    WebElement verifySuccessMessage;

    public void doLogin(){
        userNameBox.sendKeys(PropertyReader.getProperty("login.username"));
        passwordBox.sendKeys(PropertyReader.getProperty("login.password"));
        signInBtn.click();
    }



    public void openWebsite(){
        driver.get(PropertyReader.getProperty("app.url"));
    }

    public void verifyLoginPage(){
        Assert.assertTrue("Sign in Button is missing ", signInBtn.isDisplayed());
    }

    public void userOpenDigitalBank() {
        driver.get(PropertyReader.getProperty("bank.url"));
    }

    public void clickOnSignUpBtn() {
        signUpBtn.click();
    }

    public void verifyRegistrationSuccessMessage() {
        Assert.assertTrue("Registration Success Message is not visible",verifySuccessMessage.isDisplayed());
    }
}
