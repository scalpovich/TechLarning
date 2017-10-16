Narrative: afslkfj
As a API User
I want to do all Transactions for a Device


Meta:
@storyType API
@Transaction
@CentaurusAPI

Scenario: Login Request
Meta:
@Login
@Now
Given I have a valid web service request loginRequest.xml
When I update login xml for below tags: 
|tags|value |
|componentId|NA|
|componentAuthKey|NA|
|userId|NA|
|password|NA|
|ip|NA|
|bankCode|NA|
And I send the request
And I need to save sessionKey for future steps
Then I check response for below tags: 
|tag|value | 
|responseCode|0|
|errorDesc|SUCCESSFUL: LOGON|


Scenario: Api Initial Load Transactions
Meta:
@InitialLoad
Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|rrn|NA|
|transactionCode|Initial Load|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|100|
|formFactor|x|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|


Scenario: Api Transfer Credit Transactions
Meta:
@TransferCredit
Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|rrn|NA|
|transactionCode|Transfer Credit|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|25|
|formFactor|x|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|


Scenario: Api Transfer Debit Transactions
Meta:
@TransferDebit
Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|rrn|NA|
|transactionCode|Transfer Debit|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|15|
|formFactor|x|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|


Scenario: Api Cash Advance/Cash Out Transactions
Meta:
@CashAdvance_Cash Out

Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|rrn|NA|
|transactionCode|Cash Advance/Cash Out|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|10|
|formFactor|x|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|


Scenario: Api Reload Transactions
Meta:
@Reload
@Now
Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|rrn|NA|
|transactionCode|Reload|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|1000|
|formFactor|x|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|

Scenario: Api Purchase Transactions
Meta:
@Purchase
Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|rrn|NA|
|transactionCode|Purchase|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|9|
|formFactor|x|
And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|

Scenario: Api Reversal Void Transactions for Purchase
Meta:
@pending
@ReversalVoid
Given I have a valid web service request APITransactions.xml
When I update xml for below tags: 
|tags|value |
|sessionKey|NA|
|transactionType|R|
|rrn|previous|
|transactionCode|Purchase|
|transactionDateTime|NA|
|txnCurrency|144|
|billingCurrency|144|
|txnamount|9|
|formFactor|x|
|traceAuditNumber|new|
|originalTraceAuditNumber|previous|
|dateTimeTransmission|new|
|originalDateTimeTransmission|previous|

And I send the request
Then I check response for below tags: 
|tags|value | 
|responseCode|0|
|errorDesc|Successful|
