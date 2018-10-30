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
When user sign out from customer portal
When user wait for seven minutes to perform certain activity
And user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When search transaction with device number on transaction search screen
Then update institution date to 5 days
And user sign out from customer portal
!-- And device has "normal" status
!-- And user notes down required values from helpdesk for credit

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.4 Raise Loan SR and Verify Loan Account Details then update institution date to 1st of next month
Given user is logged in institution
When device has "normal" status
When user raises Retail Transaction to Loan [215] request for Credit
When user verifies loan account details
And update institution date to first of next month
And user sign out from customer portal


Scenario:1.6 Login & Logout to wait for date to be updated 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.7 Process Batches for billing and validated values on helpdesk and statement 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Loan Installment category
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
And user verify Billed amount for Loan Installment category
And user verify Outstanding amount for Loan Installment category
Then update institution date to next days
And user sign out from customer portal
!-- And device has "normal" status
!-- And user notes down required values from helpdesk for credit

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.8 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes EMI bill payment through cash
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When user check balance details through helpdesk after payment
When update institution date to first of next month
And user sign out from customer portal

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.7 Process Batches for billing and validated values on helpdesk and statement 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Loan Installment category
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
And user verify Billed amount for Loan Installment category
And user verify Outstanding amount for Loan Installment category
Then update institution date to next days
And user sign out from customer portal

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.8 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes EMI bill payment through cash
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When user check balance details through helpdesk after payment
And update institution date to first of next month
And user sign out from customer portal


Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.7 Process Batches for billing and validated values on helpdesk and statement 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Loan Installment category
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
And user verify Billed amount for Loan Installment category
And user verify Outstanding amount for Loan Installment category
Then update institution date to next days
And user sign out from customer portal

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.8 Verify User is able to make Payment of credit card through cash mode after billing cycle
Meta:
@PaymentCash
Given user is logged in institution
When user check balance details through helpdesk before payment
And user makes EMI bill payment through cash
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
When user check balance details through helpdesk after payment
When update institution date to first of next month
And user sign out from customer portal


Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.7 Process Batches for billing and validated values on helpdesk and statement 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user verifies batch job history with job id
Then update institution date to next days
And user sign out from customer portal

Scenario:1.9 Update institution date then Login & Logout to wait for date to be updated foe next billing
Meta:
@TestId 
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.7 Process Batches for billing and validated values on helpdesk and statement 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And device has "normal" status
And user notes down required values from helpdesk for credit
Then user verifies no Loan Installment Outstanding after payment
And user sign out from customer portal
