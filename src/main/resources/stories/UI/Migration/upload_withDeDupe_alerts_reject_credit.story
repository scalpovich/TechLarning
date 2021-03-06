!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to onboard application upload with duplicate data then it should caught in Dedupe/SDN 

Meta:
@StoryName greater_limit_credit_emv_retail
@FileUpload
Scenario: To verify that  application is caught in Dedupe/SDN  plan when application file uploaded via 'Application Bulk Upload' with dedupe/SDN plan is configured. Reject the application on Dedupe/SDN screen
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And user creates Application Upload Credit batch file with duplicate data and upload it on server for Individual for credit
And Application Upload rejected due to missing Business Mandatory field
And user reject duplicate application for upload caught in dedupe / SDN
And verify duplicate applications in application reject report for upload
Then user logouts from customer portal
