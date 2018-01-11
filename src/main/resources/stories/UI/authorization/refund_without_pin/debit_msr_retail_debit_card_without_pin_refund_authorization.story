Debit msr retail debit card refund without pin authorization

Narrative:
In order to provide to client easy-to-use debit msr retail debit card
As an issuer
I want to create an magnetic stripe debit msr retail debit card and perform refund transaction

Meta:
@StoryName d_msr_retail
@oldReferenceSheet_debit_msr
@SanityCardsPinlessWithAuthorization

Scenario: Set up Debit msr retail debit card and perform refund without pin authorization
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
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
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then user sign out from customer portal