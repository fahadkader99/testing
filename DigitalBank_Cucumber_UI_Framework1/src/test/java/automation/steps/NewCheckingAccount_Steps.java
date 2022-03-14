package automation.steps;

import automation.pages.NewCheckingAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NewCheckingAccount_Steps {

    NewCheckingAccountPage newCheckingAccountPage = new NewCheckingAccountPage();

    @Then("user should be redirected to Create Checking page")
    public void userShouldBeRedirectedToCreateCheckingPage() {
        newCheckingAccountPage.verifyUserIsOnNewCheckingAccountPage();
    }

    @When("user is on New Checking page")
    public void userIsOnNewCheckingPage() {
        newCheckingAccountPage.verifyUserIsOnNewCheckingAccountPage();
    }

    @And("user should be able to see Select Checking Account Type")
    public void userShouldBeAbleToSeeSelectCheckingAccountType() {
        newCheckingAccountPage.verifyUserIsAbleToSeeCheckingAccountType();
    }

    @Then("Verify {string} is visible")
    public void verifyIsVisible(String arg0) {
        newCheckingAccountPage.verifyCheckingAccountTypeIsVisible(arg0);
    }


    @Then("user should be able to see {string}")
    public void userShouldBeAbleToSee(String arg0) {
        newCheckingAccountPage.verifySelect_Account_Ownership_Is_Visible(arg0);
    }

    @And("verify {string} is visible at New Checking Page")
    public void verifyTitleIsVisible(String arg0) {
        newCheckingAccountPage.verifySelect_Acc_Ownership_RadioBtn_Are_Visible(arg0);
    }


    @Then("user should be able to see Account Name")
    public void userShouldBeAbleToSeeAccountName() {
        newCheckingAccountPage.verifyAccount_Name_Is_Displayed();
    }

    @And("user should be able to input alphanumeric and special character")
    public void userShouldBeAbleToInputAlphanumericAndSpecialCharacter() {
        newCheckingAccountPage.verifyUserCanSend_Alphanumeric_ANdSpecialCharacter();
    }

    @Then("user should be able to see line Initial Deposit Amount")
    public void userShouldBeAbleToSeeLineInitialDepositAmount() {
        Assert.assertTrue("Deposit Amount is not visible", newCheckingAccountPage.initialDepositAmountTitle.isDisplayed());
    }

    @And("user should be able to input ${int} to be deposited")
    public void userShouldBeAbleToInput$ToBeDeposited(int arg0) {
        newCheckingAccountPage.verify_User_CanDeposit_Money(arg0);
    }

    @Then("user select Standard checking")
    public void userSelectStandardChecking() {
        newCheckingAccountPage.userSelect_Standard_Checking();
    }

    @And("user select Individual")
    public void userSelectIndividual() {
        newCheckingAccountPage.userSelect_IndividualType();
    }

    @When("user enter TestName on the Account Name field")
    public void userEnterTestNameOnTheAccountNameField() {
        newCheckingAccountPage.userEnter_TestName_In_NameField();
    }

    @Then("user clicks on Submit button")
    public void userClicksOnSubmitButton() {
        newCheckingAccountPage.userClicksOn_Submit_Btn();
    }


}
