@signin
Feature: User can log in with valid credentials.
  Background:
    Given the user is on the sign in page
    Scenario: User should be able to log in
      When user enters "myemail@email" as an email, "Hello12345" as a password
      And clicks on the sign in button
      Then the user should be logged in