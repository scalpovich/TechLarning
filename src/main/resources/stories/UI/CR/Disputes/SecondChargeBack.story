Scenario: Second Chargeback


Given user is logged in institution
When Get ARN number from database
And SecondCharge back is created for a transaction
And validate the SecondCharge back amount credited to the card holder in help desk screen
And Download the IPM file
And Generate outgoing IPM file and check for Message Reversal Indicator,Card Issuer Reference Data
Then verify for the status in dispute history