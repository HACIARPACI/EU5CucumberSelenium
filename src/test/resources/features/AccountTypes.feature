Feature: Account Types
  @wip
  Scenario: Driver user
  Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
   Then the title contains "Calendar Events - Activities"
  @wips @smoke
    Scenario:
      Given the user logged in as "sales manager"
      When the user navigates to "Customers" "Accounts"
      Then the title contains "Accounts - CustomerS"
  @wip
      Scenario:
        Given the user logged in as "store manager"
        When the user navigates to "Customers" "Contacts"
        Then the title contains "Contacts - Customers"
  @smoke
    Scenario Outline: Login with different accounts
      Given the user logged in as "<usertype>"
      When the user navigates to "<tab>" "<modules>"
      Then the title contains "<titles>"
      Examples:
        | usertype      | tab        | modules         |titles                      |
        | driver        | Activities | Calendar Events |Calendar Events - Activities|
        | sales manager | Customers  | Accounts        |Accounts - Customers        |
        | store manager | Customers  | Contacts        |Contains - Customers        |


  Scenario Outline: Login with different accounts
    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    Then the title contains "<title>"
      Examples:
        | userType      | tab        | module          | title                                                              |
        | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
        | driver        | Customers  | Accounts        | Accounts - Customers                                               |
        | driver        | Customers  | Contacts        | Contacts - Customers                                               |
        | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
        | driver        | System     | Jobs            | Jobs - System                                                      |
        | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
        | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
        | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
        | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
        | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
        | sales manager | System     | Jobs            | All - Jobs - System                                                |
        | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
        | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
        | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
        | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
        | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
        | store manager | System     | Jobs            | All - Jobs - System                                                |
        | store manager | System     | Menus           | All - Menus - System                                               |


#  Scenario: Driver user
 #   Given the user logged in as "driver"

  #Scenario:
   # Given the user logged in as "sales manager"

  #Scenario:
   # Given the user logged in as "store manager"


    Scenario Outline: Different userTypes
      Given the user logged in as "<usertype>"

      Examples:
        | usertype      |
        | driver        |
        | store manager |
        | sales manager |
        | admin         |