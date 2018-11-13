Narrative:
In order to a create a Prepaid Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card for ARQC Validation.

Meta:
@StoryName p_emv_corp_travel				 

Scenario:1.1 Set up prepaid emv corporate travel card
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "prepaid" "emv" card for issuer scripting
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user creates new device of prepaid type for new client
And a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And device has "NOT ACTIVATED CARD" status
And user activates device through helpdesk
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
Then user sign out from customer portal

Scenario:1.2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed


Scenario:1.4 Update ATC Range Counter to required value
Given user updates ATC value as true and value as 0007

Scenario:1.5 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
Then assert Decline response with 100-Do Not Honour AuthDecline Code and ATC Range voilated. as description
And user sign out from customer portal
And MAS simulator is closed

Scenario:1.6 Update ATC Range Counter to required value
Given user updates ATC value as true and value as 0005

Scenario:1.7 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed

Scenario:1.8 Update ATC Range Counter to required value
Given user updates ATC value as true and value as 0000

Scenario:1.9 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
And user is logged in institution
And search Purchase authorization and verify 100-Do Not Honour status
Then assert Decline response with 25004 AuthDecline Code and Duplicate ATC Received. as description
And user sign out from customer portal
And MAS simulator is closed