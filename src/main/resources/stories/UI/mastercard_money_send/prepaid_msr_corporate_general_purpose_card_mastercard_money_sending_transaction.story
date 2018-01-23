prepaid msr corporate general purpose card mastercard money send

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform mastercard money send request

Meta:
@StoryName p_corp_general_purpose_mms

Scenario: Set up prepaid msr corporate general purpose card from another institute
Meta:
@TestId TC398484
Given user is logged in non-default institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for non-default institution
When user creates new device of prepaid type for non-default institution
Then device has "normal" status for non-default institution
Then user sign out from customer portal

Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status

When user raises a money send request
Then search MasterCard MoneySend authorization and verify 000-Successful status
