Feature: Automate the automation page

  Scenario: Automate the Registeration page
    Given User Enter the  and Select the Gender and Hobbies
    | karthi | D     | Chennai | kit@gmail.com | 9842603597|
    When User Enter the details
    | 12345 | 12345 |
    Then click on the Summit button and check WebTable is in the url

    
