prepaid emv corporate giftcard card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv corporate giftcard card for client

Meta:
@StoryName p_emv_corp_gift

Scenario: Set up prepaid emv corporate giftcard card using applicationUpload
Meta:
@TestId 
Given setting json values in excel for Prepaid
When user is logged in institution
And for EMV Card [2] User fills without pin Device Plan for prepaid product for Mastercard
And User fills Wallet Plan for prepaid product and program Corporate Gift Card [7]
And User fills MCC Rules for prepaid product
And User Primary Device fills New Program Corporate Gift Card [7] section for prepaid product for Mastercard
And for Primary Device and New Client user fills Device Range section for prepaid product
And user creates Application Upload prepaid batch file and upload it on server for Corporate for prepaid
And prepaid processes pre-production batch using new Application for fileUpload in Bulk
And All processes prepaid device production batch for fileUpload in Bulk
And For fileUpload when user search for new application on search screen for prepaid and validates the status as NORMAL
Then user logouts from customer portal