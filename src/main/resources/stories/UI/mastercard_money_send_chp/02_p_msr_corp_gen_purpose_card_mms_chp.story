prepaid msr corporate general purpose card mastercard money send from Card Holder Portal

Narrative:
In order to test mms transaction from CHP
As an issuer
I want to create devices and perform transaction from CHP

Meta:
@StoryName p_msr_corp_general_purpose

Scenario: Set up prepaid msr corporate general purpose card from another institute
Given user is logged in non-default institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for non-default institution
When user creates new device of prepaid type for non-default institution
Then device has "normal" status for non-default institution
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Set up prepaid msr corporate general purpose card
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
Then user activates device through helpdesk

Scenario: MMS - CHP - msr corporate general purpose card
Given user is on login page of cardholder portal
And cardholder signup with valid details
When MMS CHP Transaction is performed
Then Validate Response Message on CHP
And user signs out from cardholder portal
Then user is logged in institution
Then search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal