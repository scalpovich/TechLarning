Debit NFC MSR Transactiom

Narrative:
In order to verify CVC3 on NFC MSR transaction
As a user
I want to authorize transaction for Debit NFC MSR

Meta:
@StoryName d_emv_retail

Scenario: Setup - debit emv retail debit card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "NFC Device - Mag Stripe" card without pin
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
Then user sign out from customer portal

Scenario: Device production - debit emv retail debit card
Given user is logged in institution
When user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: Perform MSR_NFC_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_NFC_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal