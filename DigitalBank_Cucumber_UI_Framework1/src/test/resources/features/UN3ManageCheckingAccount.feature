Feature: this feature is to test if the user have the ability to view there Checking
  bank account and user can manage it.

  Background:
    Given user open website
    Then  verify user is on the Login page
    When  user click on login button
    Then  verify user is navigated to Home page.


  Scenario Outline: verify Transactions table is displayed
    When user clicks on "checking" dropdown menu
    Then and verify "<checkingMenus>" are displayed
    Examples:
      | checkingMenus |
      | view-checking |
      | new-checking  |

  Scenario: user is able to see View Checking page Transactions
    When user clicks on "checking" dropdown menu
    And when user clicks on "view-checking" dropdown
    Then verify user is redirected to the View Checking page
    And verify Transactions table are displayed


  Scenario Outline: verify "Date" header is displayed under transaction table
    When user clicks on "checking" dropdown menu
    And when user clicks on "view-checking" dropdown
    Then verify user is redirected to the View Checking page
    Then verify  "<header>" is displayed
    Examples:
      | header      |
      | Date        |
      | Category    |
      | Description |
      | Amount      |
      | Balance     |

    Scenario: Verify that only 1 checking account is Activated
      When user clicks on "checking" dropdown menu
      And when user clicks on "view-checking" dropdown
      Then verify user is redirected to the View Checking page
      And verify on or off button is displayed
      Then verify  on button is selected

      Scenario: Verify transaction history is displayed
        When user clicks on "checking" dropdown menu
        And when user clicks on "view-checking" dropdown
        Then verify user is redirected to the View Checking page
        And verify user can see history of account activity