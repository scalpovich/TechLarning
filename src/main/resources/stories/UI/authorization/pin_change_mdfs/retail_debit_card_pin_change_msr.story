MDFS Pin Change on debit msr retail debit card

Narrative:
In order to check transactions on debit msr retail debit card pinless
As an issuer
I want to authorize Pin Change transactions for debit msr retail debit card pinless

Meta:
@StoryName d_msr_retail
@msrpinchange

Scenario: Setup - debit msr retail debit card and perform Pin Change operation
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card
When user creates new device of debit type for new client
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
Then user sign out from customer portal
Then connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
Then connection to MDFS is established
When user performs an optimized MDFS_MSR_PIN_CHANGE MDFS transaction
Then MDFS test results are verified
When MDFS simulator is closed
!-- Then user is logged in institution
!-- Then search CWD authorization and verify 000-Successful status
!-- And user sign out from customer portal