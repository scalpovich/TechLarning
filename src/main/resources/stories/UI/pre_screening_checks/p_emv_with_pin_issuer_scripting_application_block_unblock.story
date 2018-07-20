prepaid Issuer scripting application block/unblock

Narrative:
In order to check issuer scripting on application block/unblock
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card 
when application is in block or unblock mode

Meta:
@StoryName p_emv_issuer_scripting_app_block_unblock

Scenario: Set up prepaid emv retail general purpose card
Given setting json values in excel for Prepaid
When user is logged in institution
When User fills Device Plan for "prepaid" "emv" card for issuer scripting
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
When user creates new device of prepaid type for new client
And device has "normal" status
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
!-- Then user sign out from customer portal


Scenario: prepaid emv retail general purpose card device production
!-- Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
And user activates device through helpdesk
!-- Then user sign out from customer portal

Scenario: Add the device into stoplist
!-- Given user is logged in institution
When user stoplists a card from stoplist device screen
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction EMV_PURCHASE
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
Then assert Purchase response with 70053 AuthDecline Code and Card Status is Lost with Capture Response as description
And user sign out from customer portal

