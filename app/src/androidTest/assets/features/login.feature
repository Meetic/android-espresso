@login
Feature: Login feature

  Scenario Outline: Login scenario
    Given I am on the Login screen
    When I enter my credentials <login> and <password>
    And I press login button
    Then I see <result>

  Examples:
    | login | password | result |
    ||| errors |
    | user2 | password2 | snackbar error |
    | user1 | password1 | Logged screen |