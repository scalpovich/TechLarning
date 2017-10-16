Narrative:
As a Customer portal user
I want various account heads to be made configurable
so that in case of any additional account head needs to be added by the Institution it will be easy for me

Meta:
@all
@UI
@R6-Iteration-2
@F39613
@S205168
@AccountHead

Scenario: To verify that the user should be able to configure different account heads in the system
Meta:
@TCName TC01_AccountHead
@sheetName AccountHead_S205168
@TC265224
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
Then verify that user is able to configure account head

Scenario: To verify that de-activated heads should not be available for transaction mapping
Meta:
@TCName TC02_AccountHead
@sheetName AccountHead_S205168
@R6Regression
@TC265264
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And user de-activates the account head
Then verify de-activated head should not be available for transaction mapping

Scenario: To verify that an appropriate error message is seen for adding an duplicate entry into the system
Meta:
@DuplicateEntry
@TCName TC03_AccountHead
@sheetName AccountHead_S205168
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user creates a duplicate entry of the Account Head
Then verify that an appropriate error message is seen on the screen



