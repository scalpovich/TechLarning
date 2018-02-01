prepaid msr retail gift card pinless authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card pinless
As an issuer
I want to create an magnetic stripe prepaid card pinless and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift_ASI
@ASI
Scenario: Set up prepaid msr retail gift card authorization pinless
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user sign out from customer portal

Scenario: prepaid msr retail gift card authorization pinless device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Perform MMSR-RetailGiftCard Authorization transaction
Given connection to MAS is established
When perform an ASI_EMV MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search Account Status authorization and verify 000-Successful status
And user sign out from customer portal