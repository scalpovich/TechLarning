prepaid msr corporate general purpose card mastercard money send chp

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
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And user sign out from customer portal
Given user is on login page of cardholder portal
Then cardholder signup with valid details
When fund transfer through MasterCard Money Send
Then verify MasterCard Money send fund transfer stauts
Then search MasterCard MoneySend authorization and verify 000-Successful status
