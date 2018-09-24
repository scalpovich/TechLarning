!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to onboard credit device using application upload 

Meta:
@StoryName prepaid_emv
@FileUpload
Scenario: To verify user is not able to process application file upload with missing Business Mandatory fields for credit
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product without dedupe for Mastercard
And User fills Business Mandatory Fields Screen for credit product
And for Primary Device and New Client user fills Device Range section for credit product
And user creates Application Upload Credit batch file with duplicate data and upload it on server for Individual for credit
And Application Upload rejected due to missing Business Mandatory feild
Then user logouts from customer portal

Scenario: To verify user is not able to process application file upload with missing Business Mandatory fields for prepaid
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card [2] User fills without pin Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Retail Travel Card - Single Currency [1]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Retail Travel Card - Single Currency [1] section for prepaid product without dedupe for Mastercard
And User fills Business Mandatory Fields Screen for Prepaid product
And for Primary Device and New Client user fills Device Range section for prepaid product
And user creates Application Upload Prepaid batch file with duplicate data and upload it on server for Individual for prepaid
And Application Upload rejected due to missing Business Mandatory feild
Then user logouts from customer portal