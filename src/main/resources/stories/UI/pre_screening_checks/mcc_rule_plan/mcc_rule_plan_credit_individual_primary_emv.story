invalid mcc mastercard_individual_primary_emv authorization

Narrative:
In order to check allow mastercard_individual_primary_emv authorization on mcc 
As an issuer
I want to authorize transactions for mastercard_individual_primary_emv card 

Meta:
@CreditRegression
@StoryName credit_emv_retail
@Individual
@Primary	 
Scenario:creation of mastercard_individual_primary_emv Card credit device
Meta:
@UserCreatesNewCreditDevice
Given setting json values in excel for Credit
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Billing Cycle
And User fills Payment Priority
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
When for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:creation of mastercard_individual_primary_emv Card credit device step 2
Given user is logged in institution
When user edits MCC rules from 5999 to 5999 uncheck approve international transactions
When credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
!-- And User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And device has "normal" status
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction with inrnational MCC detached
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization transaction with inrnational MCC detached
When perform an INT_MSR_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 46059 AuthDecline Code and MCC Blocked for International usage. as description
Then user sign out from customer portal

Scenario: change MCC rule plan for international and dometic  
Given user is logged in institution
When user edits MCC rules from 5999 to 5999 uncheck approve international transactions
And user edits MCC rules from 5999 to 5999 uncheck approve domestic transactions
Then user sign out from customer portal


Scenario: Perform MSR_PURCHASE Authorization transaction with domestic MCC detached
When perform an MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 46058 AuthDecline Code and MCC Blocked for Domestic usage. as description
Then user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization domestic with domestic MCC detached
When perform an INT_MSR_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal
