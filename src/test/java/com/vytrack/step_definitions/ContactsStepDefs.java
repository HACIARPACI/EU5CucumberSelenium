package com.vytrack.step_definitions;

import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
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
    @When("the user clicks the {string} from contacts")
    public void the_user_clicks_the_from_contacts(String email) {

    //    BrowserUtils.waitFor(4);
       new ContactsPage().waitUntilLoaderScreenDisappear();
    new ContactsPage().getContactEmail(email).click();

    }

    @Then("the information should be same with database")
    public void the_information_should_be_same_with_database() {
    // get info from UI
        new ContactInfoPage().waitUntilLoaderScreenDisappear();

        ContactInfoPage contactInfoPage= new ContactInfoPage();
        contactInfoPage.waitUntilLoaderScreenDisappear();
        String actualFullName = contactInfoPage.contactFullName.getText();
        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullName = " + actualFullName);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);


        //get info from database
        //create connection o hooks

        // we are getting only one row
        String query ="select concat (c.first_name,' ',c.last_name) as \"fullname\",e.email,p.phone\n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id=e.owner_id\n" +
                "join orocrm_contact_phone p\n" +
                "on e.owner_id=p.owner_id\n" +
                "where e.email='mbrackstone9@example.com';";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
          String expectedFullName= (String) rowMap.get("fullname");
          String expectedPhone = (String) rowMap.get("phone");
          String expectedEmail= (String) rowMap.get("email");

        System.out.println("expectedFullName = " + expectedFullName);
        System.out.println("expectedPhone = " + expectedPhone);
        System.out.println("expectedEmail = " + expectedEmail);

        //close connection on hooks


        //assertion


        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);

    }
    @Then("the information for {string} should be same with database")
    public void the_information_for_should_be_same_with_database(String email) {
        //get information from UI
        ContactInfoPage contactInfoPage = new ContactInfoPage();
        BrowserUtils.waitFor(5);
        String actualFullName = contactInfoPage.contactFullName.getText();


        String actualEmail = contactInfoPage.email.getText();
        String actualPhone = contactInfoPage.phone.getText();

        System.out.println("actualFullName = " + actualFullName);
        System.out.println("actualEmail = " + actualEmail);
        System.out.println("actualPhone = " + actualPhone);

        //get information from database

        //we are getting only one row of result
        //query for retrieving firstname,lastname,email,phone
        String query ="select concat(first_name,' ',last_name) as \"full_name\",e.email,phone\n" +
                "from orocrm_contact c join orocrm_contact_email e\n" +
                "on c.id = e.owner_id join orocrm_contact_phone p\n" +
                "on e.owner_id = p.owner_id\n" +
                "where e.email='"+email+"'";
        //get info and save in the map
        Map<String, Object> rowMap = DBUtils.getRowMap(query);

        String expectedFullName = (String) rowMap.get("full_name");
        String expectedPhone = (String) rowMap.get("phone");
        String expectedEmail = (String) rowMap.get("email");

        System.out.println("expectedFullName = " + expectedFullName);
        System.out.println("expectedPhone = " + expectedPhone);
        System.out.println("expectedEmail = " + expectedEmail);


        //assertion, Compare UI against to DB
        Assert.assertEquals(expectedFullName,actualFullName);
        Assert.assertEquals(expectedEmail,actualEmail);
        Assert.assertEquals(expectedPhone,actualPhone);


    }
    @When("the user clicks the {string}")
    public void the_user_clicks_the(String title) {
        new ContactsPage().waitUntilLoaderScreenDisappear();
        new ContactsPage().getTitle(title).click();
        BrowserUtils.waitFor(3);

    }

    @Then("information for title should be same with database")
    public void information_for_title_should_be_same_with_database() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        String actualTitle= calendarEventsPage.actualTitle.getText();
        String actualDescription= calendarEventsPage.actualDescription.getText();
        String actualStart= calendarEventsPage.actualStart.getText();

        System.out.println("actualTitle = " + actualTitle);
        System.out.println("actualDescription = " + actualDescription);
        System.out.println("actualStart = " + actualStart);


    }

}
