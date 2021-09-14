package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CalendarEventsPage extends  BasePage{

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[text()='Meeting']")
    public WebElement actualTitle;

    @FindBy(xpath = "//p[text()='Meeting about the motorway rules']")
    public WebElement actualDescription;

    @FindBy(xpath = "//div[text()='Jan 14, 2020, 7:27 AM']")
    public WebElement actualStart;

}
