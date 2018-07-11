Narrative:
In order to check available balance
As an issuer
I want to validate available balance functionality

Meta:
@StoryName d_msr_corp
@AvailableBalanceForDebit
@AvailableBalance

Scenario: Setup - debit msr corp debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then user sign out from customer portal

Scenario: Device production - debit msr corp debit card
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
Then device has "normal" status
When user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: Transaction - MSR_PREAUTH  and MSR_COMPLETION Authorization transaction
Given connection to MAS is established
When perform an MSR_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And user sign out from customer portal
When perform an MSR_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status
Then user verify available balance after transaction
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE Authorization transaction
When perform an MSR_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
Then user verify available balance after transaction
And user sign out from customer portal

Scenario: Perform MSR_PURCHASE_WITH_CASHBACK Authorization transaction
When perform an MSR_PURCHASE_WITH_CASHBACK MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Purchase with Cash back authorization and verify 000-Successful status
Then user verify available balance after transaction
And user sign out from customer portal

Scenario: Perform MSR_POS_BALANCE_INQUIRY Authorization transaction
When perform an MSR_POS_BALANCE_INQUIRY MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
Then user verify available balance after transaction
And user sign out from customer portal