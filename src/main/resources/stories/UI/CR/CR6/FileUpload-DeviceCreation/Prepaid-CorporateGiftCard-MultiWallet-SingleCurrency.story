Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded corporate gift multiwallet single currency and use device for transaction

Scenario: Verify system allows onboarding for new prepaid customer corporate gift multiwallet single currency using application upload funcationality
Meta:
@CR
@Scenario1_corporate_gift_multiwallet_single_currency
@TCName TC_Application_Upload_Prepaid
@sheetName Prepaid_Application_Upload
@FileUpload

Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Corporate Gift Card for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user adds loyaltyPlan
When user adds promotionPlan
When user maps promotionPlan with loyaltyPlan
When user creates a Multi wallet Program for Mastercard for product Prepaid for program Corporate Gift Card
Then Program should get created
When user creates a Device Range for product Prepaid
When user creates Application Upload Prepaid batch file and uploads it on server for Corporate
When processes prepaid pre-production batch
When processes prepaid device production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal
