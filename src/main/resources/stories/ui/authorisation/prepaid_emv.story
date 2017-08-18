Magnetic Strip Prepaid Card Authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName prepaid_msr
@SmokeTest

Scenario: Set up retail magnetic stripe prepaid card and perform purchase transaction

Given user is logged in institution
And prepaid static virtual device is available with balance amount
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