Prepaid msr corporate general purpose card and perform refund without pin authorization

Narrative:
In order to check transactions on prepaid msr corporate general purpose card
As an issuer
I want to authorize transactions for prepaid msr corporate general purpose card

Meta:
@StoryName p_emv_corp_general_purpose
@oldReferenceSheet_S203707
@CRCardsPinlessWithAuthorization

Scenario: Set up prepaid msr corporate general purpose cards and perform refund without pin authorization
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then user sign out from customer portal
Then user is logged in institution
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then user sign out from customer portal
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then user sign out from customer portal