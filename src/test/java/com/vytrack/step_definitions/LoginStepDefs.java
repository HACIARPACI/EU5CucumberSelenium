package com.vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.out.println("i open browser and  navigate to vutrack login page");
    }

    @When("the user enters the driver info")
    public void the_user_enters_the_driver_info() {
        System.out.println("ı put user1 username and UserUser123 password and click login button");
    }

    @Then("the user should be able top login")
    public void the_user_should_be_able_top_login() {
        System.out.println("i verified title changrd to dashboard");
    }
    @When("the user enters the salesmanager info")
    public void the_user_enters_the_salesmanager_info() {
        System.out.println("ı entered salesmanager uername and password ");
    }
    @When("the user enters the store manager username anmd password")
    public void the_user_enters_the_storemanager_username_anmd_password() {
        System.out.println("i logged in as a store manager");
    }


}
