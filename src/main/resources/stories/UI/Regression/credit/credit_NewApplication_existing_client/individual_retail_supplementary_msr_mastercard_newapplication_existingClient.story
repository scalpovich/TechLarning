!-- author: e076177
Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName cr_MSR_INRESUNAEC_MC					 
Scenario: Uuser creates a Credit Device Using New Application screen with Existing client of msr type for visa
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel
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
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User fills Program section for credit product and program Retail Credit Card
When User fills Device Range section for credit product
Then credit device is created
When user verifies the credit application device
When user approves the credit application device
When user processes close batch for new Application for FileUpload
When user processes deviceGeneration batch for new Application for FileUpload
When user searches for created application
When credit processes pre-production batch using new Application
When credit processes deviceproduction batch using new Application
Then User search for new application on search screen for credit and validates the status as NORMAL
