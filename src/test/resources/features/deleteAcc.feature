Feature: Cancel My account
  Background:
    Given the user is already logedin and on the Campaign page.
    @deleteacc
    Scenario: User should be able to delete account.
      When user is on the Edit account page.
      And navigates to the bottom
      And clicks Cancel my account button
      Then a succsess message should be displayed