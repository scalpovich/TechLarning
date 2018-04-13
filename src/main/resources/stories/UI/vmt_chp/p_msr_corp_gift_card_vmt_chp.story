prepaid msr corporate gift card visa money transfer

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform visa money transfer request

Meta:
@StoryName p_visa_msr_corp_gift

Scenario: 01. Set up prepaid msr corporate general purpose card from another institute
Given user is logged in non-default institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for non-default institution for interface
When user creates new device of prepaid type for non-default institution
Then device has "normal" status for non-default institution
Then user sign out from customer portal

Scenario: 02. Set up prepaid msr corporate general purpose pinless card and perform Visa RVMT Receiving Certification
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" "Manual" activation code for card without pin for an interface
When user creates new device of prepaid type for new client
When device has "normal" status
When a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
When device has "normal" status
When user activates device through helpdesk
And add menus to access card holder portal
And user sign out from customer portal

Scenario: 03. CHP - VMT
Given user is on login page of cardholder portal
And cardholder signup with valid details
When VISA CHP Transaction is performed
Then Validate Response Message on CHP for VMT
And user signs out from cardholder portal
Then user is logged in institution
Then search Visa Money Transfer authorization and verify 000-Successful status
And user sign out from customer portal