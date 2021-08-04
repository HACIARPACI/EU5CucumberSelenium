package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NavigationMenuStepDefs {




    @When("the user navigate to Fleet-Vehicles")
    public void salesmanager_navigate_to_Fleet_Vehicles() {
        System.out.println("  sales manager navigate to  fleet vehicles ");

    }
    @Then("the title is Vehicles")
    public void the_title_is_Vehicles() {
        System.out.println(" title is Vehicles");

    }

    @When("the user navigate to Marketing-Campaigns")
    public void salesmanager_navigate_to_Marketing_Campaigns() {
        System.out.println(" salesmanager navigate to Marketing-Campaigns");
    }

    @Then("the title is Campaigns")
    public void the_title_is_Campaigns() {
        System.out.println("the title is Campaigns");
    }

    @When("the user navigate to Activities-Calendar Events")
    public void salesmanager_navigate_to_Activities_Calendar_Events() {
        System.out.println("salesmanager navigate to Activities-Calendar Events");
    }

    @Then("the title is Calendars")
    public void the_title_is_Calendars() {
        System.out.println("the title is Calendar");



}
    @When("the user navigates to {string} {string}")
    public void the_user_navigates_to(String tab, String module) {
   new DashboardPage().navigateToModule(tab,module);


    }

    @Then("default page number should be {int}")
    public void default_page_number_should_be(Integer expectedPageNum) {
        BrowserUtils.waitFor(7);
        ContactsPage contactsPage= new ContactsPage();
        Integer actualNumber= Integer.parseInt(contactsPage.pageNumber.getAttribute("value"));
        Assert.assertEquals(expectedPageNum,actualNumber);

    }

}