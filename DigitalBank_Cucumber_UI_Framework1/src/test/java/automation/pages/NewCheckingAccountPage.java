package automation.pages;

import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewCheckingAccountPage extends BasePage{

    @FindBy(xpath = "//h1[@id='page-title']")
    public WebElement createCheckingTitle;

    @FindBy(xpath = "//label[@class='form-control-label']/strong[contains(text(),'Select Checking Account Type')]")
    public WebElement checkingAccountTypeLabel;

    String XPATH_CHECKING_ACCOUNT_TYPE = "//input[@id='%s']";

    @FindBy(xpath = "//strong[text()='Select Checking Account Type']")
    public WebElement accountOwnershipTitle;

    String XPATH_OWNERSHIP_RADIO_BRN = "//input[@id='Individual']";

    @FindBy(xpath = "//strong[text()='Account Name']")
    public WebElement accountNameTitle;

    @FindBy(id = "openingBalance")
    public WebElement accNameField;

    @FindBy(xpath = "//strong[text()='Initial Deposit Amount']")
    public WebElement initialDepositAmountTitle;

    @FindBy(id = "openingBalance")
    WebElement depositAmountField;

    @FindBy(id = "Standard Checking")
    WebElement standardCheckingBtn;

    @FindBy(id = "Individual")
    WebElement individualBtn;

    @FindBy(xpath = "//button[@id='newCheckingSubmit']")
    WebElement submitBtn;





    // ===========================================================================================

    public void verifyUserIsOnNewCheckingAccountPage() {
        Assert.assertTrue("Verify whether user is on CreateChecking page", createCheckingTitle.isDisplayed());
    }

    public void verifyUserIsAbleToSeeCheckingAccountType(){
        Assert.assertTrue("The Checking Account Type is missing",checkingAccountTypeLabel.isDisplayed());
    }


    public void verifyCheckingAccountTypeIsVisible(String arg0) {
        String acc = String.format(XPATH_CHECKING_ACCOUNT_TYPE,arg0);
        WebElement checkingAccType = driver.findElement(By.xpath(acc));
        checkingAccType.click();
    }

    public void verifySelect_Account_Ownership_Is_Visible(String arg0) {

        Assert.assertTrue("Ownership title is miss-matching", accountOwnershipTitle.isDisplayed());
    }

    public void verifySelect_Acc_Ownership_RadioBtn_Are_Visible(String arg0) {
        String ownershipBtn = String.format(XPATH_OWNERSHIP_RADIO_BRN,arg0);
        WebElement ownershipRadioBtn = driver.findElement(By.xpath(ownershipBtn));
        ownershipRadioBtn.click();
    }

    public void verifyAccount_Name_Is_Displayed() {
        Assert.assertTrue("Account Name is not displayed",accountNameTitle.isDisplayed());
    }

    public void verifyUserCanSend_Alphanumeric_ANdSpecialCharacter() {
        accNameField.sendKeys(PropertyReader.getProperty("accName"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue("Text field is empty", accNameField.isEnabled());

    }


    public void verify_User_CanDeposit_Money(int arg0) {
        depositAmountField.sendKeys(PropertyReader.getProperty("deposit"));

        Assert.assertTrue("User can not deposit money", depositAmountField.isEnabled());
    }

    public void userSelect_Standard_Checking() {
        standardCheckingBtn.click();

        Assert.assertTrue("Standard checking is not selected yet", standardCheckingBtn.isSelected());
    }

    public void userSelect_IndividualType() {
        individualBtn.click();

        Assert.assertTrue("Individual account type is not selected yet.",individualBtn.isSelected());
    }

    public void userEnter_TestName_In_NameField() {
        accNameField.sendKeys(PropertyReader.getProperty("nameField"));

    }

    public void userClicksOn_Submit_Btn() {
        submitBtn.click();
    }
}
