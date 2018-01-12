prepaid msr retail gift card pinless authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card pinless
As an issuer
I want to create an magnetic stripe prepaid card pinless and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift
@oldReferenceSheet_prepaid_msr
@AuthorizationRegression
@AuthorizationRegressionGroup3

Scenario: Set up prepaid msr retail gift card authorization pinless
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid msr retail gift card authorization pinless device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH and MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify Success status
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
And search Pre-Auth Completion authorization and verify Success status

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction
Meta:
@TestId 
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction
Then MAS test results are verified
And search Purchase authorization and verify success status

Scenario: Perform MSR_CASH_ADVANCE Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_ADVANCE MAS transaction
Then MAS test results are verified
Then search Cash Advance authorization and verify 000-Successful status

Scenario: Perform MSR_PURCHASE_WITH_REFUND Authorization transaction
Meta:
@TestId 
When perform an MSR_PURCHASE_WITH_REFUND MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified

Scenario: Perform ECOMM_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_PURCHASE Authorization transaction
Meta:
@TestId 
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
And search Purchase authorization and verify success status