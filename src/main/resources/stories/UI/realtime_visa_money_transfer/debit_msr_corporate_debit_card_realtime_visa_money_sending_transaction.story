debit msr corporate debit card visa money transfer

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create an magnetic stripe debit card and perform visa money transfer request

Meta:
@StoryName d_visa_emv_corp

Scenario: Transaction - debit emv corp debit card
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
And user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal


When user raises a "RVMT" request
Then search Visa Money Transfer authorization and verify 000-Successful status