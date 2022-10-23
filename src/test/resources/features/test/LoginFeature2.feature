Feature: Login feature
@Smoke
  Scenario: Successful login
    Given I am on the login page
    When I try to login with valid credentials
    Then I should be able to login successfully