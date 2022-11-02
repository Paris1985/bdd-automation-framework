Feature: Searching sets, textbooks and questions

  As a user
  I want to search sets, textbooks or questions
  So I can select a set, textbook or question I am interested to

  Scenario: Successful search

    Given I have a search criteria "Selenium"
    When I submit my search
    Then I should be able to see the following study sets:
      | Created By       | Title    |
      | crivers90        | Selenium |
      | jessicasedotto   | Selenium |
      | Ashleigh_Gurtler | Selenium |
    And the following users:
      | selenium  |
      | selenium4 |
    And the following number of questions:
      | chemistry | 2 |
    And the following classes:
      | class name | number of study set | number of members |
      | Selenium   | 1                   | 2                 |
      | Selenium   | 1                   | 1                 |

  Scenario: Successful search filter

    Given a successful search for "Selenium"
    When I filter the search results by <study sets>
    Then I should be able to see the <8> results
