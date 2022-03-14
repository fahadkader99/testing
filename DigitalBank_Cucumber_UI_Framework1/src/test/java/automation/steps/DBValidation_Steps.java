package automation.steps;

import automation.utils.Constant_Storage;
import automation.utils.DataBaseUtils;
import automation.utils.PropertyReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.ResultSet;

public class DBValidation_Steps {



    @Then("verify all details updated in database")
    public void verify_all_details_updated_in_database() throws Exception{
        String email = Constant_Storage.inputDataOnUI.get("Email");
        String query = PropertyReader.getProperty("fetch.userdata");

        query = String.format(query,email);                     // here I am replacing %s value with email || passing the email to the query (%s) dynamically, check property file.
        ResultSet rs = DataBaseUtils.execute_Query(query);      // now executing the query
        rs.next();                                              // by default ResultSet cursor is always in the 1st row, so we have to move it to next, since we are not using while loop.



        // Saving the data from DataBase to out Constant DB Map

        Constant_Storage.dataFromDataBase.put("email",rs.getString("email_address"));
        Constant_Storage.dataFromDataBase.put("title",rs.getString("title"));
        Constant_Storage.dataFromDataBase.put("firstname", rs.getString("first_name"));
        Constant_Storage.dataFromDataBase.put("lastname",rs.getString("last_name"));
        Constant_Storage.dataFromDataBase.put("gender",rs.getString("gender"));
        Constant_Storage.dataFromDataBase.put("dob",rs.getString("dob"));
        Constant_Storage.dataFromDataBase.put("ssn",rs.getString("ssn").replace("-",""));  // replacing coz the data we are getting is with -, but in our system without - and it will fail out test

        // Printing the value for debugging purpose only:
        System.out.println("\nData entered in UI -> "+Constant_Storage.inputDataOnUI);
        System.out.println("Data from DB -> "+ Constant_Storage.dataFromDataBase);

        Assert.assertTrue("Data from UI is not matching with Data in Database",Constant_Storage.inputDataOnUI.equals(Constant_Storage.dataFromDataBase));     // comparing to Maps with the data in them

/*
* Data entered in UI -> {Title=Mr., FirstName=Test, LastName=Automation, DOB=06/01/1994, Gender=M, Ssn=261489948, Email=Kader319380261@gmail.com}
Data from DB -> {email=Kader319380261@gmail.com, title=Mr., firstname=Test, lastname=Automation, gender=M, dob=1994-06-01 00:00:00, ssn=261489948}
* */

    }

}
