debit emv retail debit card authorization PINLESS

Narrative:
In order to check transactions on debit emv retail debit card pinless
As an issuer
I want to authorize transactions for debit emv retail debit card pinless

Meta:
@StoryName d_emv_retail
@SanityCardsPinlessWithAuthorization

Scenario: Transaction - EMV_PURCHASE Authorization transaction - prepaid emv corporate general purpose card
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify Successful status