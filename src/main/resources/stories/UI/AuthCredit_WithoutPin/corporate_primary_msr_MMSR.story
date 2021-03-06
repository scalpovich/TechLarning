Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@CreditWithOutPin
@StoryName credit_msr_retail				 
Scenario:1.1 creation of mastercard_corporate_primary_msr Card credit device
Meta:
@TestId TC565834
Given setting json values in excel for Credit
Given user is logged in institution
When for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Corporate Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Corporate and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:1.2 Perform MMSR-CORPORATE Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Money Send Person To Person authorization and verify 000-Successful status
And user sign out from customer portal