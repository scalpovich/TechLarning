regression prepaid MSR Corporate general purpose card authorization PINLESS

Narrative:
In order to check transactions on prepaid MSR Corporate general purpose card
As an issuer
I want to authorize transactions for prepaid MSR Corporate general purpose card

Meta:
@StoryName p_msr_corp_travel_ASI
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
And processes device production batch for prepaid
Then device has "normal" status
And user activates device through helpdesk
And user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: Perform MMSR-CORPORATE_TravelCard Authorization transaction
Given connection to MAS is established
When perform an ASI_MSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal