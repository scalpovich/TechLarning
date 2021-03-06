Narrative:
In order to verify CVC3 on NFC MSR transaction
As a user
I want to authorize transaction for credit NFC MSR

Meta:
@StoryName credit_emv_retail

Scenario:1 creation of mastercard_individual_primary_nfc_msr Card credit device
Given setting json values in excel for Credit
And user is logged in institution
When for NFC Device - Mag Stripe User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:2 creation of mastercard_individual_primary_nfc_msr Card credit device step 2
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and NFC Device - Mag Stripe
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
And User search for new device on search screen for credit and validates the status as NORMAL
Then user sign out from customer portal

Scenario:3 Perform MSR_NFC_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an MSR_NFC_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal