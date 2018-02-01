Institution Creation

Narrative:
In order to create institution
As a user
I want to create prerequisites in customer portal and agent portal

Meta:
@StoryName S190640
@institutionSetup

Scenario: creating new institution in customer portal as admin user
Meta:
@TestId TC398332

Given user is logged in customer portal as admin user in processing institution
When user edit 121212 institution configuration and select WIBMO [002] ACS Vendor
Given user is logged in customer portal as admin user in processing institution
Then two factor authentication fields are enabled
