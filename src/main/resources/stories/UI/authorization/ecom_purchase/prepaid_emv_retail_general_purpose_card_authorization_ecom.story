ECOMM_PURCHASE transaction on prepaid emv retail general purpose card authorization

Narrative:
In order to check transactions on prepaid emv retail general purpose card
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general
@oldReferenceSheet_S203707
@ECOM_PURCHASE

Scenario: ECOMM_PURCHASE transaction on prepaid emv retail general purpose card
Meta:
@TestId TC398452

Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And a new device was created
When user processes pre-production batch for prepaid
When user processes device production batch for prepaid
Then embossing file batch was generated in correct format
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal