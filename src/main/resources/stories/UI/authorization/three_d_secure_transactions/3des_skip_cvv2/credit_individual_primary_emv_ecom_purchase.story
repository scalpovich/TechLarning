Narrative:
In order to validate billing with statemnt create device with billing cycle 1 perform authorization with clearing along with billing batches  
As a user
I want to assert unbilled and billed amount on helpdesk and validate statement generated

Meta:
@CreditRegression
@StoryName credit_emv_retail_billing
@Individual
@Primary	 

Scenario:1.0 creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
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
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal

Scenario:1.3 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:  Skip CVV2/CVC2 Validation in 3DES Params
Given user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Credit and interchange Mastercard
Then user sign out from customer portal

Scenario: perform 3D_SECURE_NO_CVV2 authorization on corporate msr card
Given connection to MAS is established
When perform an 3D_SECURE_NO_CVV2 MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:  Skip CVV2/CVC2 Validation in 3DES Params
Given user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Credit and interchange Mastercard
Then user sign out from customer portal