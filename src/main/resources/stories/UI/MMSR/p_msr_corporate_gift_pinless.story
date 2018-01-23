prepaid MSR corporate gift card without PIN

Narrative:
In order to provide a corporate client various scenarios
As an issuer
I want to create a prepaid MSR corporate gift card and test various scenarios

Meta:
@StoryName p_msr_corp_gift
@AuthorizationRegression
@AuthorizationRegressionGroup2
@MSRWithoutPin
@MMSR
Scenario: Setup - prepaid MSR corporate gift card without PIN
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device production - prepaid MSR corporate gift card without PIN
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

Scenario: Perform MMSR-CORPORATE_GiftCard Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal