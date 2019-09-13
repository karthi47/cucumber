Feature: Tariff plan

  Scenario: To Validate tariff plan is getting added for a customer
    Given User on home page
    When User enter the tariff details
      |  100 | 200 |  300 |  100 |
      |  100 | 300 |  500 |  100 |
      |  200 | 200 | 1000 |  600 |
      | 5000 | 200 |  300 | 1000 |
    And User enter the remaining tariff details
      | LocalperCharge | InternationalperCharge | SMSperCharge |
      |             10 |                     20 |            3 |
      |              9 |                     12 |            2 |
      |              4 |                     15 |            1 |
      |              5 |                     18 |            2 |
    Then Check weather tariff added successfully.
    Scenario Outline: To Validate tariff plan is getting added for a customer
    When User enter the tariff details "<MontlyRental>","<FreeLocalMinutes>","<FreeInternationalMinutes>","<FreeSMS>","<LocalperCharge>","<InternationalperCharge>","<SMSperCharge>"
    Then Check weather tariff added successfully at a time

    Examples: 
      | MontlyRental | FreeLocalMinutes | FreeInternationalMinutes | FreeSMS | LocalperCharge | InternationalperCharge | SMSperCharge |
      |           10 |               20 |                        3 |     100 |            200 |                    300 |          700 |
      |           19 |               30 |                        4 |     400 |            200 |                    400 |          600 |
      |           15 |               40 |                        5 |     500 |            200 |                    300 |          600 |
      |           14 |               50 |                        6 |     200 |            900 |                    100 |          300 |