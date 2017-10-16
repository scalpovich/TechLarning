Narrative:
As a(n) customer portal user 
I want to to see following transaction set in Transaction Registration Screen at the Institution Level:-
 a. Cash Withdrawal
 b. Balance inquiry
 c. Pin Change
 d. Mini Statement
 e. Mobile Number Update
So that customer portal user is able to fetch and see all those transaction enabled for Rupay network on Transaction Registration Screen at Institution level.

Meta:
@ATMOnlineTransaction
@all
@UI
@R6releaseAutomation

Scenario:  ATM Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level 
Meta:
@Regression
@Smoke
@TC265543
@TCName TC265538_RPY009 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level_select and enable or disable transactions at institute level
@sheetName S205000
Given login to portal as existing bank as a user
When the customer portal user fetches the record
Then he should be able to select and enable or disable below transactions at the institution level for the rupay network:
|Transaction|
|Cash Withdrawal|
|Balance Inquiry|
|Pin Change|
|Mini Statement|
|Mobile Number Update|


Scenario:  ATM Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level 
Meta:
@Regression
@Smoke
@TC265538
@TCName TC265538_RPY009 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level_select and enable or disable transactions at institute level
@sheetName S205000
Given login to portal as existing bank as a user
When the customer portal user fetches the record
Then he should be able to select and see all the transactions supported for rupay network
