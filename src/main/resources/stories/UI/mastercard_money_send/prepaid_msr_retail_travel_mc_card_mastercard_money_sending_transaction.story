prepaid msr retail travel multi currency card mastercard money send

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform mastercard money send request

Meta:
@StoryName p_retail_travel_mc_mms

Scenario: Set up prepaid msr retail travel multi currency card from another institute
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
When user has wallet number information for prepaid device
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user setup device currency through helpdesk
Then currency setup for prepaid device is done correctly and updated in wallet details tab
When user performs adjustment transaction
And user performs adjustment transaction for second wallet
Then device has "normal" status

When user raises a money send request from second wallet
Then search MasterCard MoneySend authorization and verify 000-Successful status
