debit msr corporate debit card withoutPin

Narrative:
In order to check transactions on debit magnetic stripe corporate debit card
As an issuer
I want to authorize transactions for debit magnetic stripe corporate debit card

Meta:
@StoryName d_msr_corp
@SanityCardsWithAuthorization
@MSRWithoutPinIntTrx
@InternationalTrx

Scenario: Set up program for debit magnetic stripe corporate debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction with 10000 amount
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit emv corporate debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal

Scenario: Transaction - INT_MSR_PREAUTH  and INT_MSR_COMPLETION Authorization transaction
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

Scenario: Perform INT_ECOMM_PURCHASE Authorization transaction
When perform an INT_ECOMM_PURCHASE MAS transaction on the same card
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
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
