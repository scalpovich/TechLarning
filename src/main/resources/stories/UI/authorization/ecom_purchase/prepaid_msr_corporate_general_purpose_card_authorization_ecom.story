ECOMM_PURCHASE transaction on prepaid msr corp general purpose card authorization

Narrative:
In order to check transactions on prepaid msr corp general purpose card
As an issuer
I want to authorize transactions for prepaid msr corp general purpose card

Meta:
@StoryName prepaid_cgc_load_from_file
@oldReferenceSheet_S203707
@ECOM_PURCHASE
@SanitySuite	

Scenario: ECOMM_PURCHASE transaction on prepaid msr corp general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
When device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then embossing file batch was generated in correct format
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal