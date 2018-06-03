!-- Author e076177
Narrative:
As a(n)  Customer portal user 
I want to onborad credit customer using application upload 
So that credit customer can get onboarded Corporate credit Card single wallet and use device for transaction

Scenario: Verify system allows onboarding for new credit customer - Retail credit Card single wallet using application upload funcationality
Meta:
@CR
@Scenario1_Retail_credit_Card_Single_wallet 
@StoryName credit_emv_retail
@FileUpload

Given user is logged in institution
When User fills Statement Message Plan for credit product
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
When User fills Device Range section for credit product
When user creates Application Upload Credit batch file and upload it on server for Corporate for credit
When user verifies the credit application device for fileUpload
When user approves the credit application device for fileUpload
When user processes close batch for new Application for fileUpload
When user processes deviceGeneration batch for new Application for fileUpload
When user searches for created application for fileUpload
When credit processes pre-production batch using new Application for fileUpload in Bulk
When All processes credit device production batch for fileUpload in Bulk
When For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal