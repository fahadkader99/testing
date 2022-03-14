package automation.steps;

import automation.pages.SignUpPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;

public class SignUp_Steps {

   SignUpPage signUpPage = new SignUpPage();

    @Then("verify signup page is displayed")
    public void verify_signup_page_is_displayed() {
         signUpPage.verifySignUpPage();
    }

    @When("user fill all detail on sign up page")
    public void user_fill_all_detail_on_sign_up_page() {
        signUpPage.fillSignUpPageDetails();
    }

    @When("click on next button")
    public void click_on_next_button() {
        signUpPage.clickOnNextBtn();
    }

}
