package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends  BasePage{

    @FindBy(css=".input-widget")
    public WebElement pageNumber;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public  WebElement viewPer50;

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']//button")
    public WebElement viewPerPage;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement>rows;

    public WebElement getContactEmail(String email){
        String xpath = "//*[contains(text(), '"+email+"') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }
    public WebElement getTitle(String title){
        String xpath = "//td[text()='"+title+"']";
        return Driver.get().findElement(By.xpath(xpath));
    }


}
