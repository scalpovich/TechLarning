Prepiad: create retrival request for transactions for prepaid card holder transactions

Narrative:
In order to hadle dispute
As an Dispute officer
I want to handle the dispute for the transactions made my cardholder


Meta:
@StoryName PREPAID_RETRIVAL_REQUEST

Scenario:To Verify that a potential charge back report is raised and validate charge back creation Process
Given user is logged in institution

Scenario:To Verify that system is able to process incoming clearing files and process second Presentment
Given user is logged in institution

Scenario:To Verify that a potential charge back report and validate second charge back creation Process for mastercard device
Given user is logged in institution

Scenario:To Verify that the dispute officer is able to raise a first chareg back
Given user is logged in institution

Scenario:To Verify that the Dispute officer is able to raise 2nd charge back reversal
Given user is logged in institution

Scenario:To Verify that the System is able to process 2nd Presentment reversal
Given user is logged in institution

Scenario: To Verify that Dispute officer is able to raise arbitration case for transaction
Given user is logged in institution
When create arbitration for retrival requst

Scenario: To create chargeback request for transaction on device and verify in dispute history
Given user is logged in institution
!-- When Charge back is created for a transaction without fees
!-- Then verify for the status in dispute history

Scenario:To Verify that Dispute officer is able to cancel the fist chargebacks request
Given user is logged in institution
When Charge back is created for a transaction
When cancel first chargeback request

Scenario:To Verify that Dispute officer is able to cancel the second chargebacks request
Given user is logged in institution
!-- Cancel second chargeback requst
When cancel first chargeback request


Scenario: To create retrival request for transaction on prepaird mastercard card
Given user is logged in institution
!-- When a retrival request is created using ARN Number without fees
!-- When Charge back is created for a transaction
!-- When Download the IPM file
!-- When cancel first chargeback request


Scenario: To Verify that the dispute officer is able to raise a chareg back reversal
Given user is logged in institution
!-- When Charge back is created for a transaction
!-- When Charge back reversal is created for a transaction
!-- Then verify for the status in dispute history