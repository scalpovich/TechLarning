prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general
@JsonDataDriven

Scenario: Set up prepaid emv retail general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device

Scenario: prepaid emv retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal