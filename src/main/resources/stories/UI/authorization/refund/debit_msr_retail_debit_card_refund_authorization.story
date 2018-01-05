debit msr retail debit card authorization

Narrative:
In order to provide to client easy-to-use debit msr retail debit card
As an issuer
I want to create an magnetic stripe debit msr retail debit card and perform refund transaction

Meta:
@StoryName p_emv_retail_gift
@oldReferenceSheet_prepaid_msr
@SanityCardsWithAuthorization

Scenario: Set up debit msr retail debit card
Meta:
@TestId TC406658
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client

Scenario: debit msr corporate debit card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit

Then device has "normal" status
When user has wallet number information for debit device
Then user sign out from customer portal
Then user is logged in institution
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform MSR_REFUND Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then user sign out from customer portal

Scenario: Program Balance Summary download
Meta:
@TestId 
Given user is logged in institution
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded