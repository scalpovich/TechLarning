Narrative:
As a Cardhodler
I want to login customer portal 
In order to do the wallet to wallet fund transfer


Meta:
@StoryName c_helpdesk_wallet_transfer
@csr_wtow_fundTransfer

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Corporate General Purpose Card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Prepaid Statement Plan
And for EMV Card [2] User fills Device Plan for prepaid product for Mastercard
And user fills Merchant Category Group
And User fills Wallet Fee Plan for prepaid product
And create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Open Loop"
And create wallet Plan for "prepaid" product and program "Corporate General Purpose Card [8]" with usage "Closed Loop"
And fills Program section for prepaid product and program Corporate General Purpose Card [8]
And for Primary Device and New Client user fills Device Range section for prepaid product
And prepaid device is created using new device screen for Corporate and Primary Device and New Client and EMV Card [2]
And device has "normal" status
And user get attached wallet details for device
And user assigns service code to program
And user performs adjustment transaction
And wallet to wallet transfer for general purpose account
Then search with device in transaction screen and status for wallet to wallet transfer transaction
And user sign out from customer portal