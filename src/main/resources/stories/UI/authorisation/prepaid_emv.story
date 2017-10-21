Magnetic Strip Prepaid Card Authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an emv prepaid card and perform various transaction

Meta:
@StoryName prepaid_emv
@SanityTest
@Authorisation

Scenario: Set up retail emv prepaid card and perform purchase transaction
Meta:
@TestId TC406660

Given connection to FINSim is established
When user is logged in institution
And prepaid emv device is available with balance amount
And user has current wallet balance amount information for prepaid device
And user sign out from customer portal
And data in embossing file and pin offset file are generated successfully and PIN is retrieved successfully
When connection to FINSim is established
When PIN is retrieved successfully with data from Pin Offset File
When FINSim simulator is closed
When connection to MAS is established
When perform an MSR_PURCHASE MAS transaction
Then MAS test results are verified
When Auth file is generated from MAS
And user is logged in institution
And after transaction wallet balance amount for prepaid device is updated correctly