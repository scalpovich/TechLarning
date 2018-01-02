!-- author: e076177
Narrative:
In order to add and Verify ApprovalScore under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
CreditRegression
@StoryName S190639					 
Scenario:1 UI verification - Customer Portal - User is able to add Approval Score for Credit Device SetUp
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
When user navigates to Approval Score Page and add a approvalScore
Then user search the record added based on filter Values
And user verifies edit operation
And user verifies delete operation
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
Then credit device plan and program are made available for Device Creation

