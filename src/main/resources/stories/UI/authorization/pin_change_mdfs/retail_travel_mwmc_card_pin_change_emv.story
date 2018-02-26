MDFS Pin Change on Prepaid emv retail travel card multi currency

Narrative:
In order to check transactions on prepaid msr retail travel mwmc card 
As an issuer
I want to authorize Pin Change transactions for prepaid msr retail travel mwmc card 

Meta:
@StoryName p_emv_retail_travel_mwmc
@emvpinchange

Scenario: Setup multi-currency prepaid emv retail travel card and and perform Pin Change operation
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
And user sign out from customer portal
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
And user sign out from customer portal
Then connection to FINSim is established
When Pin Offset file batch was generated successfully
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
When embossing file batch was generated in correct format
Then connection to MDFS is established
When user performs an optimized MDFS_EMV_PIN_CHANGE MDFS transaction
Then MDFS test results are verified
When MDFS simulator is closed
Then user is logged in institution
Then search Pin Change authorization and verify 000-Successful status
And user sign out from customer portal