!-- Author e076177
Narrative:
As a(n)  Customer portal user 
I want to onborad credit customer using application upload 
So that credit customer can get onboarded Corporate credit Card single wallet and use device for transaction

Scenario: Verify system allows onboarding for new credit customer - Retail credit Card single wallet using application upload funcationality
Meta:
@CR
@Scenario1_Retail_credit_Card_Single_wallet 
@TCName TC_Application_Upload_Credit
@sheetName Prepaid_Application_Upload
@FileUpload

Given login to portal as existing bank as a Customeruser
When user creates Device BIN for Mastercard for product credit for BinType as Single Message Type
When user creates a Open loop wallet plan of default type for program Retail Credit Card for credit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and credit card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product credit for program Retail Credit Card
Then Program should get created
When user creates a Device Range for product credit
When user creates Application Upload Credit batch file and uploads it on server for Individual for credit
When user processes close batch for new Application for FileUpload
When user processes deviceGeneration batch for new Application for FileUpload
When processes credit pre-production batch
When All processes credit device production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal