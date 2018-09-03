prepaid card transaction in white listed MCG
Narrative:
In order to provide to transaction white listed MCG
As an issuer
I want to make transaction at white listed MCG via prepaid card

Meta:
@StoryName  p_msr_gen_on_white_listed_MCG
@white_listed_MCG
Scenario:1 Set up prepaid msr retail general purpose card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "magnetic stripe" card
And User fills Wallet Plan for prepaid product
When User edits Wallet Plan for White Listed MCG
When User fills MCC Rules for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario:2 Device Production for  prepaid msr retail general purpose card
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
Then user sign out from customer portal

Scenario:3 Pin Generation for  prepaid msr retail general purpose card
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:4 Transaction  for prepaid msr retail general purpose card
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario:5 Perform MSR_CASH_ADVANCE Authorization transaction
When perform an MSR_CASH_ADVANCE MAS transaction on the same card
And MAS simulator is closed
And user is logged in institution
And search Cash Advance authorization and verify 100-Do Not Honour status
And assert Decline response with 20004 AuthDecline Code and Invalid wallet. as description
Then user sign out from customer portal