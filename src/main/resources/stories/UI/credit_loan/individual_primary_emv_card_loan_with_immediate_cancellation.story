Narrative:
In order to validate cancellation fee on loan
As a user
I want to assert cancellation fee on loan  after geting loan

Meta:
@CreditRegression
@StoryName credit_emv_retail_loan
@Individual
@Primary	 

Scenario:1.1 creation of mastercard_individual_primary_emv Card credit device
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
And search Purchase authorization and verify 000-Successful status
When user sign out from customer portal
When user wait for 5 min to perform certain activity
And user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When search transaction with device number on transaction search screen
Then update institution date to 2 days
And user sign out from customer portal


Scenario:1.4 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal

Scenario:1.5 Raise Loan SR and Verify Loan Account Details then update institution date to 1st of next month
Given user is logged in institution
When device has "normal" status
And user raises Retail Transaction to Loan [215] request for Credit
When user verifies loan account details
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
Then user sign out from customer portal

Scenario:1.6 Verify User is able to cancel the loan from helpdesk
Meta:
@PaymentCash
Given user is logged in institution
When device has "normal" status
And user raises Loan Cancellation [243] request for Credit
Then user verifies loan cancellation fee
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And update institution date to first of next month
Then user sign out from customer portal

Scenario:1.7 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:1.8 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
And update institution date to 2 days
Then user sign out from customer portal

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:2.0 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And device has "normal" status
And user notes down required values from helpdesk for credit
And user verifies no Loan Installment Outstanding after payment
Then user sign out from customer portal