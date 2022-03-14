package automation.steps;

import automation.pages.HomePage;
import automation.utils.DriverUtils;
import automation.utils.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setUp(){

        PropertyReader.initProperties();

        String platform = PropertyReader.getProperties("platform");

        if (platform.equals("local")){
            DriverUtils.createDriver();
        }
        else if (platform.equals("grid")){
            DriverUtils.selenium_Grid_Driver();
        }
        else {
            throw new RuntimeException("<-- Invalid platform selected @Before Hooks | check driver settings -- >");
        }


    }



    @After
    public void closeUp(){
        HomePage homePage = new HomePage();
        homePage.userClicksSignOutButton();         // Logout function.

        DriverUtils.getDriver().close();
    }


}
