package automation.pages;

import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "remember-me")
    private WebElement rememberMeBox;

    @FindBy(id = "submit")
    private WebElement signInBtn;


    public void userOpenWebsite() {
        String page = PropertyReader.getProperties("app.url");
        driver.get(page);
    }

    public void verifyLoginPage() {
        Assert.assertTrue("Sign button is not present",signInBtn.isDisplayed());
    }

    public void userInputCredentials() {
        userNameField.sendKeys(PropertyReader.getProperties("login.username"));
        passwordField.sendKeys(PropertyReader.getProperties("login.password"));
        rememberMeBox.click();

    }

    public void userClickSignIn() {
        signInBtn.click();
    }
}
