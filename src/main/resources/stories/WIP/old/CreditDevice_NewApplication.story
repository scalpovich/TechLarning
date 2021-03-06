!-- author: e076177
Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
CreditRegression
@StoryName credit_emv_corp					 
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
!-- And user navigates to Approval Score Page and add a approvalScore
!-- And User adds a Risk Analysis Rule Plan by entering valid values
When User fills Device Range section for credit product
Then credit device is created
When user verify the credit application device
When user approve the credit application device
When user process close batch for new Application
When user process deviceGeneration batch for new Application
When credit processes pre-production batch using new Application
When credit processes deviceproduction batch using new Application
When new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL
