prepaid Issuer scripting application block/unblock

Narrative:
In order to check issuer scripting on application block/unblock
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card 
when application is in block or unblock mode

Meta:
@StoryName d_emv_issuer_scripting_app_block_unblock

Scenario: Set up program for debit emv corporate debit card
Given user is logged in institution
When User fills Dedupe Plan
And User fills MCC Rules for debit product
And User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
And User fills Device Plan for "debit" "emv" card for issuer scripting
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
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
Then assert Pending [2] status of Last Executed Script Status in Device Details Screen
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
Then assert Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal