Feature: Searching

  @AUTOMATE @Automated @automation @Sprint32GoogleSearchFeature
  Scenario Outline: GOOGLE STUFF
    Given a Web Browser is on the Google page
    When The seach phrase "<phrase>" Enter
    Then  "<phrase>" shown. and The relatedd   results include "<related>".
    Examples: animals
      | phrase   | related       |
      | panda    | Panda Express |
      | elephant | elephant Man  |