Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to not payment for one bill cycle and verify late payment and interest is applied in in next billing

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
When user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:1.4 Run Pre-clearing and EOD-Credit
Given user is logged in institution
When user wait for seven minutes to perform certain activity
And user sign out from customer portal
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
When user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user sign out from customer portal

Scenario:1.5 Login & Logout to wait for date to be updated 
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.6 Process Batches for billing and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user processes Billing Process - Credit system internal batch for Credit
And device has "normal" status
And user notes down required values from helpdesk for credit
And user verify Billed amount for Purchase category
And user update COLLECTION Administrative as Approve [0]
And user sign out from customer portal

Scenario: 1.7 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.8 Process Batches for billing to next cycle and validated values on helpdesk
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
When user verify Delinquency value for Status category is 1ST UNPAID
And user verify Authorization Flag value for Status category is Approve [0]
And device has "normal" status
And user notes down required values from helpdesk for credit
And user sign out from customer portal

Scenario: 1.9 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.0 Perform Authorization transaction
When user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
And user update COLLECTION Administrative as Decline [1]
Then user sign out from customer portal

Scenario: 2.1 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.2 Process Batches for billing to next cycle and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
When user verify Delinquency value for Status category is 2ND UNPAID
And user verify Authorization Flag value for Status category is Decline [1]
And device has "normal" status
And user notes down required values from helpdesk for credit
And user sign out from customer portal

Scenario: 2.3 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.4 Perform Authorization transaction
When user is logged in institution
And user raises an authorization request
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 20010 AuthDecline Code and Invalid wallet Status. as description
And user update COLLECTION Administrative as Refer [2]
And user sign out from customer portal

Scenario: 2.5 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.6 Process Batches for billing to next cycle and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
When user verify Delinquency value for Status category is 3RD UNPAID
And user verify Authorization Flag value for Status category is Refer [2]
And device has "normal" status
And user notes down required values from helpdesk for credit
And user sign out from customer portal

Scenario: 2.7 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.8 Perform Authorization transaction
When user is logged in institution
And user raises an authorization request
And search Purchase authorization and verify 200-REFER CARD status
And assert Refer response with 20010 AuthDecline Code and Invalid wallet Status. as description
And user sign out from customer portal


Scenario: 2.9 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:3.0 Process Batches for billing to next cycle and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
When user verify Delinquency value for Status category is 4TH UNPAID
And user verify Authorization Flag value for Status category is Capture [3]
And device has "normal" status
And user notes down required values from helpdesk for credit
And user sign out from customer portal

Scenario: 3.1 Login & Logout to wait for date to be updated for next billing cycle
Meta:
@TestId 
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:3.2 Perform Authorization transaction
When user is logged in institution
And user raises an authorization request
And search Purchase authorization and verify 200-CAPTURE CARD status
And assert Capture response with 20010 AuthDecline Code and Invalid wallet Status. as description
And user update COLLECTION Administrative as Approve [0]
And user sign out from customer portal