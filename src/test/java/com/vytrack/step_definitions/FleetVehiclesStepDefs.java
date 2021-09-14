package com.vytrack.step_definitions;

import com.vytrack.pages.FleetVehicles;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class FleetVehiclesStepDefs {
    @When("the user clicks the {string} from List")
    public void the_user_clicks_the_from_List(String model) {
        FleetVehicles fleetVehicles= new FleetVehicles();
        fleetVehicles.waitUntilLoaderScreenDisappear();
        fleetVehicles.getModel(model).click();


    }

    @Then("the Vehicle model information should be same with database")
    public void the_Vehicle_model_information_should_be_same_with_database() {
        new FleetVehicles().waitUntilLoaderScreenDisappear();
        ArrayList<Object>actulaInfos= new ArrayList<>();
        for (String actual : BrowserUtils.getElementsText(new FleetVehicles().generalInfos)) {
            actulaInfos.add(actual);

        }
        System.out.println(actulaInfos);

        String querry="select ModelName,Make,Canberequested,Logo_id,CatalogValue,CO2Fee,Cost,TotalCost,CO2Emissions,FuelType_id,Vendors \n" +
                "from oro_ext_vehiclesmodel\n" +
                "where id= 4;";
        List<Object> expected = DBUtils.getRowList(querry);
        System.out.println(expected);

        Assert.assertFalse(expected.contains(actulaInfos));

    }
}