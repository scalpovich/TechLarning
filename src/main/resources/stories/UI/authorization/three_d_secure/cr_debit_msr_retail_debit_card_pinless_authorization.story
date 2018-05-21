3d secure debit msr retail debit card authorization PINLESS

Narrative:
In order to check transactions on debit msr retail debit card pinless
As an issuer
I want to authorize transactions for debit msr retail debit card pinless

Meta:
@StoryName d_msr_retail

Scenario: Setup - debit msr retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
When user updates cvccvv as uncheck on device plan
Then user sign out from customer portal

Scenario: Device production - debit msr retail debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then embossing file batch was generated in correct format
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal

Scenario: Perform 3D_SECURE_CAVV Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an 3D_SECURE_CAVV MAS transaction
Then MAS test results are verified