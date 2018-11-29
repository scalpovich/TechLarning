Narrative:
In order to test transaction plan without assigned transaction for prepaid emv corporate travel card
As an issuer
I want to fail transactions for prepaid emv corporate travel card

Meta:
@StoryName p_emv_corp_travel
@TransactionPlanWithoutAssignTransactions

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User creates empty Transaction Plan for prepaid product
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user sign out from customer portal


Scenario: 1.1 prepaid emv corporate travel card device production
Given user is logged in institution
When user creates new device of prepaid type for new client
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And device has "normal" status
Then user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And PIN is retrieved successfully with data from Pin Offset File
And embossing file batch was generated in correct format
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS simulator is closed
Then user is logged in institution
And search Purchase authorization and verify 119-Transaction not permitted status
And assert Decline response with 10001 AuthDecline Code and Transaction not permitted to device holder. as description
And user sign out from customer portal