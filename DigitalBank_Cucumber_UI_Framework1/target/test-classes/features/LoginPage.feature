Feature: This feature is to test login functionality of the page
  Scenario: v=Verify user can login.
    Given user open website
    Then  verify user is on the Login page
    When  user click on login button
    Then  verify user is navigated to Home page.