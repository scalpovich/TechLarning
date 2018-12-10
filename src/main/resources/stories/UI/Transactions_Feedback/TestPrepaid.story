Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate Prepaid card and assert application block/unblock priority check.

Meta:
@StoryName PREPAID_MULTIWAL_MULTICUR_AGENT				 

Scenario:1.1 Set up prepaid emv corporate travel card
!-- Given setting json values in excel for Prepaid
!-- When user is logged in institution
!-- And User fills Device Plan for "prepaid" "emv" card for issuer scripting
!-- And User fills Wallet Plan for prepaid product
!-- And User fills Program section for prepaid product
!-- And User fills Business Mandatory Fields Screen for prepaid product
!-- And User fills Device Range section for prepaid product
!-- And user creates new device of prepaid type for new client
!-- And a new device was created
!-- And processes pre-production batch for prepaid
!-- And processes device production batch for prepaid
!-- And processes pin generation batch for prepaid
!-- And device has "NOT ACTIVATED CARD" status
!-- And user has wallet number information for prepaid device
!-- And user performs adjustment transaction
!-- And user has current wallet balance amount information for prepaid device
!-- Then user sign out from customer portal

Scenario:1.1 Set up prepaid emv corporate travel card
!-- Given setting json values in excel for Prepaid
Given user is logged in institution
When user activates device through helpdesk
And User Configure device

Scenario:1.4 Pin Generation
Given connection to FINSim is established
When PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:1.5 Transaction EMV_PURCHASE Application block
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Generate Auth File for Clearing
Meta:
@TestId 
When Auth file is generated after transaction
When MAS simulator is closed

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
@TestId TC406665
Given user is logged in institution
When User uploads the NOT file
When user processes batch for prepaid
Then in batch trace history transaction is successful

Scenario: Matching & Posting to Cardholders account
Meta:
@TestId TC406667
When in batch trace history transaction is successful
When transaction status is "Matching Pending"
When "Matching" batch for prepaid is successful
Then transaction status is "Presentment Matched with authorization"