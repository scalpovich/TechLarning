prepaid card transaction in white listed MCG
Narrative:
In order to provide to transaction white listed MCG
As an issuer
I want to make transaction at white listed MCG via prepaid card

Meta:
@StoryName p_transaction_white_listed_MCG

Scenario: Set up prepaid msr retail general purpose card
Given user is logged in institution
Given device range for program with device plan for "prepaid" "magnetic stripe" card
When User edits Wallet Plan for White Listed MCG
And user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When a new device was created
When processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
Then embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
And FINSim simulator is closed

Scenario: Transaction
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS simulator is closed
And user is logged in institution
And search Cash Advance authorization and verify 100-Do Not Honour status
And assert Decline response with 25004 AuthDecline Code and Invalid wallet. as description
And user sign out from customer portal