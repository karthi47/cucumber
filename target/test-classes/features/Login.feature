Feature: Login Function

  Scenario: To check Add customer function by entering valid details
    Given User is on home page
    When User enter some valid details
      | karthick | durai |
    And User enters remaining details
      | email    | k@gmail.com |
      | message  | hai         |
      | telepone |  9678954564 |
    Then Verify wheather able to login
