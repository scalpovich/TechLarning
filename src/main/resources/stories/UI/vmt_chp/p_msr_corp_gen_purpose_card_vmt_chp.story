Prepaid msr corporate general purpose pinless card : Visa RVMT Receiving

Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform RVMT Receiving through vts

Meta:
@StoryName SWSC_MSR_CGP_LOAD_ACTV_VTS_NPIN
@visa_rvmt_receiving

Scenario: Set up prepaid msr corporate general purpose pinless card and perform Visa RVMT Receiving
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" "Manual" activation code for card without pin for an interface
When user creates new device of prepaid type for new client
When device has "normal" status
When a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user activates device through helpdesk
And add menus to access card holder portal
And user sign out from customer portal

Scenario: MMS - CHP - msr retail travel multi currency card
Given user is on login page of cardholder portal
And cardholder signup with valid details
When VISA CHP Transaction is performed
Then Validate Response Message on CHP for VMT
And user signs out from cardholder portal
Then user is logged in institution
Then search VISA Money Transfer authorization and verify 000-Successful status
And user sign out from customer portal