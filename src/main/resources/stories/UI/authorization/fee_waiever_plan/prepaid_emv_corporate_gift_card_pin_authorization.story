prepaid emv corporate gift card authorization PINLESS

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate gift card and test various transactions

Meta:
@StoryName p_emv_corp_gift

Scenario: Transaction - prepaid emv corporate gift card - EMV_PURCHASE Authorization transaction
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: Device Production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
Then user sign out from customer portal

Scenario: Pin Generation 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_PURCHASE_WITH_CASHBACK Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE_WITH_CASHBACK MAS transaction
And MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And verify transaction fee waived off
Then user sign out from customer portal
