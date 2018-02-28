prepaid MSR corporate gift card with PIN

Narrative:
In order to provide a corporate client various scenarios
As an issuer
I want to create a prepaid MSR corporate gift card and test various scenarios

Meta:
@StoryName p_msr_corp_gift
@AuthorizationRegression
@AuthorizationRegressionGroup2
@MSRWithPin

Scenario: Setup - prepaid MSR corporate gift card with PIN
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card
When user creates new device of prepaid type for new client
And user sign out from customer portal

Scenario: Device production - prepaid MSR corporate gift card with PIN
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When user has wallet number information for prepaid device
When user performs adjustment transaction with 10000 amount
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
When user activates device through helpdesk
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
When embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - INT_MSR_PREAUTH and INT_MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an INT_MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an INT_MSR_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE Authorization transaction
When perform an INT_MSR_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an INT_MSR_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_POS_BALANCE_INQUIRY Authorization transaction
When perform an INT_MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_REFUND Authorization transaction
When perform an INT_MSR_REFUND MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Refund authorization and verify 000-Successful status
And user sign out from customer portal

Scenario: Perform INT_MSR_CASH_ADVANCE Authorization transaction
Given user is logged in institution
When user updates cvccvv as uncheck on device plan
And user sign out from customer portal
When perform an INT_MSR_CASH_ADVANCE MAS transaction on the same card
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search Cash Advance authorization and verify 000-Successful status
And user sign out from customer portal