!-- Author e076177
Narrative:
As a(n)  Customer portal user 
I want to onborad prepaid customer using application upload 
So that Prepaid customer can get onboarded Corporate General purpose single wallet and use device for transaction

Scenario: Verify system allows onboarding for new prepaid customer through fileUpload if file already exists - Corporate Credit Card single wallet using application upload funcationality
Meta:
@CR 
@StoryName credit_emv_corp
@FileUpload

Given user is logged in institution
When user creates Application Upload Credit batch file and upload it on server for Corporate for credit
And user verifies the credit application device for fileUpload
And user approves the credit application device for fileUpload
And user processes close batch for new Application for FileUpload
And user processes deviceGeneration batch for new Application for FileUpload
And user searches for created application for fileUpload
And credit processes pre-production batch using new Application for fileUpload in Bulk
And All processes credit device production batch for fileUpload in Bulk
And For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal