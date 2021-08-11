package com.vytrack.step_definitions;

import com.vytrack.pages.ContactsPage;
import com.vytrack.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class deneme {
    @When("the user click on {int} on filter button")
    public void the_user_click_on_on_filter_button(Integer int1) {

        ContactsPage contactsPage= new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.viewPerPage.click();
        BrowserUtils.waitFor(5);
        contactsPage.viewPer50.click();

    }
    @Then("the user able to see the {int} row in selected")
    public void the_user_able_to_see_the_row_in_selected(Integer expected) {

        ContactsPage contactsPage= new ContactsPage();
        int actual = contactsPage.rows.size();
        Assert.assertEquals(expected+"",actual);

    }
    }


