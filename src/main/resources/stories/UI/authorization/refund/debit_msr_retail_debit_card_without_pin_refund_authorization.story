debit msr retail debit card pinless authorization

Narrative:
In order to provide to client easy-to-use debit msr retail debit card
As an issuer
I want to create an magnetic stripe debit msr retail debit card and perform refund transaction

Meta:
@StoryName p_emv_retail_gift
@oldReferenceSheet_debit_msr
@SanityCardsPinlessWithAuthorization

Scenario: Set up debit msr retail debit card authorization pinless
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then device has "normal" status

Scenario: debit msr retail debit card pinless device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
Then user activates device through helpdesk
And user sign out from customer portal

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
And user sign out from customer portal