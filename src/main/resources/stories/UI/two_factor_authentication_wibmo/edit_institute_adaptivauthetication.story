two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName editInstitutes
@InstitutionAndUserCreation
Scenario: validate two factor authentication at processing center

Meta:
@TCName TCEditInstitute
@testDataFileName testdata
@sheetName Institute
@edit_institute_wibmo
Given login to bank as a Bankadmin
When user edit institution and select ACS Vendor to enable authentication options
Then two factor authentication options are configured