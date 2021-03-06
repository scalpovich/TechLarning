debit emv corporate debit card withoutPin

Narrative:
In order to check transactions on debit emv corporate card
As an issuer
I want to authorize transactions for emv corporate debit card

Meta:
@StoryName d_emv_corp
@JsonDataDriven
Scenario: Set up program for debit emv corporate debit card
Given user is logged in institution
When device range for program with device plan for "debit" "emv" card without pin
And user creates new device of debit type for new client
And device has "normal" status
And user has wallet number information for debit device
And user performs adjustment transaction
Then user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And device has "normal" status
Then user activates device through helpdesk
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
And MAS test results are verified
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal