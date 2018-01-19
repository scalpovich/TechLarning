!-- author: e076177
Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
CreditRegression
@StoryName S190639					 
Scenario:1 UI verification - Customer Portal - User is able to add Approval Score,Risk analysis for Credit Device SetUp and creates a Credit Device Using New Application
Meta:
@UserAddsApprovalScore
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And User fills Device Plan for credit product
And User fills Billing Cycle
And User fills Payment Priority
And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product
And User fills MCC Rules for credit product
And User fills Program section for credit product
And user navigates to Approval Score Page and add a approvalScore
And User adds a Risk Analysis Rule Plan by entering valid values
When User fills Device Range section for credit product
Then credit device is created
When credit processes pre-production batch using new Application
When processes credit device production batch
