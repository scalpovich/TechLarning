prepaid emv corporate giftcard card

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv corporate giftcard card for client

Meta:
@StoryName p_emv_corp_gift
@oldReferenceSheet_S203707
@CRCardsATC

Scenario: Set up prepaid emv corporate giftcard card
Meta:
@TestId 
Given user is logged in institution
When device range for program with device plan for "prepaid" "emv" card
And user creates new device of prepaid type for new client
And device has "normal" status
Then user sign out from customer portal

Scenario: prepaid emv corporate giftcard card device production
Meta:
@TestId TC408068
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction with 50000 amount
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal


Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction 1
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user notes down ATC counter on device usage screen
Then user sign out from customer portal


Scenario: Perform EMV_PURCHASE Authorization transaction 2
Meta:
@TestId 
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction 3
Meta:
@TestId 
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction 3
Meta:
@TestId 
Given perform an EMV_PURCHASE MAS transaction on the same card
When MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify ATC counter getting updated at device usage screen
And user sign out from customer portal
Then MAS simulator is closed
