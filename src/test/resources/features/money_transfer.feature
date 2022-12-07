Feature: Transferring money between accounts
  In order to manage my money more efficiently
  As a bank client
  I want to transfer funds between my accounts whenever I need to

  Scenario: Transferring money to a savings account
    Given my Current account has a balance of 1000.00
    And my Savings account has a balance of 2000.00
    When I transfer 500.00 from my Current account to my Savings account
    Then I should have 500.00 in my Current account
    And I should have 2500.00 in my Savings account

  Scenario: Transferring with insufficient funds
    Given my Current account has a balance of 1000.00
    And my Savings account has a balance of 2000.00
    When I transfer 1500.00 from my Current account to my Savings account
    Then I should receive an 'insufficient funds' error
    Then I should have 1000.00 in my Current account
    And I should have 2000.00 in my Savings account

    ##scenarios grouped into single scenario
    ## uses of place holder variables
  Scenario Outline: Earning interest
    Given I have an account of type <account-type> with a balance of <initial-balance>
    When the monthly interest is calculated
    Then I should have earned at an annual interest rate of <interest-rate>
    And I should have a new balance of <new-balance>
    Examples:
      | initial-balance | account-type | interest-rate | new-balance
      | 10000           | current      | 1             | 10008.33    |
      | 10000           | savings      | 3             | 10025       |
      | 10000           | supersaver   | 5             | 10041.67    |
  #using tabular notatio
  Scenario: Transferring money between accounts within the bank
    Given I have the following accounts:
      | account | balance | current |
      | 1000    | savings | 2000    |

    When I transfer 500.00 from current to savings
    Then my accounts should look like this:
      | account | balance | current |
      | 500     | savings | 2500    |