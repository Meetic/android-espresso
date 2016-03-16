@detail
Feature: Open detail screen

  Scenario: Open detail item screen
    Given I am a logged user
    When I scroll down to item 42
    And I press item 42
    Then I see item 42 detail screen
