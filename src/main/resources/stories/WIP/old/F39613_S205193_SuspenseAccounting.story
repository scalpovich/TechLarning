Narrative:
As a Customer Portal User
I want Suspense account to be configured through Account Master Screen
so that host accounting file can be created with contra entry leg for which host accounting configuration is missing

Meta:
@all
@UI
@R6-Iteration-2
@F39613
@S205193
@SuspenseAccounting

Scenario: To check that the user can edit 'Suspense Account head'
Meta:
@TCName TC01_SuspenseAccount
@sheetName SuspenseAccount_S205193
@TC265728
@R6Regression

Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user searches for the Suspense Account on Account Head screen
Then system should allow the user to edit Suspense Account head

Scenario: To check that the user cannot configure 'Program' and 'Interchange' for Suspense Account
Meta:
@TCName TC02_SuspenseAccount
@sheetName SuspenseAccount_S205193
@R6Regression
@TC265728-2
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user searches for the Suspense Account on Account Master screen
Then system does not allow to edit 'Program' and 'Interchange' for Suspense Account

Scenario: To check that the system should show the 'Suspense Account' on 'Account Master' screen
Meta:
@TCName TC01_SuspenseAccount
@sheetName SuspenseAccount_S205193 
@TC273607
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user searches for the Suspense Account on Account Master screen
Then verify that the Suspense account is shown on the Account Master page

Scenario: To check that the system should not show the 'Suspense Account' on 'Account Head Mapping' screen
Meta:
@TCName TC01_SuspenseAccount
@sheetName SuspenseAccount_S205193
@TC273608
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user searches for the Suspense Account on Account Head Mapping screen
Then verify that the Suspense account is not shown on the Account Head Mapping page

Scenario: To check that the system should not allow the user to change the status of 'Suspense Account' from 'Active' to 'Inactive'
Meta:
@TCName TC01_SuspenseAccount
@sheetName SuspenseAccount_S205193
@R6Regression
@TC275006
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user searches for the Suspense Account on Account Head screen
Then verify that the Suspense account cannot be deactivated

