package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "home-menu-item")
    private WebElement homePageMenuItem;

    @FindBy(id = "page-title")
    private WebElement homePageTitle;

    @FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
    private WebElement userProfileDropDown;

    @FindBy(xpath = "//div[@class='user-menu dropdown-menu show']/a[3]")
    private WebElement logOutBtn;


    public void verifyUserAtHomePage() {
        Assert.assertTrue("Home Page is not displayed",homePageTitle.isDisplayed());
    }


    public void userClicksSignOutButton() {
        userProfileDropDown.click();
        logOutBtn.click();
    }
}
