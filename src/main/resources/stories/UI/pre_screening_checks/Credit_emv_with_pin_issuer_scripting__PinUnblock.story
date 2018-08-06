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
And User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
When User fills Device Plan for "credit" "emv" card for issuer scripting
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
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
And embossing file batch was generated in correct format
And user set invalid pin
Then user sign out from customer portal


Scenario: Perform EMV_PURCHASE Authorization transaction with invalid pin
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 117-Incorrect PIN status
And assert Decline response with 46051 AuthDecline Code and Incorrect Pin. as description
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction for pin retry limit check
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 106-Allowable Pin tries exceeded status
And assert Decline response with 46053 AuthDecline Code and Pin retry limit exceeded. as description
Then device has "normal" status
When user reset pin retry counter Reset Pin Retry Counter [109]
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And PIN is retrieved successfully with data from Pin Offset File

Scenario: Perform EMV_PURCHASE Authorization transaction with valid pin
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Verify Last executed script status for Application block
When user is logged in institution
Then assert Pending [2] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE_ISSUER_SCRIPTING_RES Transaction
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Verify Last executed script status for Application unblock
When user is logged in institution
Then assert Success [0] status of Last Executed Script Status in Device Details Screen
And user sign out from customer portal
And FINSim simulator is closed