!-- author: e076177
Narrative:
In order to add and Verify Late Payment Fee Plan under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
CreditLatePaymentFeePlan
@StoryName CreditScenarios					 
Scenario:1  Customer Portal-Adding a Late Payment Fee Plan
Given user is logged in institution
When user navigates to Late Payment Fee Plan and adds a new Late Payment Fee Plan
Then user search the record added based on filter Values
And user verifies edit operation
And user verifies delete operation
