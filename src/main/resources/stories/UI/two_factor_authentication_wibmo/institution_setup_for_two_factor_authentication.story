two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName S190640
@institutionSetup

Scenario: validate two factor authentication at processing center
Meta:
@TestId TC398332

Given user is logged in customer portal as admin user in processing institution
When user edit 121212 institution configuration and select WIBMO [002] ACS Vendor
Given user is logged in customer portal as admin user in processing institution
Then two factor authentication fields are enabled
