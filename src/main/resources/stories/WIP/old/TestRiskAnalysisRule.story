!-- author: e076177
Narrative:
In order to add and verify Surcharge Waiver Fee Plan under customer portal cardmanagement tab
As a user
I want to assert pages
Meta:
@CreditRegression
@StoryName CreditScenarios
Scenario:1 UI verification - Customer Portal - Valid SurchargeWailverPlan, card management tab
@ValidScenario
Given user is logged in institution
When User navigates to Risk Analysis Rule Page and adds a valid Plan by entering valid values
Then user search the record added based on filter Values
And user verifies delete operation

