prepaid emv retail general purpose card authorization PINLESS

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general_ASI
@ASI_EMV

Scenario: Set up prepaid emv retail general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid EMV retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Perform ASI_EMV-RetailGeneralPurposeCard Authorization transaction
Given connection to MAS is established
When perform an ASI_EMV MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal