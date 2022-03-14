
@Smoke
Feature: This feature is to test functionality related to the Home Page

  Background:
    Given user open website
    Then  verify user is on the Login page
    When  user click on login button
    Then  verify user is navigated to Home page.


  Scenario: Verify user is able to see welcome message.
    Then verify welcome message is displayed on right top header

  Scenario: Verify home title
    Then user should see home title displayed

  Scenario: verify checking category
    Then user should see checking category on home page

  Scenario: Verify savings category
    Then user should see savings category on the home page

  Scenario: Verify external category under banking account
    Then user should see external category on the home page

  Scenario: Verify Transactions title and categories
    Then user should see TRANSACTIONS title on home page
    And  user should see Deposit category
    And  user should see withdraw category
    And  user should see Transfer Between Accounts category
    And  user should see VISA Direct Transfer category

