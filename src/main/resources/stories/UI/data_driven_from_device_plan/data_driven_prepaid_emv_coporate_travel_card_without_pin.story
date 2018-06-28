regression prepaid emv corporate travel card authorization

Narrative:
In order to check transactions on prepaid emv corporate travel card
As an issuer
I want to authorize transactions for prepaid emv corporate travel card

Meta:
@StoryName p_emv_corp_travel
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationRegression
@AuthorizationRegression
@AuthorizationRegressionGroup3
@EMVWithPin

Scenario: Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
Given user is logged in institution
When User fills Device Plan for "Prepaid" "emv" card without pin
When User fills Wallet Plan for prepaid product
When User fills Program section for prepaid product
When User fills Business Mandatory Fields Screen for prepaid product
When User fills Device Range section for prepaid product
When user assigns service code to program
When user creates new device of prepaid type for new client

Scenario: prepaid emv corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal