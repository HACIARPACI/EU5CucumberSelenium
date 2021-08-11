package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ContactsStepDefs {
    @Given("the user logged in as {string}")
    public void the_user_logged_in_as(String userType) {
        //go to login page
        Driver.get().get(ConfigurationReader.get("url"));
        //based on input enter that user information
        String username=null;
        String password= null;
        if(userType.toLowerCase().equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");

        }else if(userType.toLowerCase().equals("sales manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        }
        else if(userType.toLowerCase().equals("store manager")){
            username= ConfigurationReader.get("store_manager_username");
            password= ConfigurationReader.get("store_manager_password");

        }
        //send username and password
        BrowserUtils.waitFor(3);
        new LoginPage().login(username,password);

    }

    @Then("the user should see following options")
    public void the_user_should_see_following_options(List<String> expectedOptions) {
        BrowserUtils.waitFor(3);
        System.out.println(expectedOptions.size());
        System.out.println(expectedOptions);
        //get the list of web element and convert them to list of string assert

        List<String> actualOptions = BrowserUtils.getElementsText(new DashboardPage().menuOptions);

        Assert.assertEquals(expectedOptions,actualOptions);
        System.out.println("expectedOptions = " + expectedOptions);
        System.out.println("actualOptions = " + actualOptions);
    }
    @When("the user logs in usign following credentials")
    public void the_user_logs_in_usign_following_credentials(Map<String,String>userInfo) {

        System.out.println(userInfo);
        //use map info to log in and verify first and last name
        LoginPage loginPage= new LoginPage();
        loginPage.login(userInfo.get("username"),userInfo.get("password"));

        //verify first and last name
        String actualName= new DashboardPage().getUserName();
        String expectedNAme= userInfo.get("firstname")+" "+userInfo.get("lastname");
        Assert.assertEquals(expectedNAme,actualName);
        System.out.println(expectedNAme);
        System.out.println(actualName);


    }

}