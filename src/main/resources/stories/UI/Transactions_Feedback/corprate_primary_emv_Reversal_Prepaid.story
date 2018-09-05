Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card.

Meta:
@Pre-ScreeningCheck
@StoryName p_emv_corp_travel				 
@PreScreening

Scenario:1 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
When user creates new device of prepaid type for new client
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "normal" status
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
And user sign out from customer portal

Scenario: When user perform Reveral of Purchase Transaction
Given user is logged in institution
Given user generate Reversal for Transaction
Then search Purchase Reversal authorization and verify 000-Successful status
And user verify available balance afer reversal