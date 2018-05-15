MDFS Pin Change on prepaid msr corporate travel card authorization

Narrative:
In order to check transactions on prepaid msr corporate travel card
As an issuer
I want to authorize Pin Change transactions for prepaid corporate travel card

Meta:
@StoryName p_msr_corp_travel
@msrpinchange

Scenario: Set up prepaid msr corporate travel card and perform Pin Change operation
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal
Then connection to FINSim is established
When Pin Offset file batch was generated successfully
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
When embossing file batch was generated in correct format
Then connection to MDFS is established
When user performs an optimized MDFS_MSR_PIN_CHANGE MDFS transaction
Then MDFS test results are verified
When MDFS simulator is closed
Then user is logged in institution
Then search Pin Change authorization and verify 000-Successful status
And user sign out from customer portal