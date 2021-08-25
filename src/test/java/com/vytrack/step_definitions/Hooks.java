package com.vytrack.step_definitions;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.DBUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before(order = 1)
    public void setUp(){

        System.out.println("\t  this comes from BEFORE");
      //  Driver.get().get(ConfigurationReader.get("url"));
    }
    @After(order = 2)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
        final byte[]screenshot= ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }
    @Before(value = "@db",order = 2)
    public void setUpdb(){

        System.out.println("\t  connecting to database");
        DBUtils.createConnection();
    }
    @After(value = "@db",order = 1)
    public void tearDowndb(){

        System.out.println("\t  disconnecting from database");
        DBUtils.destroy();
    }
}
