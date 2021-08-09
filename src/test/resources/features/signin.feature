@wip
Feature: User can log in with valid credentials.
  Background:
    Given the user is on the sign in page
    Scenario: User should be able to log in
      When user enters "dardan.gjoka@gmail.com" as an email
      And "dr3n4sdr3n4s" as a password
      And clicks on the sign in button
      Then the user should be logged in