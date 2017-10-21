Debit EMV Card And Authrization

Narrative:
In order to provide to client easy-to-use multi-purpose debit card
As an issuer
I want to create an magnetic stripe debit card and perform various transaction

Meta:
@StoryName debit_emv
@SanityTest
@Authorisation

Scenario: 01 Set up retail emv debit card and perform purchase transaction and perform Clearing
Meta:
@TestId TC406733
Given user is logged in institution
And device range for program with device plan for "debit" "emv" card without pin
When user creates new device of debit type for new client
When a new device was created
When user processes pre-production batch for debit
When user processes device production batch for debit
When user processes pin generation batch for debit
When user has wallet number information for debit device
When user performs adjustment transaction
When user has current wallet balance amount information for debit device
When embossing file batch was generated in correct format
When Pin Offset file batch was generated successfully
When connection to FINSim is established
When PIN is retrieved successfully with data from Pin Offset File
When FINSim simulator is closed
When connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
When Auth file is generated from MAS
When MAS simulator is closed