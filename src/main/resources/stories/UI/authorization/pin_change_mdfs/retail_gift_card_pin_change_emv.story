MDFS Pin Change on prepaid emv retail giftcard card

Narrative:
In order to check transactions on prepaid emv retail giftcard card 
As an issuer
I want to authorize Pin Change transactions for prepaid emv retail giftcard card

Meta:
@StoryName S203707
@emvpinchange

Scenario: Set up prepaid emv retail giftcard card and perform Pin Change operation
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
Then connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed
Then connection to MDFS is established
When user performs an optimized MDFS_EMV_PIN_CHANGE MDFS transaction
Then MDFS test results are verified
When MDFS simulator is closed
!-- Then user is logged in institution
!-- Then search CWD authorization and verify 000-Successful status
!-- And user sign out from customer portal