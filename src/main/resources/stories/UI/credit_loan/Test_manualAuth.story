Narrative:
In order to validate billing with statemnt create device with billing cycle 1 perform authorization with clearing along with billing batches  
As a user
I want to assert unbilled and billed amount on helpdesk and validate statement generated

Meta:
@CreditRegression
@StoryName credit_emv_retail_loan
@Individual
@Primary	 
Scenario:1.0 creation of mastercard_individual_primary_emv Card credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And user creates loan plan for credit
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:1.2 creation of mastercard_individual_primary_emv Card credit device step 2
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then user sign out from customer portal

Scenario:1.3 Retail Credit card authorization and Pre-clearing & EOD-Credit and update institution date to next day
Given user is logged in institution
When user raises an authorization request
Then status of request is "approved"
Then user sign out from customer portal