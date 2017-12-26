!-- author: e076177
Narrative:
In order to add and Verify CreditPlan under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
CreditRegression
@StoryName CreditScenarios					 
Scenario:1 UI verification - Customer Portal - User is able to add a Valid Credit Plan
Meta:
@UserAddsAValidCreditPlan
Given user is logged in institution
When user navigates to Credit Plan Page and add a creditPlan
Then user search the record added based on filter Values
And user verifies edit operation

