two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName two_factor_authentication
@visafeecollection_transaction

Scenario: validate two factor authentication at processing center
Given user is logged in customer portal as admin user in processing institution
When user edit institution and select ACS Vendor to enable authentication options
Then two factor authentication options are configured
