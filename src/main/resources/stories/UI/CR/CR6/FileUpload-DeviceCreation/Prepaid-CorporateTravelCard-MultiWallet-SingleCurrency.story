Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded Corporate travel card multiwallet multicurrency and use device for transaction

Scenario:1 Verify system allows onboarding for new prepaid customer Corporate travel card multiwallet multicurrency using application upload funcationality
Meta:
@CR
@Scenario1_Corporate_travel_card_multiwallet_multicurrency
@TCName TC_Application_Upload_Prepaid
@sheetName Prepaid_Application_Upload
@FileUpload

Given login to portal as existing bank as a Customeruser
When user creates Device BIN for Mastercard for product prepaid for BinType as Single Message Type
When user creates a Open loop wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Multi wallet Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency
Then Program should get created
When user creates a Device Range for product Prepaid
When user creates Application Upload Prepaid batch file and uploads it on server for Corporate for prepaid
When processes prepaid pre-production batch
When All processes prepaid device production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal

