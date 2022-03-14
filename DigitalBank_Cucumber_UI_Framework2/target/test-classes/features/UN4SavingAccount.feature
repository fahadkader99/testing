Feature: Create new Savings Bank account nd process payment from user's preferred account

  Background:
    Given user open website
    Then  verify user is on the Login page
    When  user click on login button
    Then  verify user is navigated to Home page.


  Scenario Outline: User is able to Interact with savings tab
    When user clicks on "savings" dropdown
    Then verify "<SavingsCategories>" are available
    Examples:
      | SavingsCategories |
      | view-saving       |
      | new-saving        |

  Scenario Outline: Verify User can create New Savings account
    When user clicks on "savings" dropdown
    And  select " new-savings"
    Then user should be redirected to Create Savings page
    And user should be able to see Select Savings Account type
    Then Verify "<SavingsAccountType>" is visible
    Examples:
      | SavingsAccountType |
      | savings            |
      | Money-Market       |

  Scenario Outline: Select Account Ownership categories verification
    Given user clicks on "savings" dropdown
    When select "new-savings"
    When user is on New Savings page
    Then user should be able to see "Select Account Ownership"
    And  verify "<SelectAccountOwnership>" is visible at New Savings Page
    Examples:
      | SelectAccountOwnership |
      | Individual             |
      | Joint                  |

  Scenario: Account Name element Verification
    Given user clicks on "savings" dropdown
    When select "new-savings"
    When user is on New Savings page
    Then user should be able to see Account Name
    And user should be able to input alphanumeric and special character


  Scenario: Initial Deposit Amount element verification
    Given user clicks on "savings" dropdown
    When select "new-savings"
    When user is on New Savings page
    Then user should be able to see line Initial Deposit Amount
    And  user should be able to input $200 to be deposited

  Scenario: Create New Account Verification
    Given user clicks on "savings" dropdown
    When select "new-savings"
    When user is on New Savings page
    Then user select Savings Account Type
    And user select Individual
    Then user enter TestName on the Account Name field
    And  user should be able to input $200 to be deposited
    When user clicks on Submit button
    Then verify user is redirected to the View Savings Page
