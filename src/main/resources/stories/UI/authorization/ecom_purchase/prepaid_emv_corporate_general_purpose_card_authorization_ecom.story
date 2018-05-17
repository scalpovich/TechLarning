ECOMM_PURCHASE transaction on prepaid emv corp general purpose card authorization

Narrative:
In order to check transactions on prepaid corp general purpose card
As an issuer
I want to authorize transactions for prepaid corp general purpose card

Meta:
@StoryName p_emv_corporate_general
@oldReferenceSheet_S203707
@ECOM_PURCHASE

Scenario: ECOMM_PURCHASE transaction on prepaid emv corp general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
When user creates new device of prepaid type for new client
When device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal