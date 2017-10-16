Narrative:
As a(n) customer portal user 
I want to  to see following transaction set in Transaction Registration Screen at the Institution Level:-
 a. Purchase
 b. E-Commerce Transaction (It is also a purchase transaction only, so for this e-commerce channel needs to be enabled) 
So that customer portal user is able to fetch and see all those transaction enabled for Rupay network on Transaction Registration Screen at Institution level.

Meta:
@POSOnlineTransaction
@all
@UI
@R6releaseAutomation

Scenario:RPY045 -- POS Online Transaction Set in SMS Mode -- Transaction Registration at Processor Level 
Meta:
@Regression
@Smoke
@TC264253
@TCName TC265538_RPY009 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level_select and enable or disable transactions at institute level
@sheetName S205000
Given login to existing bank as a user
When the customer portal user fetches the record
Then he should be able to select and enable or disable below transactions at the institution level for the rupay network:
|Transaction|
|Purchase/Auth Completion|

Scenario:RPY045 -- POS Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level
Meta:
@Regression
@Smoke
@TC264255
@TCName TC265538_RPY009 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Institution Level_select and enable or disable transactions at institute level
@sheetName S205000
Given login to existing bank as a user
When the customer portal user fetches the record
Then he should be able to select and see all the transactions supported for rupay network
