
@Smoke
Feature: This feature is to test new Checking Account functionalities

  Developer -> Chris
  Tester -> Amy
  Reviewed by -> Mr. X

  Background:
    Given user open website
    Then  verify user is on the Login page
    When  user click on login button
    Then  verify user is navigated to Home page.

  Scenario Outline: Verify available options under Checking section
    When user clicks on "checking" dropdown
    Then verify "<checkingCategories>" are visible
    Examples:
      | checkingCategories |
      | view-checking      |
      | new-checking       |

  Scenario: Verify user is redirected to new page after clicking on New Checking
    When user clicks on "checking" dropdown
    And  select "new-checking"
    Then user should be redirected to Create Checking page


  Scenario Outline: Checking Account Type categories verification
    Given user clicks on "checking" dropdown
    When  select "new-checking"
    Then user is on New Checking page
    And  user should be able to see Select Checking Account Type
    Then Verify "<CheckingAccountType>" is visible

    Examples:
      | CheckingAccountType |
      | Standard Checking   |
      | Interest Checking   |


  Scenario Outline: Select Account Ownership categories verification
    Given user clicks on "checking" dropdown
    When  select "new-checking"
    When user is on New Checking page
    Then user should be able to see "Select Account Ownership"
    And  verify "<SelectAccountOwnership>" is visible at New Checking Page
    Examples:
      | SelectAccountOwnership |
      | Individual             |
      | Joint                  |

  Scenario: Account Name element verification
    Given user clicks on "checking" dropdown
    When  select "new-checking"
    When user is on New Checking page
    Then user should be able to see Account Name
    And  user should be able to input alphanumeric and special character

  Scenario: Initial Deposit Amount element verification
    Given user clicks on "checking" dropdown
    When  select "new-checking"
    When user is on New Checking page
    Then user should be able to see line Initial Deposit Amount
    And  user should be able to input $250 to be deposited

  Scenario: Create New Account verification
    Given user clicks on "checking" dropdown
    When  select "new-checking"
    Then  user select Standard checking
    And  user select Individual
    When user enter TestName on the Account Name field
    And  user should be able to input $250 to be deposited
    Then user clicks on Submit button
    And verify user is redirected to the View Checking page

























