Feature: Checks the basic funtionality of all the major functions.
  @health
  Scenario: User should navigate to all the pages and get status code 200
    When user goes to main page
    And the user is on the sign in page
    And the user is on the signup page.