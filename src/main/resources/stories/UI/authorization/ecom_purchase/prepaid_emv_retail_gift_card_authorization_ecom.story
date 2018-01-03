ECOMM_PURCHASE transaction on prepaid emv retail giftcard card authorization

Narrative:
In order to check transactions on prepaid emv retail giftcard card 
As an issuer
I want to authorize transactions for prepaid emv retail giftcard card

Meta:
@StoryName p_emv_retail_gift
@ECOM_PURCHASE

Scenario: ECOMM_PURCHASE transaction on prepaid emv retail giftcard card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal