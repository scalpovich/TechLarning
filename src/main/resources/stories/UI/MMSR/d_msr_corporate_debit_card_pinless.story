debit msr corporate debit card withoutPin

Narrative:
In order to check transactions on debit emv retail card
As an issuer
I want to authorize transactions for debit emv retail debit card

Meta:
@StoryName d_msr_corp
@MSRWithoutPin
@MMSR

Scenario: Set up program for debit emv retail debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
And user sign out from customer portal

Scenario: debit msr retail debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
And user sign out from customer portal


Scenario: Perform MMSR-CORPORATE_DEBITCARD Authorization transaction
Given connection to MAS is established
When perform an MMSR MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search MasterCard MoneySend authorization and verify 000-Successful status
And user sign out from customer portal