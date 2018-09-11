prepaid Issuer scripting application block/unblock

Narrative:
In order to check issuer scripting on application block/unblock
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card 
when application is in block or unblock mode

Meta:
@StoryName cr_emv_issuer_scripting_app_block_unblock

Scenario:creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
When User fills Device Plan for "credit" "emv" card for issuer scripting
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

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
And perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And MAS simulator is closed

Scenario: Verify Last executed script status for Application unblock
When user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal