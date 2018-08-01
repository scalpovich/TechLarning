!-- Author e076177
Narrative:
As a(n)  Customer portal user 
I want to onboard credit device using application upload 

Meta:
@StoryName credit_emv_retail
@FileUpload
Scenario: creation of MC_Corporate_primary_NFC_msr credit device using applicationUpload functionality
Given setting json values in excel for Credit
When user is logged in institution
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for NFC Device - Mag Stripe Paypass User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section without dedupe for credit product for Mastercard
When for Primary Device and New Client user fills Device Range section for credit product
When user creates Application Upload Credit batch file and upload it on server for Corporate for credit
When user verifies the credit application device for fileUpload
When user approves the credit application device for fileUpload
When user processes close batch for new Application for FileUpload
When user processes deviceGeneration batch for new Application for FileUpload
When user searches for created application for fileUpload
When credit processes pre-production batch using new Application for fileUpload in Bulk
When All processes credit device production batch for fileUpload in Bulk
When All processes credit pin production batch for fileUpload in Bulk
When For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal