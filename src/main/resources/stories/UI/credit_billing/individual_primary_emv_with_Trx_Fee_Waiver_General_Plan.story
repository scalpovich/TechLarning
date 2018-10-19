Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to verify fee is waived off in various offer on plan

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
And User fills Device Plan for credit emv card with transaction fee waived Off
When User add General type in Transaction Fee Waiver plan as Both origin and Daily frequency
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

Scenario:1.3 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.4 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is not waived off
Then user sign out from customer portal

Scenario:1.5 Add plan in Trx Fee waiver plan- General type,Domestice origin and Daily frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Domestic origin and Daily frequency
Then user sign out from customer portal

Scenario:1.6 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:1.7 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is not waived off
Then user sign out from customer portal

Scenario:1.8 Add plan in Trx Fee waiver plan- General type,Both origin and Monthly frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Both origin and Monthly frequency
Then user sign out from customer portal

Scenario:1.9 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.0 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is not waived off
Then user sign out from customer portal

Scenario:2.1 Login & Logout to wait for date to be updated 
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.2 Process Batches for billing and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user sign out from customer portal

Scenario:2.4 Add plan in Trx Fee waiver plan- General type,Domestice origin and Monthly frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Domestic origin and Monthly frequency
Then user sign out from customer portal

Scenario:2.5 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.6 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is not waived off
Then user sign out from customer portal

Scenario:2.7 Login & Logout to wait for date to be updated 
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:2.8 Process Batches for billing and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user sign out from customer portal

Scenario:2.9 Add plan in Trx Fee waiver plan- General type,Both origin and Quarterly frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Both origin and Quarterly frequency
Then user sign out from customer portal

Scenario:3.0 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:3.1 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is not waived off
Then user sign out from customer portal

Scenario:3.2 Add plan in Trx Fee waiver plan- General type,Domestice origin and Quarterly frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Domestic origin and Quarterly frequency
Then user sign out from customer portal

Scenario:3.3 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:3.4 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is not waived off
Then user sign out from customer portal

Scenario:3.5 Login & Logout to wait for date to be updated 
Meta:
@TestId 
When update institution date to first of next month
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:3.6 Process Batches for billing and validated values on helpdesk and statement 
Meta:
@TestId 
Given user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user processes Billing Process - Credit system internal batch for Credit
And user sign out from customer portal


Scenario:3.7 Add plan in Trx Fee waiver plan- General type,Both origin and Permanent frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Both origin and Permanent frequency
Then user sign out from customer portal

Scenario:3.8 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:3.9 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
Then user sign out from customer portal

Scenario:4.0 Add plan in Trx Fee waiver plan- General type,Domestice origin and Permanent frequency
Given user is logged in institution
When User add General type in Transaction Fee Waiver plan as Domestic origin and Permanent frequency
Then user sign out from customer portal

Scenario:4.1 Bump next day to make transaction
Meta:
@PaymentCash
When update institution date to next days
Given user is logged in institution
When user sign out from customer portal
And user is logged in institution
And user sign out from customer portal
And user is logged in institution
And user sign out from customer portal

Scenario:4.2 Perform Authorization transaction
Given user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee is waived off
Then user sign out from customer portal