!-- author: e076177
Narrative:
In order to add and verify Surcharge Waiver Fee Plan under customer portal cardmanagement tab
As a user
I want to assert pages
Meta:
@AddSurchargeWaiverFeePlan
@StoryName CreditScenarios
Scenario:1 UI verification - Customer Portal - Valid SurchargeWailverPlan, card management tab
@ValidScenario
Given user is logged in institution
Then User navigates to Add Surcharge Waiver Fee Plan Page and adds a valid Fee Plan by entering valid values
And User navigates to Add Surcharge Waiver Detail Fee Plan Page and adds a valid plan by entering valid values


