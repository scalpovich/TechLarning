debit msr corporate debit card withPin

Narrative:
In order to check transactions on debit msr corporate debit card
As an issuer
I want to authorize transactions for debit msr corporate debit card

Meta:
@StoryName d_msr_corp
@SanityCardsWithAuthorization
@MSRWithPin

Scenario: Set up program for debit MSR corporate debit card
Given setting json values in excel for Debit
Given user is logged in institution
When User fills Device Plan for "Debit" "magnetic stripe" card
When User fills Wallet Plan for debit product
When User fills Program section for debit product
When User fills Business Mandatory Fields Screen for debit product
When User fills Device Range section for debit product
When user assigns service code to program
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device

Scenario: debit MSR corporate debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - MSR_PREAUTH Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal