!-- Author e076177
Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded Corporate General purpose single wallet and use device for transaction

Scenario: Verify system allows onboarding for new prepaid customer through fileUpload if file already exists - Corporate Credit Card single wallet using application upload funcationality
Meta:
@CR 
@TCName TC_Application_Upload_Credit
@sheetName Prepaid_Application_Upload
@FileUpload

Given login to portal as existing bank as a Customeruser
When user creates Application Upload Credit batch file and uploads it on server for Corporate for credit
When user verifies the credit application device for fileUpload
When user approves the credit application device for fileUpload
When user processes close batch for new Application for fileUpload
When user processes deviceGeneration batch for new Application for fileUpload
When user searches for created application for fileUpload
When credit processes pre-production batch using new Application for fileUpload in Bulk
When All processes credit device production batch for fileUpload in Bulk
!-- When All processes credit device production batch
When For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal