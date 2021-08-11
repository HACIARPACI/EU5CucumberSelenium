@login
Feature: User should be able to login
  Background:  Given the user is on the login page
  @driver @VYT-123
  Scenario: Login as driver
    When the user enters the driver info
    Then the user should be able top login

    @sales_manager  @VYT-123
Scenario: Login as a salesmanager
  When the user enters the salesmanager info
  Then the user should be able top login

  @store_manager
Scenario: Login as a store manager
  When the user enters the store manager username and password
  Then the user should be able top login

