Narrative:
In order to a validate 3 d secure Transaction on credit device
As a user
I want to perform 3 d secure Transaction without CVV2

Meta:
@CreditRegression
@StoryName credit_emv_retail_billing
@Individual
@Primary	 
Scenario:1.1 creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:1.2 creation of mastercard_individual_primary_emv Card credit device step 2
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:1.3 perform 3D_SECURE_NO_CVV2 authorization on individual primary emv credit card 
Given connection to MAS is established
When perform an 3D_SECURE_NO_CVV2 MAS transaction
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 191-CVV2/CVC2/CVD2/4CSC Verification Failure status
And assert Decline response with 46041 AuthDecline Code and CVV2 not present for E-Comm transaction. as description
And user sign out from customer portal

Scenario:1.4 Skip CVV2/CVC2 Validation in 3DES Params
Given user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Credit and interchange Mastercard as check
Then user sign out from customer portal

Scenario:1.5 perform 3D_SECURE_NO_CVV2 authorization on individual primary emv credit card 
Given perform an 3D_SECURE_NO_CVV2 MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.6 Skip CVV2/CVC2 Validation in 3DES Params
Given user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Credit and interchange Mastercard as uncheck
Then user sign out from customer portal