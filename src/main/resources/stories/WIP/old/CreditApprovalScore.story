!-- author: e076177
Narrative:
In order to add and Verify ApprovalScore under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
CreditRegression
@StoryName CreditScenarios					 
Scenario:1 UI verification - Customer Portal - User is able to add Approval Score for Credit Device SetUp
Meta:
@UserAddsApprovalScore
Given user is logged in institution
When user navigates to Approval Score Page and add a approvalScore
And user verifies edit and verify Approval Score
