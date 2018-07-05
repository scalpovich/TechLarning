invalid icvv cvv2 prepaid emv retail general purpose card authorization

Narrative:
In order to check invalid icvv cvv2 prepaid emv retail general purpose card authorization
As an issuer
I want to authorize transactions for prepaid emv retail general purpose card

Meta:
@StoryName p_emv_retail_general
@oldReferenceSheet_S203707
@CRCardsWithAuthorizationCashAdvancedWithClearing

Scenario: Set up prepaid emv retail general purpose card
Meta:
@TestId TC398452
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card
And user sign out from customer portal

Scenario: prepaid emv retail general purpose card device production
Meta:
@TestId TC408068
Given user is logged in institution
When user creates new device of prepaid type for new client
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
Then device has "normal" status
Then user activates device through helpdesk
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
And user sign out from customer portal

Scenario: Pin Generation 
Meta:
@TestId 
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When user sets invalid cvv/ccv2/icvv to device
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Perform EMV_CASH_ADVANCE Authorization transaction on invalid ICVV 
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_CASH_ADVANCE MAS transaction
Then user is logged in institution
Then search Cash Advance authorization and verify 183-CVV Verification Failure status
Then assert Decline response with 46039 AuthDecline Code and Invalid CVV.. as description
Then user sign out from customer portal

Scenario: Perform ECOMM_PURCHASE Authorization transaction on invalid CVV2 
Meta:
@TestId 
When perform an ECOMM_PURCHASE MAS transaction on the same card
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 192-CVV2/CVC2/CVD2 Verification Failure status
Then assert Decline response with 46042 AuthDecline Code and Invalid CVV2 for E-Comm transaction. as description
Then user sign out from customer portal