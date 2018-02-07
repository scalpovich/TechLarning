two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName S190640
@institutionSetup

Scenario: validate two factor authentication at processing center
Given user is logged in customer portal as admin user in processing institution
When user edit 121212 institution and select WIBMO [002] ACS Vendor to enable authentication options
Then two factor authentication options are configured