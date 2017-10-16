Narrative:
As a(n) processor
I want to to see following transaction set in Transaction Registration Screen at the Processor Level:-
 a. Cash Withdrawal
 b. Balance inquiry
 c. Pin Change
 d. Mini Statement
 e. Mobile Number Update

Meta:
@all
@UI
@R6releaseAutomation


Scenario: RPY008 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Processor Level
Meta:
@Regression
@Smoke
@TC265498
@TCName TC265498_RPY008 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Processor Level
@sheetName S205000
Given login to existing bank as a Admin
When the admin user fetches the record
Then user should be able to see following transaction set in Transaction Registration Screen at the processor level:
|TransactionCode|
|Cash Withdrawal|
|Balance Inquiry|
|Pin Change|
|Mini Statement|
|Mobile Number Update|