Feature: This feature is to sign up to the Digital Bank Account

  @db
  Scenario: Verify user can Sign Up
    Given user open digital bank website
    When  user click on sign up button
    Then  verify signup page is displayed
    When  user fill all detail on sign up page
    And   click on next button
    Then  verify register page is displayed
    When  user fill all details on register page
    And   user clicks on register button
    Then  verify registration success message
    And   verify all details updated in database


# This feature is only for database validation with Remote SQL serer ___