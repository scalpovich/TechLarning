prepaid msr retail general purpose card authorization

Narrative:
In order to check transactions on prepaid msr retail travel card 
As an issuer
I want to authorize transactions for prepaid msr retail travel card 

Meta:
@StoryName p_msr_retail_travel
@AuthorizationRegression
@AuthorizationRegressionGroup1

Scenario: Set up prepaid msr retail travel card
Meta:
@TestId TC398484
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status

Scenario: prepaid msr retail travel card device production
Meta:
@TestId TC398484
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
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

Scenario: Perform MSR_CASH_WITHDRAWAL Authorization transaction
Meta:
@TestId 
When perform an MSR_CASH_WITHDRAWAL MAS transaction
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
When MAS simulator is closed

Scenario: Program Balance Summary, Auth and Clearing reports download
Meta:
@TestId 
When pre-clearing and Pre-EOD batches are run
Then verify report for transactions with Program Balance Summary is downloaded
And Verify Program Balance Summary is downloaded
And verify report for Auth is downloaded
And verify report for Clearing is downloaded
When user sign out from customer portal