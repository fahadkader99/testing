Feature: This feature is to test the Login Functionality

  Scenario: Verify user is able to login
    Given user open website
    Then  verify user is at the login page
    And   user input valid credentials
    When  user clicks on the sign in button
    Then  verify user is navigated to home page
