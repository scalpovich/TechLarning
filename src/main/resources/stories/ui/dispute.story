dispute

Narrative:
In order to process dispute
As a user
I want to run dispute life cycle

Meta:
@StoryName S197395
@SmokeTest

Scenario: creating prerequisites for institution

Given user is logged in institution
When Get ARN number from database
And a retrival request is created using ARN Number
And Downlod the IPM file
And Charge back is created for a transaction
And Generate outgoing IPM file and check for Message Reversal Indicator,Card Issuer Reference Data
And Charge back reversal is created for a transaction
Then verify for the status in dispute history

Scenario: First Chargeback & chargeback reversal Posting based on auto post parameters
Given user is logged in institution
When Get ARN number from database
And Charge back is created for a transaction
And validate the charge back amount credited to the card holder in help desk screen
And Downlod the IPM file
And Generate outgoing IPM file and check for Message Reversal Indicator,Card Issuer Reference Data
Then verify for the status in dispute history

Scenario: Representment & reversal Processing & Posting based on auto post parameters

Given user is logged in institution
When Get ARN number from database
And a retrival request is created using ARN Number
And Charge back is created for a transaction
And Downlod the IPM file
And Upload a representment with the reason code
Then verify for the status in dispute history