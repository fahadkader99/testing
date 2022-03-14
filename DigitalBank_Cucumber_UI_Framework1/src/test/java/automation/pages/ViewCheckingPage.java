package automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCheckingPage extends BasePage{

    @FindBy(xpath = "//h1[@id='page-title']")
    public WebElement viewCheckingPageTitle;

    @FindBy(xpath = "//strong[@class='card-title text-light']")
    public WebElement checkingTransactionTableTitle;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement inputOnOffBtn;

    @FindBy(xpath = "//span[@class='switch-label']")
    public WebElement OnBtn;

    @FindBy(xpath = "//tbody/tr/td[contains(text(),'Income')]")
    WebElement accActivityIncome;

    String XPATH_CHECKING_DROPDOWN = "//a[@id='%s-menu']";

    String XPATH_CHECKING_ACC_OPTIONS = "//a[@id = '%s-menu-item']";

    String XPATH_CHECKING_PAGE_HEADER = "//tr[@class='bg-secondary text-light']/th[text()='%s']";



    public void userClicksOnCheckingDropDown(String arg0) {
        String checking = String.format(XPATH_CHECKING_DROPDOWN,arg0);
        WebElement checkingAccType = driver.findElement(By.xpath(checking));
        checkingAccType.click();

    }

    public void verifyDropDownMenuAreDisplayed(String arg0) {
        String checkingMenu = String.format(XPATH_CHECKING_ACC_OPTIONS,arg0);
        WebElement checkingMenuOptions = driver.findElement(By.xpath(checkingMenu));
        checkingMenuOptions.click();
    }

    public void userClicksOnViewCheckingDropDown(String arg0) {
        String viewChecking = String.format(XPATH_CHECKING_ACC_OPTIONS,arg0);
        WebElement viewCheckingBtn = driver.findElement(By.xpath(viewChecking));
        viewCheckingBtn.click();
    }

    public void verifyAllHeaderIsDisplayed(String arg0) {
        String header = String.format(XPATH_CHECKING_PAGE_HEADER,arg0);
        WebElement viewAllHeader = driver.findElement(By.xpath(header));
        viewAllHeader.click();
    }

    public void verifyOnOffBtnIsDisplayed() {
        Assert.assertTrue("On Of button is not Displayed",inputOnOffBtn.isEnabled());
    }


    public void verifyAccountActivity() {
        Assert.assertTrue("Income is not shown",accActivityIncome.isDisplayed());
    }
}

