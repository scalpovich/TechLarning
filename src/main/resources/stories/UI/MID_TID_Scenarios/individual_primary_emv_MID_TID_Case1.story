Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on Retails credit card.

Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail
@Individual
@Primary	 
Scenario:creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Create MID_TID Blocking Rule
Given user is logged in institution
When user creates MID TID Blocking for combination 1
Then user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When User set MID_TID flag true and MID_TID Combination 1
And perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 131-MID-TID Block status
Then assert Decline response with 80049 AuthDecline Code and MID-TID Blocked as description
And user sign out from customer portal