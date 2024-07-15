Feature: Calendar Test

  Scenario Outline: User creates a calendar event
    Given User is logged in with email "<email>", password "<password>" and phone number "<phoneNumber>"
    When User navigates to the specific day "<date>"
    And User creates a new event "<eventText>"
    Then The event "<eventText>" is present in the calendar
    Examples:
      | email               | password | phoneNumber | date       | eventText          |
      | testuser5@gmail.com | pass123  | 123456789231   | 2024-07-15 | Training with John |
      | testuser6@gmail.com | pass123  | 123456239231  | 2024-07-15 | Training with Mark |