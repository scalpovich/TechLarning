Clearing: create IPM file and upload it.

Narrative:
In order to provide to client easy-to-use multi-purpose card
As an issuer
I want to perform various transaction and perform Clearing

Meta:
@SimulatorSession MCPS

Scenario: Debit card clearing

Given Auth file is provided for <iteration>
When Auth file is loaded into MCPS and processed
And NOT file is successfully generated for iteration
And User uploads the NOT file
And user is logged in institution
And user processes batch for debit
Then in batch trace history transaction is successful
And transaction status is "Matching Pending"
And "Matching" batch for debit is successful
And "Pre-clearing" batch for debit is successful
And transaction status is "Presentment Matched with authorization"
And transaction fee is correctly posted

Examples:

| iteration  |
| Iteration1 |


Scenario: Prepaid card clearing

Given Auth file is provided for <iteration>
And user is logged in institution
When Auth file is loaded into MCPS and processed
And NOT file is successfully generated for iteration
And User uploads the NOT file
And user processes batch for prepaid
Then in batch trace history transaction is successful
And transaction status is "Matching Pending"
And "Matching" batch for prepaid is successful
And "Pre-clearing" batch for prepaid is successful
And "EOD-Prepaid" batch for prepaid is successful
And transaction status is "Presentment Matched with authorization"
And transaction fee is correctly posted
When "Statement" download batch is executed for prepaid 
Then file is successfully downloaded

Examples:

| iteration  |
| Iteration2 |