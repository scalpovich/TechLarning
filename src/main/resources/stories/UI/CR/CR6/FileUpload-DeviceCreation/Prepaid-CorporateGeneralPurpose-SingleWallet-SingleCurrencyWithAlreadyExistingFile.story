Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded Corporate General purpose single wallet and use device for transaction

Scenario: Verify system allows onboarding for new prepaid customer through fileUpload if file already exists - Corporate General purpose single wallet using application upload funcationality
Meta:
@CR
@Scenario1_Corporate_General_purpose_single_wallet 
@TCName TC_Application_Upload_Prepaid
@sheetName Prepaid_Application_Upload
@FileUpload

Given login to portal as existing bank as a Customeruser
When user creates Application Upload Prepaid batch file and uploads it on server for Corporate for prepaid
When processes prepaid pre-production batch
When All processes prepaid device production batch
When User search for device on search screen for product type prepaid and validates the status as NORMAL
Then user logouts from customer portal