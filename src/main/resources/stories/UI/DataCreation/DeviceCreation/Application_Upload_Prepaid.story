Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded and use device for transaction

Scenario: Verify system allows onboarding for new prepaid customer using application upload funcationality
Meta:
@TCName TC264384_Privilege validation for RuPay Settlement Bin Configurations
@sheetName ApplicationUpload
@testDataFileName 
@1111
@all
Given customerAdmin provides privilege to testUser to process batches
And login to customer portal as newuser
!-- When user creates Business Mandatory Fields from the file BusinessMandatoryFields.xlsx for Prepaid
When user creates Application Upload Prepaid batch file and uploads it on server
Then The file will process the records successfully if all the all the business mandatory field are configured in file


Scenario: Verify system allows onboarding for new prepaid customer using application upload funcationality1
Given that the Bank User has login into the customer portal 
And user has privilege on process batches to customer Portal
And user has configured business mandatory fields on the business mandatory screen
When user creates file to upload and uploads file
Then The file will Reject the record if any of business mandatory field missed in the file


Given user creates file with all business mandatory field to upload and uploads file
When user navigates to application details screen
Then user should be able to view new application details which are configured in file


Given user creates file without business mandatory field to upload and uploads file
When user navigates to application details screen
Then upload should get rejected and rejected records should show the the appropriate reason on the batch details screen 
And the application should move to Incomplete applications


Given user creates file without business mandatory field to upload and uploads file
And user navigates to application details screen
When upload get rejected and application should move to Incomplete applications
Then user should be able to complete the incomplete application
When user completes complete the incomplete application
Then user should be able to process it using Pre-production, Device production 




