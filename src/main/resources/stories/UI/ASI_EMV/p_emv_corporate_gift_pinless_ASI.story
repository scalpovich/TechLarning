prepaid MSR corporate gift card without PIN

Narrative:
In order to provide a corporate client various scenarios
As an issuer
I want to create a prepaid MSR corporate gift card and test various scenarios

Meta:
@StoryName p_emv_corp_gift_ASI
@ASI
Scenario: Setup - prepaid MSR corporate gift card without PIN
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device production - prepaid MSR corporate gift card without PIN
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal

Scenario: Perform MMSR-CORPORATE_GiftCard Authorization transaction
Given connection to MAS is established
When perform an ASI_EMV MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal