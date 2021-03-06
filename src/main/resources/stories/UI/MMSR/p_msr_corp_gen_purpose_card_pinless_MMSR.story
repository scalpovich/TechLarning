prepaid emv corporate general purpose card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate general purpose card and test various transactions

Meta:
@StoryName p_msr_corp_general_purpose_MMSR
@MSSR

Scenario: Transaction - prepaid msr corporate general purpose card - MMSR Authorization transaction
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: prepaid msr corporate travel card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario: Perform MMSR-CORPORATE_TravelCard Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Money Send Person To Person authorization and verify 000-Successful status
And user sign out from customer portal