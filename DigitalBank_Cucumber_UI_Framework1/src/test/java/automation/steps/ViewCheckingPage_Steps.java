package automation.steps;

import automation.pages.ViewCheckingPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ViewCheckingPage_Steps {

    ViewCheckingPage viewCheckingPage = new ViewCheckingPage();


    @And("verify user is redirected to the View Checking page")
    public void verifyUserIsRedirectedToTheViewCheckingPage() {
        Assert.assertTrue("View checking page is not available yet", viewCheckingPage.viewCheckingPageTitle.isDisplayed());
    }


    @When("user clicks on {string} dropdown menu")
    public void userClicksOnDropdownMenu(String arg0) {
        viewCheckingPage.userClicksOnCheckingDropDown(arg0);
    }

    @Then("and verify {string} are displayed")
    public void andVerifyAreDisplayed(String arg0) {
        viewCheckingPage.verifyDropDownMenuAreDisplayed(arg0);
    }

    @And("when user clicks on {string} dropdown")
    public void whenUserClicksOnDropdown(String arg0) {
        viewCheckingPage.userClicksOnViewCheckingDropDown(arg0);
    }

    @And("verify Transactions table are displayed")
    public void verifyTransactionsTableAreDisplayed() {
        Assert.assertTrue("Transaction is not displayed", viewCheckingPage.checkingTransactionTableTitle.isDisplayed());
    }


    @Then("verify  {string} is displayed")
    public void verifyIsDisplayed(String arg0) {
        viewCheckingPage.verifyAllHeaderIsDisplayed(arg0);
    }

    @And("verify on or off button is displayed")
    public void verifyOnOrOffButtonIsDisplayed() {
        viewCheckingPage.verifyOnOffBtnIsDisplayed();
    }


    @Then("verify  on button is selected")
    public void verifyOnButtonIsSelected() {
        Assert.assertTrue("On button is not selected",viewCheckingPage.OnBtn.isEnabled());
    }

    @And("verify user can see history of account activity")
    public void verifyUserCanSeeHistoryOfAccountActivity() {
        viewCheckingPage.verifyAccountActivity();
    }
}
