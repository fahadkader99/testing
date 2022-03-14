package automation.steps;

import automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePage_Steps {

    HomePage homePage = new HomePage();

    @Then("verify user is navigated to Home page.")
    public void verify_user_is_navigated_to_home_page() {
        Assert.assertTrue("Welcome message is not displayed", homePage.welcomeMessage.isDisplayed());
    }

    @Then("verify welcome message is displayed on right top header")
    public void verify_welcome_message_is_displayed_on_right_top_header() {
        Assert.assertTrue("Welcome message is not displayed", homePage.welcomeMessage.isDisplayed());
    }

    @Then("user should see home title displayed")
    public void user_should_see_home_title_displayed() {
        Assert.assertTrue("Home Title is missing",homePage.homeTitle.isDisplayed());
    }

    @Then("user should see checking category on home page")
    public void user_should_see_checking_category_on_home_page() {
        Assert.assertTrue("CheckIn title is missing on homepage",homePage.checkInCategory.isDisplayed());
    }

    @Then("user should see savings category on the home page")
    public void user_should_see_savings_category_on_the_home_page() {
        Assert.assertTrue("Savings category is missing from homepage", homePage.savingsCategory.isDisplayed());
    }

    @Then("user should see external category on the home page")
    public void user_should_see_external_category_on_the_home_page() {
        Assert.assertTrue("External Title is missing from homepage", homePage.externalCategory.isDisplayed());
    }

    @Then("user should see TRANSACTIONS title on home page")
    public void user_should_see_transactions_title_on_home_page() {
        Assert.assertTrue("Transaction title is missing",homePage.transactionTitle.isDisplayed());
    }

    @Then("user should see Deposit category")
    public void user_should_see_deposit_category() {
        Assert.assertTrue("Deposit title is missing", homePage.depositCategory.isDisplayed());
    }

    @Then("user should see withdraw category")
    public void user_should_see_withdraw_category() {
        Assert.assertTrue("Withdraw Title is missing ", homePage.withdrawCategory.isDisplayed());
    }

    @Then("user should see Transfer Between Accounts category")
    public void user_should_see_transfer_between_accounts_category() {
        Assert.assertTrue("Transfer between account is not visible", homePage.transferBetweenAccCategory.isDisplayed());
    }

    @Then("user should see VISA Direct Transfer category")
    public void user_should_see_visa_direct_transfer_category() {
        Assert.assertTrue("Visa Direct Transfer is not available",homePage.visaDirectTransferCategory.isDisplayed());
    }

    @When("user clicks on {string} dropdown")
    public void userClicksOnDropdown(String arg0) {
        homePage.verifyUserClickOnDropDownButton(arg0);
    }

    @Then("verify {string} are visible")
    public void verifyAre(String arg0) {
        homePage.viewCheckingIsVisible(arg0);

    }

    @And("select {string}")
    public void select(String arg0) {
        homePage.userSelectNewChecking(arg0);
    }



}
