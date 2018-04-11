regression prepaid MSR Retail general purpose card authorization PINLESS

Narrative:
In order to check transactions on prepaid MSR retail general purpose card
As an issuer
I want to authorize transactions for prepaid MSR retail general purpose card

Meta:
@StoryName p_msr_corp_travel
@MMSR
Scenario: Set up prepaid msr corporate travel card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid msr corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Perform MMSR-CORPORATE_TravelCard Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal