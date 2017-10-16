Narrative:
As a Customer portal user
I want to do the 'Financial transaction to Account Head' mapping for every transaction, at Institution level
so that it will be beneficial for me for posting against corresponding Account Heads in CBS 

Meta:
@all
@UI
@R6-Iteration-2
@F39613
@S205175
@AccountHeadMapping


Scenario: To check that the system should allow to add an Account Head Mapping
Meta:
@TCName TC01_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265400
@R6Regression
@Sanity
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Head Mapping screen
And user adds an Account Head Mapping
Then user should be able to add an account head mapping


Scenario: To check that the system should allow to add an Account Head Mapping for Card Fees transaction
Meta:
@TCName TC08_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265400-2
@R6Regression
@HeadMapping
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Head Mapping screen
And user adds an Account Head Mapping for Card Fee transactions
Then user should be able to add an account head mapping


Scenario: To check that the system should allow the user to map 'Card Fees Transaction' with corresponding 'Reason Code'
Meta:
@TCName TC02_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265445
@R6Regression
@HeadMapping
Given login to portal as existing bank as a user
When user navigates to Account Head Mapping screen
Then verify that the user is allowed to attach 'Reason Code' of respective 'Card Fees Transaction' during mapping


Scenario: To check that the system should provide 'Search' functionality for searching 'Transactions' and 'Host Account Head'
Meta:
@TCName TC03_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265484
@R6Regression
@HeadMapping
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Head Mapping screen
And user adds an Account Head Mapping
Then verify that the search functionality is working as expected


Scenario: To check that the system should not allow the user to map 'Transaction' with 'De-activated' account head
Meta:
@TCName TC04_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265486
@R6Regression
@HeadMapping
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user de-activates the account head
And user saves the deactivated account head
And user navigates to Account Head Mapping screen
Then verify that the system should not allow the user to map 'Transaction' with 'De-activated' account head


Scenario: To check that the system should show a 'Note' while mapping any 'Card Fees Transaction' on the screen
Meta:
@TCName TC06_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265488
@R6Regression
@HeadMapping
Given login to portal as existing bank as a user
When user navigates to Account Head Mapping screen
Then verify that system shows a 'Note' while mapping any 'Card Fees Transaction'


Scenario: To check that the system should not allow duplicate entry of mapping in the system
Meta:
@TCName TC07_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC268920
@R6Regression
@HeadMapping
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Head Mapping screen
And user adds a duplicate account head mapping into the system
Then verify that a proper validation message is shown if the user tries to enter duplicate account head mapping


Scenario: To check that the user can download the mapping in 'excel' format containing all the transaction & respective Host account mapping.
Meta:
@TCName TC07_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265485
Given login to portal as existing bank as a user
When user navigates to Account Head Mapping screen
And user downloads the mapping in excel format
Then verify that the excel file contains all the transaction & respective Host account mapping


Scenario: To check that 'Audit' functionality should be present for 'Transaction Mapping' screen
Meta:
@TCName TC05_AccountHeadMapping
@sheetName AccountHeadMapping_S205175
@TC265487
@R6Regression
Given login to portal as existing bank as a user
When user navigates to Account Head screen
And user adds account head in the system
And the user saves the Account Head for further use
And user navigates to Account Head Mapping screen
And user adds an Account Head Mapping
And user modifies a mapping on the Account Head Mapping page
Then verify that the audit functionality records for modification of record
