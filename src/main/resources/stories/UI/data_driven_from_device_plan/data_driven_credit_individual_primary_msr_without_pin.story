peform credit authorization on msr without pin card
Narrative:
In order to verify credit authorization on msr without pin card
As a user 
I want to peform credit authorization on msr without pin card

Meta:
@StoryName credit_emv_retail			 
Scenario:creation of mastercard_individual_primary_msr Card credit device
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal



