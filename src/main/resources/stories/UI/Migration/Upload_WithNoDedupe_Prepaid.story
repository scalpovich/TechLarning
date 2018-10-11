!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to onboard prepaid device using application upload 

Meta:
@StoryName prepaid_emv
@FileUpload
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
And User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal