prepaid msr corporate travel card visa money transfer

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform visa money transfer request

Meta:
@StoryName p_visa_msr_corp_travel

Scenario: Set up prepaid msr corporate travel card from another institute
Meta:
@TestId TC398484
Given user is logged in non-default institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for non-default institution
When user creates new device of prepaid type for non-default institution
Then device has "normal" status for non-default institution
Then user sign out from customer portal

Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for specific interface
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk

When user raises a "RVMT" request
Then search Visa Money Transfer authorization and verify 000-Successful status