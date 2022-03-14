package automation.pages;

import automation.utils.CommonMethods;
import automation.utils.Constant_Storage;
import automation.utils.PropertyReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage{

    @FindBy(xpath = "//strong[text()='Title']")
    WebElement signUpPageTitle;

    @FindBy(id = "title")
    WebElement titleDropDown;

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='gender'][@value='M']")
    WebElement maleRadioButton;

    @FindBy(id = "dob")
    WebElement birthDay;

    @FindBy(id = "ssn")
    WebElement ssn;

    @FindBy(id = "emailAddress")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit'][text()='Next']")
    WebElement nextBtn;


    public void verifySignUpPage() {
        Assert.assertTrue("SignUp page Title is not present", signUpPageTitle.isDisplayed());
        Assert.assertTrue("First Name field is missing", firstName.isDisplayed());
    }

    public void fillSignUpPageDetails() {

        String title = PropertyReader.getProperty("signup.title");
        String FirstName = PropertyReader.getProperty("signup.firstname");
        String LastName = PropertyReader.getProperty("signup.lastname");
        String dob = PropertyReader.getProperty("signup.dob");
        String pass = PropertyReader.getProperty("signup.password");
        String ssnNum = CommonMethods.generateRandomSSN();
        String emailAdd = PropertyReader.getProperty("signup.email.prefix")+CommonMethods.generateRandomSSN()+"@gmail.com";

        Constant_Storage.inputDataOnUI.put("Title",title);
        Constant_Storage.inputDataOnUI.put("FirstName",FirstName);
        Constant_Storage.inputDataOnUI.put("LastName",LastName);
        Constant_Storage.inputDataOnUI.put("DOB",dob);
        Constant_Storage.inputDataOnUI.put("Gender","M");
        Constant_Storage.inputDataOnUI.put("Ssn",ssnNum);
        Constant_Storage.inputDataOnUI.put("Email",emailAdd);

        Select dropdownSelect = new Select(titleDropDown);
        dropdownSelect.selectByVisibleText(title);

        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        maleRadioButton.click();
        birthDay.sendKeys(dob);
        ssn.sendKeys(ssnNum);
        email.sendKeys(emailAdd);
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);


    }

    public void clickOnNextBtn() {
        nextBtn.click();
    }
}
