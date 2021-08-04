@Navigate
Feature: Navigation
  @Vehicles
  Scenario: Navigate to Fleet --> Vehicles
    Given the user is on the login page
    And the user enters the salesmanager info
    When the user navigate to Fleet-Vehicles
    Then the title is Vehicles
    @db @Campaigns
    Scenario: Navigate to Marketing --> Campaigns
      Given the user is on the login page
      And the user enters the salesmanager info
      When the user navigate to Marketing-Campaigns
      Then the title is Campaigns
      @Calendar_Events
      Scenario: Navigate to Activities--> Calendar Events
        Given the user is on the login page
        And the user enters the salesmanager info
        When the user navigate to Activities-Calendar Events
        Then the title is Calendars
