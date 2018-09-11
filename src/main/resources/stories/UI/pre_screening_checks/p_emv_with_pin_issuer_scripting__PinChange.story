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
Given user is logged in institution
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
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Credit Corporate- Pin Change Transaction
Given connection to MDFS is established
When user performs an optimized MDFS_EMV_PIN_CHANGE MDFS transaction
Then MDFS test results are verified
And MDFS simulator is closed
When user is logged in institution
Then search Pin Change authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Verify Last executed script status for Application block
When user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE_ISSUER_SCRIPTING_RES Transaction
Given connection to MAS is established
When PIN is created for Pin Change First Transaction
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed

Scenario: Verify Last executed script status for Application unblock
When user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal