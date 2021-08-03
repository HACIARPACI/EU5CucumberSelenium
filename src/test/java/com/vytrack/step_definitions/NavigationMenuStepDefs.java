package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuStepDefs {




    @When("salesmanager navigate to Fleet-Vehicles")
    public void salesmanager_navigate_to_Fleet_Vehicles() {
        System.out.println("  sales manager navigate to  fleet vehicles ");

    }
    @Then("the title is Vehicles")
    public void the_title_is_Vehicles() {
        System.out.println(" title is Vehicles");

    }

    @When("salesmanager navigate to Marketing-Campaigns")
    public void salesmanager_navigate_to_Marketing_Campaigns() {
        System.out.println(" salesmanager navigate to Marketing-Campaigns");
    }

    @Then("the title is Campaigns")
    public void the_title_is_Campaigns() {
        System.out.println("the title is Campaigns");
    }

    @When("salesmanager navigate to Activities-Calendar Events")
    public void salesmanager_navigate_to_Activities_Calendar_Events() {
        System.out.println("salesmanager navigate to Activities-Calendar Events");
    }

    @Then("the title is Calendars")
    public void the_title_is_Calendars() {
        System.out.println("the title is Calendar");
    }


}
