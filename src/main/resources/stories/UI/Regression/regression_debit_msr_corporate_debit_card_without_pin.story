debit msr corporate debit card withoutPin

Narrative:
In order to check transactions on debit emv retail card
As an issuer
I want to authorize transactions for debit emv retail debit card

Meta:
@StoryName d_msr_corp
@SanityCardsWithAuthorization

Scenario: Set up program for debit emv retail debit card
Meta:
@TestId TC398366
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device

Scenario: debit emv retail debit card device production
Meta:
@TestId TC408068
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
When processes pin generation batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format

Scenario: Perform EMV_POS_BALANCE_INQUIRY Authorization transaction
Meta:
@TestId 
Given connection to MAS is established
When perform an EMV_POS_BALANCE_INQUIRY MAS transaction
Then MAS test results are verified

Scenario: Perform MSR_REFUND Authorization transaction
Given connection to MAS is established
When perform an MSR_REFUND MAS transaction
Then MAS test results are verified

Scenario: Transaction - EMV_PREAUTH  and EMV_COMPLETION Authorization transaction - prepaid emv corporate general purpose card
When perform an EMV_PREAUTH MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
When perform an EMV_COMPLETION MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Pre-Auth Completion authorization and verify 000-Successful status


When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal