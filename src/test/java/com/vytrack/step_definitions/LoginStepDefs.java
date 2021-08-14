package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.get("url");
        //WebDriver driver= Driver.get(); singleton concept  driver sınıfında Webdriver drievr tanımlandı
        Driver.get().get(url);

    }

    @When("the user enters the driver info")
    public void the_user_enters_the_driver_info() {
       String username= ConfigurationReader.get("driver_username");
       String password= ConfigurationReader.get("driver_password");
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the user should be able top login")
    public void the_user_should_be_able_top_login() {
        BrowserUtils.waitFor(5);
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
    }
    @When("the user enters the salesmanager info")
    public void the_user_enters_the_salesmanager_info() {
        String username= ConfigurationReader.get("sales_manager_username");
        String password= ConfigurationReader.get("sales_manager_password");
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user enters the store manager username and password")
    public void the_user_enters_the_storemanager_username_and_password() {
        String username= ConfigurationReader.get("store_manager_username");
        String password= ConfigurationReader.get("store_manager_password");
        Driver.get().get(ConfigurationReader.get("url"));
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
       LoginPage login = new LoginPage();
       login.login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {

        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }


}
