package automation.steps;

import automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_steps {

    LoginPage loginPage = new LoginPage();


    @Given("user open website")
    public void userOpenWebsite() {
        loginPage.userOpenWebsite();
    }


    @Then("verify user is at the login page")
    public void verifyUserIsAtTheLoginPage() {
        loginPage.verifyLoginPage();
    }

    @And("user input valid credentials")
    public void userInputValidCredentials() {
        loginPage.userInputCredentials();
    }

    @When("user clicks on the sign in button")
    public void userClicksOnTheSignInButton() {
        loginPage.userClickSignIn();
    }


}
