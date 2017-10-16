Narrative:
As a user
I want to generate embossed file for my prepaid card




Meta:
@embossingFile


Scenario: A scenario is a collection of executable steps of different type

Given login to existing bank as a Customerportaluser
When creates a new prepaid device
And user process the pre-production and device generation batch
Then embossing file should be generated in specified location