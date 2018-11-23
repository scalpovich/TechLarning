Narrative:
As a(n)  Customer portal user
I want to onboard corporate prepaid device with pin using application upload

Meta:
@StoryName p_emv_corp_general_purpose
@FileUpload
@SanityPack

Scenario: creation of MC_Corporate_primary_emv prepaid device using applicationUpload functionality
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card [2] User fills Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Corporate General Purpose Card [8]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Corporate General Purpose Card [8] section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And user maps new program with the client code for prepaid
And user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
And processes prepaid pre-production batch
And processes prepaid device production batch
And processes prepaid pin production batch
Then For fileUpload when user search for new application on search screen for prepaid and validates the status as NORMAL
And user logouts from customer portal