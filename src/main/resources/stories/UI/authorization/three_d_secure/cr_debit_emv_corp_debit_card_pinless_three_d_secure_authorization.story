3d secure debit emv corporate card authorisation PINLESS

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a EMV Corporate debit card for client

Meta:
@StoryName d_emv_corp

Scenario: Set up program for debit emv corp debit card
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit emv corp debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: perform 3D_SECURE_CAVV authorization on corporate msr card
When connection to MAS is established
When perform an 3D_SECURE_CAVV MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal