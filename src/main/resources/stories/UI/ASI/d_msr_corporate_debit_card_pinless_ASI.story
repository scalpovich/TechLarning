debit msr corporate debit card withoutPin

Narrative:
In order to check transactions on debit MSR Corporate card
As an issuer
I want to authorize transactions for debit MSR Corporate debit card

Meta:
@StoryName d_msr_corp_ASI
@MMSR
@nitin_summarised

Scenario: Set up program for debit emv corporate debit card
Given user is logged in institution
And device range for program with device plan for "debit" "magnetic stripe" card without pin
When user creates new device of debit type for new client
Then device has "normal" status
And user sign out from customer portal

Scenario: debit msr corporate debit card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for debit
When processes device production batch for debit
Then device has "normal" status
Then user activates device through helpdesk
And user sign out from customer portal
Then embossing file batch was generated in correct format

Scenario: Perform MMSR-CORPORATE_DEBITCARD Authorization transaction
Given connection to MAS is established
When perform an ASI_MSR_DEBIT MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal