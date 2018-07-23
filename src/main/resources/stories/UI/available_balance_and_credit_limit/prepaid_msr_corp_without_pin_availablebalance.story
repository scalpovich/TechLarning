Narrative:
In order to check available balance
As an issuer
I want to validate available balance functionality

Meta:
@StoryName p_msr_corp_travel
@AvailableBalanceForPrepaid
@AvailableBalance

Scenario: Set up prepaid msr corporate travel card
Given user is logged in institution
When device range for program with device plan for "prepaid" "magnetic stripe" card without pin
And user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario: prepaid msr corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And device has "normal" status
And user has wallet number information for prepaid device
And user sign out from customer portal
And user is logged in institution
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH  and MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
And MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
And perform an MSR_COMPLETION MAS transaction
And MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
When perform an MSR_PURCHASE MAS transaction on the same card
And MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction on the same card
And MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
And MAS test results are verified
And user is logged in institution
And search Balance Inquiry authorization and verify 000-Successful status
And user verifies available balance after transaction
Then user sign out from customer portal