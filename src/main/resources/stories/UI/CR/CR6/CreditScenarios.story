Narrative:
In order to verify that Surcharge Waiver Fee Plan under customer portal cardmanagement tab
As a user
I want to assert pages

@Meta:
ABCDE					 
Scenario: UI verification - Customer Portal - Valid SurchargeWailverPlan, card management tab
Meta:
@TestId TC379084
@TCName TC554188
@sheetName CreditScenarios
Given login to portal as existing bank as a user
Then SurchargeWaiverPlan of card management tab has proper field validation
And user signs out from customer portal

Scenario: UI verification - Customer Portal - Invalid SurchargeWailverPlan, card management tab
Meta:
@TestId TC379084
@TCName TC554188
@sheetName CreditScenarios
Given login to portal as existing bank as a user
Then SurchargeWaiverPlan of card management tab has proper field validation for Invalid scenario
And user signs out from customer portal
