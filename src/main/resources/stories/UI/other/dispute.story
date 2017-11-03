dispute

Narrative:
In order to process dispute
As a user
I want to run dispute life cycle

Meta:
@StoryName S197395

Scenario: Charge back reversal
Meta:
@TestId TC407488
Given user is logged in institution
When Not file is modified
And NOT file is uploaded after modification
And matching batch is executed
When Get ARN number from database
And a retrival request is created using ARN Number
And Downlod the IPM file
And Charge back is created for a transaction
And Generate outgoing IPM file and check for Message Reversal Indicator,Card Issuer Reference Data
And Charge back reversal is created for a transaction
Then verify for the status in dispute history
