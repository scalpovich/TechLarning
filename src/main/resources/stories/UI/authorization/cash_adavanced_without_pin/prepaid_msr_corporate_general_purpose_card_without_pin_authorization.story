prepaid msr corp general purpose card authorization

Narrative:
In order to check transactions on prepaid msr corp general purpose card
As an issuer
I want to authorize transactions for prepaid msr corp general purpose card

Meta:
@StoryName p_msr_corp_general_purpose
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Set up prepaid msr corp general purpose
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
When user updates cvccvv as uncheck on device plan
Then user sign out from customer portal

Scenario: prepaid msr corp general purpose card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then user sign out from customer portal
Then user is logged in institution
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal


Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS test results are verified

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Clearing: Load auth file in MCPS and create NOT file of IPM extension
Meta:
@TestId 
Given connection to MCPS is established
When Auth file is generated
When Auth file is loaded into MCPS and processed
Then NOT file is successfully generated
When MCPS simulator is closed

Scenario: Upload ipm file from customer portal and process it
Meta:
@TestId 
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then user sign out from customer portal

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId 
Given user is logged in institution
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"
Then user sign out from customer portal

