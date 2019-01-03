Credit pre screening

Narrative:
In order to Various auth txn on different conditions of device
As a user
I want to do below Txn on credit device
-Purchase txn when country/currency is blacklist or whitelist
-Fallback Txn
-Txn On white listed MCG
-Issuer scripting when application block and unblock

Meta:
@StoryName credit_pre_screening
Scenario:1.0 creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And User fills Device Plan for "credit" "emv" card for issuer scripting
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
And user sign out from customer portal

Scenario:1.1 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.2 Transaction - FALLBACK_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an FALLBACK_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
Then search FallBack Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.3 Add the device into stoplist
When user is logged in institution
And user stoplists a card from stoplist device screen
And user sign out from customer portal

Scenario:1.4 Transaction EMV_PURCHASE and EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application block
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
And user sign out from customer portal
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 208-LOST CARD, PICK-UP status
And user sign out from customer portal

Scenario:1.5 Withdraw the device from stoplist
Given user is logged in institution
When user withdraws a card from withdraw device screen
And user sign out from customer portal

Scenario:1.6 Transaction EMV_PURCHASE and EMV_PURCHASE_ISSUER_SCRIPTING_RES for Application unblock
When perform an EMV_PURCHASE MAS transaction on the same card
And MAS test results are verified
When user is logged in institution
Then verify Pending [2] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
When perform an EMV_PURCHASE_ISSUER_SCRIPTING_RES MAS transaction on the same card
And MAS test results are verified
When user is logged in institution
Then verify Success [0] status of Last Executed Script Status in Device Details Screen
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.7 Edit country white list plan in program
Given user is logged in institution
When User edits Program to update country whitelist plan
Then user sign out from customer portal

Scenario:1.8 Transaction
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:1.9 Perform INT_MSR_PURCHASE Authorization transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 25001 AuthDecline Code and Whitelisted Country Not Found as description
Then user sign out from customer portal

Scenario:2.0 Edit country black list plan in program
Given user is logged in institution
When User edits Program to update country blacklist plan
Then user sign out from customer portal

Scenario:2.1 Perform INT_MSR_PURCHASE Authorization transaction
When perform an INT_EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 25002 AuthDecline Code and Country is blacklisted. as description
Then user sign out from customer portal

Scenario:2.2 Edit white listed MCG plan in Wallet plan
Given user is logged in institution
When User edits Wallet Plan for White Listed MCG
Then user sign out from customer portal

Scenario:2.3 Transaction for mastercard_individual_primary_emv Card credit device
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:2.4 Perform EMV_CASH_ADVANCE Authorization transaction
When perform an EMV_CASH_ADVANCE MAS transaction on the same card
And MAS simulator is closed
And user is logged in institution
And search Cash Advance authorization and verify 100-Do Not Honour status
And assert Decline response with 20004 AuthDecline Code and Invalid wallet. as description
Then user sign out from customer portal