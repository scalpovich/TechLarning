Narrative:
In order to validate loan with 3 EMI and Payment perform authorization and process loan
As a user
I want to assert loan is billed and after payment there is zero outstanding 

Meta:
@CreditRegression
@StoryName credit_msr_retail_loan
@DipeshSirExecution				 
Scenario:1.0 creation of mastercard_individual_primary_msr Card credit device
Meta:
@UserCreatesNewCreditDevice
Scenario:1.1 creation of mastercard_individual_primary_msr Card credit device step 1
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And user creates loan plan for credit
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:1.2 creation of mastercard_individual_primary_msr Card credit device step 2
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
Then user sign out from customer portal

Scenario:1.3 Retail Credit card authorization and Pre-clearing & EOD-Credit and update institution date to next day
Given user is logged in institution
When user raises an authorization request
And status of request is "approved"
And user sign out from customer portal
And user wait for 7 min to perform certain activity
And user is logged in institution
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And search transaction with device number on transaction search screen
And update institution date to 5 days
Then user sign out from customer portal
!-- And device has "normal" status
!-- And user notes down required values from helpdesk for credit

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
And user verifies loan account details
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And update institution date to first of next month
Then user sign out from customer portal


Scenario:1.6 Login & Logout to wait for date to be updated 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:1.7 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Loan Installment category
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
And user verify Billed amount for Loan Installment category
And user verify Outstanding amount for Loan Installment category
And update institution date to 5 days
Then user sign out from customer portal
!-- And device has "normal" status
!-- And user notes down required values from helpdesk for credit

Scenario:1.8 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:1.9 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes EMI bill payment through cash
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user check balance details through helpdesk after payment
And update institution date to first of next month
Then user sign out from customer portal

Scenario:2.0 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:2.1 Process Batches for billing and validated values on helpdesk 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Loan Installment category
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
!-- And user verify Billed amount for Loan Installment category
And user verify Outstanding amount for Loan Installment category
And update institution date to 5 days
Then user sign out from customer portal

Scenario:2.2 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:2.3 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes EMI bill payment through cash
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user check balance details through helpdesk after payment
And update institution date to first of next month
And user sign out from customer portal


Scenario:2.4 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:2.5 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Loan Installment category
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
!-- And user verify Billed amount for Loan Installment category
And user verify Outstanding amount for Loan Installment category
And update institution date to next days
Then user sign out from customer portal

Scenario:2.6 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:2.7 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes EMI bill payment through cash
And user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user check balance details through helpdesk after payment
And update institution date to first of next month
Then user sign out from customer portal


Scenario:2.8 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:2.9 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
And update institution date to 5 days
Then user sign out from customer portal

Scenario:3.0 Update institution date then Login & Logout to wait for date to be updated for next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
Then user sign out from customer portal


Scenario:3.1 Process Batches for billing and validated values on helpdesk
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And device has "normal" status
And user notes down required values from helpdesk for credit
And user verifies no Loan Installment Outstanding after payment
Then user sign out from customer portal