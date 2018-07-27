Narrative:
In order to check purcase transactions on prepaid EMV corporate card
As an issuer
I want to authorize transactions with devie promotion plan


Scenario:Create prepaid EMV card
Given user is logged in institution
When device range for program with device plan for "prepaid" "msr" card
And user creates new device of prepaid type for new client
Then device has "normal" status
And user performs adjustment transaction

Scenario:Perform Purchase transaction with existing device Plan and verify the transaction
Given connection to MAS is established
And perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:Perform purcase transaction with device promotion plan
Given connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Account Status authorization and verify 000-Successful status
And user sign out from customer portal