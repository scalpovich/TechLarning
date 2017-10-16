Narrative:
As a Customer portal user
I want label change and removal of some fields in Account Master screen 
so that it is easier for me to understand the label and unnecessary data will not be entered by me

Meta:
@all
@UI
@R6-Iteration-2
@F39613
@S205187
@ChangeInAccountMaster
@sheetName AccountMaster_S205195 

Scenario: To verify that the field 'Transaction Type' label should be changed to 'Account Head' on 'Account Master' screen
Meta: 
@Regression
@TCName TC05_AccountMaster
@TC262593
@R6Regression
@Sanity
Given login to portal as existing bank as a user
When user navigates to Account Master screen
Then verify that the label Transaction Type should be changed to Account Head
