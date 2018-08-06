prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general
@oldReferenceSheet_S203707
@CRCardsATC

Scenario: Set up prepaid emv retail general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
When device range for program with device plan for "prepaid" "emv" card
And user creates new device of prepaid type for new client
And device has "normal" status
Then user sign out from customer portal

Scenario: prepaid emv retail general purpose card device production
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
Then user sign out from customer portal


Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction 1
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When user notes down ATC counter on device usage screen
Then user sign out from customer portal


Scenario: Perform EMV_PURCHASE Authorization transaction 2
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction 3
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When verify ATC counter getting updated at device usage screen
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction 3
Meta:
@TestId 
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Purchase authorization and verify 000-Successful status
When verify ATC counter getting updated at device usage screen
Then user sign out from customer portal
When MAS simulator is closed
