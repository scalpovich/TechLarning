ECOMM_PURCHASE transaction on prepaid emv corporate gift card authorization

Narrative:
In order to provide a corporate client various transactions
As an issuer
I want to create a prepaid emv corporate gift card and test various transactions

Meta:
@StoryName p_emv_corp_gift
@ECOM_PURCHASE

Scenario: ECOMM_PURCHASE transaction on prepaid emv corporate gift card
Meta:fdx
@TestId 
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then embossing file batch was generated in correct format
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal