Feature: As a user i should be able to add and edit a Campaign
  Background:
    Given the user is already logedin and on the Campaign page.
    @newCampaign
    Scenario Outline: User should be able to add a campaign
      When the user clicks Add New Campaign button
      Then user should be sent into a new page
      And in the name input box user can put "<Name>" of campaign
      And in the description input "<description>" of campaign
      And select the type "<type>"
      And click create campaign
      Then a new campaign should be created
      Examples:
        |Name  | description  | type      |
        | hello| World        | One Time  |
        |What  | is good earth| Repeatable|


      @editCampaign
      Scenario: Edit Campaign
        When User Selects a random Campaign
        And clicks on the edit button
        Then the edit page should appear
        And he can edit the colums with the values "Its","thesame", "One Time"
        And click the update button
        Then a succsess message should appear