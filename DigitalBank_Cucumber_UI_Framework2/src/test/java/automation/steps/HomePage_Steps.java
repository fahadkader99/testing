package automation.steps;

import automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class HomePage_Steps {

    HomePage homePage = new HomePage();

    @Then("verify user is navigated to home page")
    public void verifyUserIsNavigatedToHomePage() {
        homePage.verifyUserAtHomePage();
    }


}
