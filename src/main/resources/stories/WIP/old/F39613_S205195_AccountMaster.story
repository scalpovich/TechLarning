Narrative:
As a Customer portal user
I want  Program to be made as non-mandatory on Account Master
so that default host account can be configured for all debit programs of the interchange associated to the institution.

Meta:
@all
@UI
@R6-Iteration-2
@F39613
@S205195
@AccountMaster


Scenario: To verify that Program field should be a non-mandatory field on Account Master screen
Meta:
@TCName TC01_AccountMaster
@sheetName AccountMaster_S205195
@TC262495
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Master screen
And user creates a new account master without Program Code
Then verify that the program field is non mandatory field on the Account Master page


Scenario: To verify that the already existing Debit Program Codes are available under Program drop-down on the Account Master page
Meta:
@TCName TC02_AccountMaster
@sheetName AccountMaster_S205195
@TC262496
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Master screen
Then verify that the already existing Debit Program Codes are available under Program drop-down on Account Master screen


Scenario: To verify that the system should save the configuration with Program Code selected on the Account Master screen 
Meta:
@TCName TC03_AccountMaster
@sheetName AccountMaster_S205195
@TC262498
@Regression
@R6Regression
@Sanity
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Master screen
And user creates a new account master with Program Code
Then the system should save the Account Master


Scenario: To verify that the system should save the configuration without Program Code selected on the Account Master screen
Meta:
@TCName TC04_AccountMaster
@sheetName AccountMaster_S205195
@TC262498-2
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Master screen
And user creates a new account master without Program Code
Then the system should save the Account Master


Scenario: To verify that the system should not allow the user to enter duplicate configuration through Account Master screen
Meta:
@TCName TC05_AccountMaster
@sheetName AccountMaster_S205195 
@TC262541
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Master screen
And user creates the same account master again
Then verify that the system throws an appropriate error message on adding a duplicate account master