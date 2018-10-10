invalid mcc msr retail debit card authorization

Narrative:
In order to check allow msr retail debit card authorization on mcc 
As an issuer
I want to authorize transactions for prepaid msr retail debit card 


Meta:
@StoryName d_msr_retail
@CRCardsWithAuthorizationCashAdvancedWithClearing
@SanitySuite

Scenario: Setup - debit msr retail debit card
Given user is logged in institution
When device range for program with device plan for "debit" "magnetic stripe" card
Then user sign out from customer portal

Scenario: Device production - debit msr retail debit card
Given user is logged in institution
When user edits MCC rules from 5999 to 5999 uncheck approve international transactions
When user creates new device of debit type for new client
And a new device was created
And processes pre-production batch for debit
And processes device production batch for debit
And processes pin generation batch for debit
And device has "normal" status
And user activates device through helpdesk
And user has wallet number information for debit device
And user performs adjustment transaction
And user has current wallet balance amount information for debit device
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_PURCHASE Authorization transaction with inrnational MCC detached
Given connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization transaction with inrnational MCC detached
When perform an INT_MSR_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 46059 AuthDecline Code and MCC Blocked for International usage. as description
Then user sign out from customer portal

Scenario: change MCC rule plan for international and dometic  
Given user is logged in institution
When user edits MCC rules from 5999 to 5999 uncheck approve international transactions
And user edits MCC rules from 5999 to 5999 uncheck approve domestic transactions
Then user sign out from customer portal


Scenario: Perform MSR_PURCHASE Authorization transaction with domestic MCC detached
When perform an MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
And assert Decline response with 46058 AuthDecline Code and MCC Blocked for Domestic usage. as description
Then user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization domestic with domestic MCC detached
When perform an INT_MSR_PURCHASE MAS transaction on the same card
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user sign out from customer portal


