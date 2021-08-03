package com.vytrack.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\t  this comes from BEFORE");
    }
    @After
    public void tearDown(){
        System.out.println("\t this comes from AFTER");
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
