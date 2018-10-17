Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card for ARQC Validation.

Meta:
@StoryName d_emv_corp				 

Scenario:1.1 Set up debit emv corporate travel card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "debit" "emv" card for issuer scripting
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction with wrong keys
And MAS test results are verified
And user is logged in institution
And search Invalid Transaction authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed