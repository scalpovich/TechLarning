Narrative:
In order to test transaction with invalid pin and reset pin retry counter
As an issuer
I want to perform transactions for prepaid emv corporate card

Meta:
@StoryName p_emv_corp_travel
@pinRetryLimitValidationAndResetCounter

Scenario: 1.0 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: 1.1 prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user has current wallet balance amount information for prepaid device
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And device has "normal" status
And user sets invalid pin
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction with invalid pin
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then user is logged in institution
And search Purchase authorization and verify 117-Incorrect PIN status
And assert Decline response with 46051 AuthDecline Code and Incorrect Pin. as description
And user sign out from customer portal

Scenario: Perform EMV_PURCHASE Authorization transaction for pin retry limit check
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 106-Allowable Pin tries exceeded status
And assert Decline response with 46053 AuthDecline Code and Pin retry limit exceeded. as description
And device has "normal" status
And user creates service request for Reset Pin Retry Counter [109] service
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then PIN is retrieved successfully with data from Pin Offset File

Scenario: Perform EMV_PURCHASE Authorization transaction with valid pin
When perform an EMV_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
And FINSim simulator is closed
And MAS simulator is closed
