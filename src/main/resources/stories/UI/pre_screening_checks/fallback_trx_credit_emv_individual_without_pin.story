fallback trx on credit emv card individual primary card with no pin

Narrative:
In order to make fallback transactions on credit emv card individual primary card
As an issuer
I want to authorize  fallback transactions for credit emv card individual primary card


Meta:
@StoryName credit_emv_retail			 
@FallbackTrx
Scenario:creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
Given user is logged in institution
When for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - FALLBACK_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an FALLBACK_PURCHASE MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search FallBack Transaction authorization and verify 000-Successful status
And user sign out from customer portal