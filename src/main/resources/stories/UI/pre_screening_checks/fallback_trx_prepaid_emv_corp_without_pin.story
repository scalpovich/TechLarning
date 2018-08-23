fallback trx on prepaid emv card corporate travel card with no pin

Narrative:
In order to make fallback transactions on prepaid emv corporate travel card
As an issuer
I want to authorize  fallback transactions for prepaid emv corporate travel card

Meta:
@StoryName p_emv_corp_travel
@FallbackTrx
Scenario: Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "emv" card without pin
And User fills Wallet Plan for prepaid product
And User fills MCC Rules for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - FALLBACK_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an FALLBACK_PURCHASE MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search FallBack Transaction authorization and verify 000-Successful status
And user sign out from customer portal