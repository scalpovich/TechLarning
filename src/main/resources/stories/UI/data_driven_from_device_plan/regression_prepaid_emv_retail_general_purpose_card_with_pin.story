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
When device range for program with device plan for "prepaid" "emv" card
And user creates new device of prepaid type for new client
And device has "normal" status
And user has wallet number information for prepaid device
Then user performs adjustment transaction
And user has current wallet balance amount information for prepaid device

Scenario: prepaid emv retail general purpose card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
Then device has "normal" status
And user activates device through helpdesk

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
Then PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Transaction - EMV_PREAUTH and EMV_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an EMV_PREAUTH MAS transaction
And MAS test results are verified
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal