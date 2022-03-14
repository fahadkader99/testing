package automation.pages;

import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "//strong[text()='Address']")
    WebElement registerPageTitle;

    @FindBy(id = "address")
    WebElement addressBox;

    @FindBy(id = "locality")
    WebElement localityBox;

    @FindBy(id = "region")
    WebElement regionBox;

    @FindBy(id = "postalCode")
    WebElement postalCode;

    @FindBy(id = "country")
    WebElement countryBox;

    @FindBy(id = "homePhone")
    WebElement homePhoneBox;

    @FindBy(id = "workPhone")
    WebElement workPhoneBox;

    @FindBy(xpath = "//input[@id='agree-terms']")
    WebElement policyCheckbox;

    @FindBy(xpath = "//button[@type='submit'][text()='Register']")
    WebElement registerBtn;



    public void verifyRegistrationPage() {
        Assert.assertTrue("Registration page Title is missing ", registerPageTitle.isDisplayed());
        Assert.assertTrue("AddressBox is missing from Registration page", addressBox.isDisplayed());
    }

    public void fillAllRegistrationDetails() {

        String address = PropertyReader.getProperty("signup.address");
        String locality = PropertyReader.getProperty("signup.locality");
        String region = PropertyReader.getProperty("signup.region");
        String postal = PropertyReader.getProperty("signup.postal");
        String country = PropertyReader.getProperty("signup.country");
        String homePhone = PropertyReader.getProperty("signup.homePhn");
        String workPhone = PropertyReader.getProperty("signup.workPhn");

        // Have to add the data to the Map

        addressBox.sendKeys(address);
        localityBox.sendKeys(locality);
        regionBox.sendKeys(region);
        postalCode.sendKeys(postal);
        countryBox.sendKeys(country);
        homePhoneBox.sendKeys(homePhone);
        workPhoneBox.sendKeys(workPhone);
        policyCheckbox.click();
        regionBox.click();

    }

    public void clickOnRegistrationBtn() {
        registerBtn.click();
    }
}
