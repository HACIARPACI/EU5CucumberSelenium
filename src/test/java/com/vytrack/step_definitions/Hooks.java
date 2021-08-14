package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){

        System.out.println("\t  this comes from BEFORE");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){

        Driver.closeDriver();
    }
    @Before("@db")
    public void setUpdb(){

        System.out.println("\t  connecting to database");
    }
    @After("@db")
    public void tearDowndb(){
        System.out.println("\t  disconnecting from database");
    }
}
