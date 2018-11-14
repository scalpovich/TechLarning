Narrative:
In order to validate loan with 3 EMI and preclosure 
As a user
I want to preclosure fee is appliaed as expected 

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
When user sign out from customer portal
When user wait for 7 min to perform certain activity
And user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When search transaction with device number on transaction search screen
Then update institution date to 5 days
And user sign out from customer portal

Scenario:1.4 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal


Scenario:1.5 Raise Loan SR and Verify Loan Account Details then update institution date to 1st of next month
Given user is logged in institution
When device has "normal" status
When user raises Retail Transaction to Loan [215] request for Credit
When user verifies loan account details
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user sign out from customer portal

Scenario:1.6 Raise Loan Preclosure SR and Verify Pre Closure Fee
Given user is logged in institution
When device has "normal" status
When user raises Loan Preclosure [242] request for Credit
And user verifies loan preclosure fee
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When update institution date to first of next month
And user sign out from customer portal

Scenario:3.0 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal


Scenario:2.9 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
Then update institution date to 5 days
And user sign out from customer portal

Scenario:3.0 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal


Scenario:3.1 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And device has "normal" status
And user notes down required values from helpdesk for credit
Then user verifies no Loan Installment Outstanding after payment
And user sign out from customer portal


