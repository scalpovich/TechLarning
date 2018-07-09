prepaid card transaction at white black country

Narrative:
In order to provide to transaction at black listed country
As an issuer
I want to make transaction at black listed country via prepaid card

Meta:
@StoryName prepaid_card_trx_at_black_list_country

Scenario: Set up prepaid msr retail general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card with Country White or Black List
When user creates new device of prepaid type for new client
Then device has "normal" status
And user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform INT_MSR_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an INT_MSR_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then search Purchase authorization and verify 100-Do Not Honour status
Then assert Decline response with 25002 AuthDecline Code and Country is blacklisted. as description
Then user sign out from customer portal