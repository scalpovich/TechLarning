!-- auther: e076168
Narrative:
As a Cardhodler
I want to able to loing into customer portal 
In order to do the wallet to wallet transactions


Meta:
@StoryName c_helpdesk_wallet_transfer
@SanityCards

Scenario: To Verify functionality of wallet transfer from mastercard interchange by emv card with program Corporate Travel Card - Multi Currency
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
When User fills Marketing Message Plan for prepaid product
When User fills Prepaid Statement Plan
When User fills MCC Rules for prepaid product
When User fills Dedupe Plan
When User fills Transaction Plan for prepaid product
When User fills Transaction Limit Plan for prepaid product
When User fills Document Checklist Screen for prepaid product
When User fills Device Joining and Membership Fee Plan for prepaid product
When User fills Device Event Based Fee Plan for prepaid product
When User fills Device Plan for "prepaid" "emv" card with no pin
When fills Wallet Plan for prepaid product and program Corporate Travel Card - Multi Currency [6]
When User fills Program section for prepaid product and program Corporate Travel Card - Multi Currency [6]
When User fills Business Mandatory Fields Screen for prepaid product
When User fills Device Range section for prepaid product
When add menus to access card holder portal
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user performs adjustment transaction
Then currency setup for device
When wallet to wallet transfer selected account
