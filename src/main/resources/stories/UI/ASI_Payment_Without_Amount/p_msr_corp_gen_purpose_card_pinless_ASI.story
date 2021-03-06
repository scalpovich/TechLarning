prepaid msr corporate general purpose card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid msr corporate general purpose card and test various transactions

Meta:
@StoryName p_msr_corp_general_purpose_ASI
@ASI

Scenario: Transaction - prepaid msr corporate general purpose card - ASI_PAYMENT_WITHOUT_AMOUNT transaction
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal
Given connection to MAS is established
When perform an ASI_PAYMENT_WITHOUT_AMOUNT MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 085-Successful status
And user sign out from customer portal