Narrative:
In order to validate billing with statemnt create device with billing cycle 1 perform authorization with clearing along with billing batches  
As a user
I want to assert unbilled and billed amount on helpdesk and validate statement generated

Meta:
@StoryName credit_msr_retail_billing			 

Scenario:1.0 creation of mastercard_individual_primary_msr Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:1.2 creation of mastercard_individual_primary_msr Card credit device step 2
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: 1.3 Perform MSR_RECURRING_PUR_TXN Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_RECURRING_PUR_TXN MAS transaction
Then MAS test results are verified
And MAS simulator is closed

Scenario: 1.4 Generate Auth File for Clearing
Meta:
@TestId 
Given user is logged in institution
When search Purchase authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal

Scenario: 1.5 Perform Recurring Purchase Transactionn Reversal
Given user perform reversal transaction of type 17
When user is logged in institution
Then search Purchase Reversal authorization and verify 000-Successful status
And validate auth report
And user sign out from customer portal