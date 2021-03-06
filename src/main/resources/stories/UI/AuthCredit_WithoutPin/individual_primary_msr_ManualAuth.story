Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on retail credit card.

Meta:
@CreditRegression
@CreditWithOutPin
@StoryName credit_msr_retail			 
Scenario:1.1 creation of mastercard_individual_primary_msr Card credit device
Meta:
@TestId TC550110
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user sign out from customer portal

Scenario:1.2 emv corporate travel prepaid card authorization
Meta:
@TestId TC408235
Given user is logged in institution
And a new device was created
When user raises an authorization request
Then status of request is "approved"