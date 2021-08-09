
Feature: Register with unique and valid credentials.
  Background:
    Given the user is on the signup page
    @newusercreate
    Scenario: user can register with unique email
      When user inputs "name" into the name input
      And a valid email "myemail@email.com" that will be randomly changed
      And password "1234D" into the approprate inputs
      And cllicks Sign up
      Then a new user should be created
@checkuniqness
Scenario: user cant register with an already existing email
  When User enters already existing email, despide of other fields
  Then he should not be able to sign up and an error message should display.