prepaid msr retail travel multi currency card mastercard money send from Card Holder Portal

Narrative:
In order to test mms transaction from CHP
As an issuer
I want to create devices and perform transaction from CHP

Meta:
@StoryName p_msr_retail_travel_mwmc

Scenario: Set up prepaid msr retail travel multi currency card from another institute
Given user is logged in non-default institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for non-default institution
When user creates new device of prepaid type for non-default institution
Then device has "normal" status for non-default institution
Then user activates device through helpdesk
Then user sign out from customer portal

Scenario: Set up prepaid msr retail travel multi currency card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
When add menus to access card holder portal
Then device has "normal" status

Scenario: MMS - CHP - msr retail travel multi currency card
Given user is on login page of cardholder portal
And cardholder signup with valid details
When MMS CHP Transaction is performed
Then Validate Response Message on CHP
And user signs out from cardholder portal
Then user is logged in institution
Then search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal