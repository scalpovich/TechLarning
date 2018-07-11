Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@CreditRegression
@StoryName credit_emv_retail
@DipeshSirExecution				 
Scenario:creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
Given setting json values in excel
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
And user sign out from customer portal
Given user is logged in institution
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device for Supplementary
When credit processes pingeneration batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
When user selects International Use Allow/Disallow status
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an INT_EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 119-Transaction not permitted status
Then assert Decline response with 46007 AuthDecline Code and International transaction not allowed. as description
And user sign out from customer portal

Scenario: Perform International Allow/DisAllow for one hour
Given user is logged in institution
When user allow International Use Allow/Disallow [400] Transaction For One Hour
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Wait for 1 hour and Then Perform Purchase Transaction
When user wait for one hour to perform transaction
And perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then assert Decline response with 46007 AuthDecline Code and International transaction not allowed. as description
And user sign out from customer portal