!-- Author e084017
Narrative:
As a(n)  Customer portal user 
I want to accommodate new field (Business Mandatory) as ""Client Customer ID"" in application upload credit 

Meta:
@StoryName greater_limit_credit_emv_retail
Scenario:  To verify that there is provision to accommodate new field (Business Mandatory) as ""Client Customer ID"" in application upload credit
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And User fills CLIENT_CUSTOMER_ID as Business Mandatory Field for credit product
And for Primary Device and New Client user fills Device Range section for credit product
And user creates Application Upload Credit batch file and upload it on server for Individual for credit
And user verifies the credit application device for fileUpload
And user approves the credit application device for fileUpload
And user processes close batch for new Application for FileUpload
And user processes deviceGeneration batch for new Application for FileUpload
And user searches for created application for fileUpload
And credit processes pre-production batch using new Application for fileUpload in Bulk
And All processes credit device production batch for fileUpload in Bulk
And All processes credit pin production batch for fileUpload in Bulk
And For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal
