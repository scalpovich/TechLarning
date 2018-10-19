Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to not payment for one bill cycle and verify late payment and interest is applied in in next billing

Meta:
@CreditRegression
@StoryName credit_emv_retail_billing_with_late_payment
@Individual
@Primary	 

Scenario:1.1 creation of mastercard_individual_primary_emv Card credit device
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
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario:1.3 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
When user verifies available balance after transaction
Then verify fixed transaction fee applied on purchase transaction
And device has "normal" status
When user verifies available Card limit for card after transaction
Then user sign out from customer portal

Scenario:1.4 Run Pre-clearing and EOD-Credit for clearing TXN
Given user is logged in institution
When user wait for seven minutes to perform certain activity
And user sign out from customer portal
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user sign out from customer portal

Scenario:1.5 Bump next month and Login & Logout to wait for date to be updated for 1st billing cycle
Meta:
@TestId 
Given update institution date to first of next month
When user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.6 Process Batches for billing and validated values on helpdesk and 1st statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user processes Billing Process - Credit system internal batch for Credit
And user run Statement Extract system internal batch
And device has "normal" status
And user notes down required values from helpdesk for credit
And verify statement file is successfully downloaded
Then validate the statement with parameters:
|parameters|
|Credit Card Number|
|Statement Date|
|Payment Due Date|
|Total Payment Due|
|Minimum Payment Due|
|Account Number|
|Credit Limit|
|Available Credit Limit|
|Closing Balance|
And user verify Billed amount for Purchase category
And user sign out from customer portal

Scenario:1.6.1 Bump 21st of month to charge late payment fee for 2nd Billing cycle
Meta:
@TestId 
Given update institution date to 21 days
When user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
When user is logged in institution
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Fee category
And user sign out from customer portal

Scenario:1.7 Bump next month and Login & Logout to wait for date to be updated for 2nd billing cycle
Meta:
@TestId 
Given update institution date to first of next month
When user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.8 Process Batches for billing to next cycle and validated values on helpdesk and 2nd statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
When user verify Delinquency value for Status category is 1ST UNPAID
And user verify Billed amount for Fee category
And user verify Billed amount for Interest category
And user verify Amount amount for Unpaid1 category
And user run Statement Extract system internal batch
And device has "normal" status
And user notes down required values from helpdesk for credit
And verify statement file is successfully downloaded
Then validate the statement with parameters:
|parameters|
|Credit Card Number|
|Statement Date|
|Payment Due Date|
|Total Payment Due|
|Minimum Payment Due|
|Account Number|
|Credit Limit|
|Available Credit Limit|
|Closing Balance|
And user sign out from customer portal

Scenario:1.9 Bump 21st of month to charge late payment fee for 3rd Billing cycle
Meta:
@TestId 
Given update institution date to 21 days
When user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
When user is logged in institution
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Fee category
And user sign out from customer portal

Scenario:2.0 Process Batches for billing to next cycle and validated values on helpdesk and 3rd statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
When user verify Delinquency value for Status category is 2ND UNPAID
And device has "normal" status
And user notes down required values from helpdesk for credit
And user run Statement Extract system internal batch
And verify statement file is successfully downloaded
And user verify Billed amount for Interest category
And user verify Amount amount for Unpaid2 category
Then validate the statement with parameters:
|parameters|
|Credit Card Number|
|Statement Date|
|Payment Due Date|
|Total Payment Due|
|Minimum Payment Due|
|Account Number|
|Credit Limit|
|Available Credit Limit|
|Closing Balance|
And user sign out from customer portal

Scenario:2.1 Bump next day to make MAD payment
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.2 Verify User is able to make MAD Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes MAD bill payment through cash
When user processes EOD-Credit system internal batch for Credit
When user check balance details through helpdesk after payment
Then user compare balance details after MAD payment
When user verify Delinquency value for Status category is 1ST UNPAID
And user sign out from customer portal

Scenario:2.3 Bump next day to make remaining payment
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.4 Verify User is able to remaining make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes remaining bill payment through cash
When user processes EOD-Credit system internal batch for Credit
When user verify Delinquency value for Status category is NORMAL
And user sign out from customer portal

Scenario:2.5 Bump next month ,Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.6 Process Batches after paying full payment bill and verify payments
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And device has "normal" status
And user notes down required values from helpdesk for credit
When user check balance details through helpdesk after billing
Then user compare balance details after billing
When user run Statement Extract system internal batch
And verify statement file is successfully downloaded
Then validate the statement with parameters:
|parameters|
|Credit Card Number|
|Statement Date|
|Payment Due Date|
|Total Payment Due|
|Minimum Payment Due|
|Account Number|
|Credit Limit|
|Available Credit Limit|
|Closing Balance|
And user sign out from customer portal