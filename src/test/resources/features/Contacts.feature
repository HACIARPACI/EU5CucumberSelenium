Feature: Contacts Page
  @smoke
  Scenario: Default page number
    Given the user is on the login page
    And the user enters the driver info
    When the user navigates to "Customers" "Contacts"
    Then default page number should be 1


  Scenario: Verify Create Calender Event
    Given the user is on the login page
    And the user enters the salesmanager info
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calender"
# make calendar to calender to fail

  Scenario: Menu Options
    Given  the user logged in as "driver"
    Then  the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |


  Scenario: Menu Options
    Given  the user logged in as "sales manager"
    Then  the user should see following options
      | Dashboards    |
      | Fleet      |
      | Customers  |
      | Sales |
      | Activities     |
      | Marketing  |
      | Reports & Segments|
      | System     |

    Scenario: login as a given user
    Given the user is on the login page
     When  the user logs in usign following credentials
      |username|user10|
      |password|UserUser123|
      |firstname|Brenden|
      |lastname|Schneider|
    Then the user should be able top login


  Scenario Outline: login as a given user<user>
    Given the user is on the login page
    When  the user logs in usign following credentials
      |username|<user>|
      |password|UserUser123|
      |firstname|<firstname>|
      |lastname|<lastname>|
    Then the user should be able top login
    Examples:
      | user           | firstname | lastname  |
      | user10         | Brenden   | Schneider |
      | storemanager85 | Stephan Tremaine   | Haley     |

    Scenario: Contacts test with email
      Given the user logged in as "sales manager"
      And the user navigates to "Customers" "Contacts"
      When the user clicks the "mbrackstone9@example.com" from contacts
      Then the information should be same with database

  @wip
  Scenario: Contacts test with email
    Given the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "mike.jorden@hotmail.com" from contacts
    Then the information for "mike.jorden@hotmail.com" should be same with database

  Scenario Outline: Contacts Test
    Given the user logged in as "sales manager"
    And the user navigates to "Customers" "Contacts"
    When the user clicks the "<email>" from contacts
    Then the information for "<email>" should be same with database

    Examples:
      |email|
      |mbrackstone9@example.com|
      |mike.jorden@hotmail.com |

   @db
    Scenario Outline: Activities Calendar Events
      Given the user logged in as "sales manager"
      And the user navigates to "Activities" "Calendar Events"
      When the user clicks the "<title>"
      Then information for title should be same with database
      
      Examples:
      |title|
      |Meeting|


  @wips @db
  Scenario: Vehicle model UI DB Comparison
    Given the user is on the login page
    Given the user logged in as "sales manager"
    And the user navigates to "Fleet" "Vehicles Model"
    When the user clicks the "Mazda" from List
    Then the Vehicle model information should be same with database
      