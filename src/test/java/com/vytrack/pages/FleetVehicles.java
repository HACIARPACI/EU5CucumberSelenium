package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FleetVehicles extends BasePage {

    public WebElement getModel(String model){
        String xpath = "//td[@data-column-label='Model Name' and text()='"+model+"']";
        return Driver.get().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//div[@class='control-label']")
    public List<WebElement>generalInfos;

}
