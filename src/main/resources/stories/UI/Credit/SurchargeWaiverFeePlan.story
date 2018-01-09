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
When User Adds Surcharge Waiver Fee Plan by entering valid values
And User Adds Surcharge Waiver Detail Fee Plan by entering valid values
Then user searches the added Surcharge Waiver Detail Fee Plan based on filter Values
And user verifies edit operation of added Surcharge Waiver Detail Fee Plan
And user verifies delete operation of added Surcharge Waiver Detail Fee Plan

