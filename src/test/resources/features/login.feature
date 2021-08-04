@login
Feature: User should be able to login
  @driver @VYT-123
  Scenario: Login as driver
    Given the user is on the login page
    When the user enters the driver info
    Then the user should be able top login
    @sales_manager  @VYT-123
Scenario: Login as a salesmanager
  Given the user is on the login page
  When the user enters the salesmanager info
  Then the user should be able top login

  @store_manager
Scenario: Login as a store manager
  Given the user is on the login page
  When the user enters the store manager username anmd password
  Then the user should be able top login
