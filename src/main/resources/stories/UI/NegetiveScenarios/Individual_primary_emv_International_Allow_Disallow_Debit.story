Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@StoryName d_emv_corp
@SanityCardsWithAuthorization
@EMVWithPin
@PreScreening

Scenario: Set up program for debit emv corporate debit card
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
When user selects International Use Allow/Disallow status
Then user activates device through helpdesk

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an INT_EMV_PURCHASE MAS transaction
And user is logged in institution
Then search Purchase authorization and verify 119-Transaction not permitted status
Then assert Decline response with 46007 AuthDecline Code and International transaction not allowed. as description
And user sign out from customer portal

Scenario: Perform International Allow/DisAllow for one hour
Given user is logged in institution
When user allow International Use Allow/Disallow [400] Transaction For One Hour
And user sign out from customer portal

Scenario: Perform INT_EMV_PURCHASE Authorization transaction
When perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Wait for 1 hour and Then Perform Purchase Transaction
When user wait for one hour to perform transaction
And perform an INT_EMV_PURCHASE MAS transaction on the same card
And user is logged in institution
Then assert Decline response with 46007 AuthDecline Code and International transaction not allowed. as description
And user sign out from customer portal