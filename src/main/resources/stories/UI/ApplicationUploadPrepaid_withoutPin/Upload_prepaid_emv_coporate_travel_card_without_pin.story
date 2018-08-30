prepaid emv corp travel card authorization

Narrative:
In order to check transactions on prepaid emv corp travel card
As an issuer
I want to authorize transactions for prepaid emv corp travel card

Meta:
@StoryName p_emv_corp_travel

Scenario: Set up prepaid emv corporate travel card uisng applicationUpload
Meta:
@TestId TC398452
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card [2] User fills without pin Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Corporate Travel Card - Single Currency [5]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Corporate Travel Card - Single Currency [5] section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
And prepaid processes pre-production batch using new Application for fileUpload in Bulk
And All processes prepaid device production batch for fileUpload in Bulk
And For fileUpload when user search for new application on search screen for prepaid and validates the status as NORMAL
Then user logouts from customer portal