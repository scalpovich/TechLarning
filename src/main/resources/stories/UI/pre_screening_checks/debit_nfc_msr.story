Debit NFC MSR Transactiom

Narrative:
In order to verify CVC3 on NFC MSR transaction
As a user
I want to authorize transaction for Debit NFC MSR

Meta:
@StoryName d_emv_retail

Scenario: Setup - debit emv retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "NFC Device - Mag Stripe" card
Then user sign out from customer portal

Scenario: Device production - debit emv retail debit card
Given user is logged in institution
When user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
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