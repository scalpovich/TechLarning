prepaid msr retail general purpose card authorization PINLESS

Narrative:
In order to check transactions on prepaid msr retail general purpose card
As an issuer
I want to authorize transactions for prepaid msr retail general purpose card

Meta:
@StoryName p_msr_retail_gen_purpose_ASI
@ASI

Scenario: Set up prepaid msr retail general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client

Scenario: prepaid msr retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal
Then embossing file batch was generated in correct format

Scenario: Perform MMSR-RetailGeneralPurposeCard Authorization transaction
Given connection to MAS is established
When perform an ASI_MSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal