Narrative:
As a(n) customer portal user 
I want to to see following transaction set in Transaction Registration Screen at the Processor Level:-
 a. Purchase
 b. E-Commerce Transaction (It is also a purchase transaction only, so for this e-commerce channel needs to be enabled)
So that customer portal user is able to fetch and see all those transaction enabled for Rupay network on Transaction Registration Screen at processor level.

Meta:
@all
@UI
@R6releaseAutomation

Scenario:RPY045 -- POS Online Transaction Set in SMS Mode -- Transaction Registration at Processor Level 
Meta:
@Regression
@Smoke
@TC264258
@TCName TC265498_RPY008 -- ATM Online Transaction Set in SMS Mode -- Transaction Registration at Processor Level
@sheetName S205000
Given login to existing bank as a Admin
When the admin user fetches the record
Then user should be able to see following transaction set in Transaction Registration Screen at the processor level:
|Transaction|
|Purchase/Auth Completion|

