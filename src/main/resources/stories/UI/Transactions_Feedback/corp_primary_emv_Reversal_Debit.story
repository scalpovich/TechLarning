Narrative:
In order to a create a Debit Device under customer portal cardmanagement tab
As a user
I want to assert Reversal of Transaction.


Meta:
@Pre-ScreeningCheck
@StoryName d_emv_corp_travel				 
@PreScreening

Scenario:1 Set up debit emv corporate tsravel card
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "debit" "emv" card
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
And user assigns service code to program
And user creates new device of debit type for new client
Then user sign out from customer portal

Scenario:2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario:3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
And user sign out from customer portal

Scenario:4 When user perform Reveral of Purchase Transaction
Given user is logged in institution
Given user generate Reversal for Transaction
Then search Purchase Reversal authorization and verify 000-Successful status
And user verify available balance after reversal
And MAS simulator is closed