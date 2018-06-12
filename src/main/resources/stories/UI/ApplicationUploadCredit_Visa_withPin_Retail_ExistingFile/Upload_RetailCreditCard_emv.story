!-- Author e076177
Narrative:
As a(n)  Customer portal user 
I want to onboard credit device using application upload 

Meta:
@StoryName credit_emv_retail
@FileUpload
Scenario: creation of visa_Individual_primary_emv credit device using applicationUpload functionality
When user is logged in institution
When user creates Application Upload Credit batch file and upload it on server for Individual for credit
When user verifies the credit application device for fileUpload
When user approves the credit application device for fileUpload
When user processes close batch for new Application for fileUpload
When user processes deviceGeneration batch for new Application for fileUpload
When user searches for created application for fileUpload
When credit processes pre-production batch using new Application for fileUpload in Bulk
When All processes credit device production batch for fileUpload in Bulk
When All processes credit pin production batch for fileUpload in Bulk
When For fileUpload when user search for new application on search screen for credit and validates the status as NORMAL
Then user logouts from customer portal