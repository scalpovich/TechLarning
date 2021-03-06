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
And device has "normal" status
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:1.2 Perform ASI_MSR Authorization transaction on Individual Primary MSR Card
Given connection to MAS is established
When perform an ASI_MSR MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal

Scenario:1.3 Perform MMSR-CORPORATE_TravelCard Authorization transaction
When perform an MMSR MAS transaction on the same card
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Money Send Person To Person authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.4 Perform MSR_REFUND Authorization transaction
When perform an MSR_REFUND MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then validate auth report
And user sign out from customer portal

Scenario:1.5 Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.6 Perform MSR_CASH_ADVANCE Authorization transaction
When perform an MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.7 Perform MSR_PURCHASE Authorization transaction
When perform an MSR_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal