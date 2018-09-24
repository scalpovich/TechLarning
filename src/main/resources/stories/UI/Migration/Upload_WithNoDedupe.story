!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to onboard credit device using application upload 

Meta:
@StoryName credit_emv
@FileUpload
Scenario: To verify user is able to board a duplicate application via application upload when dedupe plan is not configured. File upload for credit
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product without dedupe for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And user creates Application Upload Credit batch file with duplicate data and upload it on server for Individual for credit
And user verifies the credit application device for fileUpload
And user approves the credit application device for fileUpload
And user processes close batch for new Application for FileUpload
And user processes deviceGeneration batch for new Application for FileUpload
And user searches for created application for fileUpload
And credit processes pre-production batch using new Application for fileUpload in Bulk
And All processes credit device production batch for fileUpload in Bulk
And For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal

Scenario: To verify user is able to board a duplicate application via application upload when dedupe plan is not configured. File upload for prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card [2] User fills without pin Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Retail Travel Card - Single Currency [1]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Retail Travel Card - Single Currency [1] section for prepaid product without dedupe for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And user creates Application Upload Prepaid batch file with duplicate data and upload it on server for Individual for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And processes prepaid pin production batch
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal