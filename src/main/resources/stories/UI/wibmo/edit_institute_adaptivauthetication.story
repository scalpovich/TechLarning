two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName editInstitutes
@InstitutionAndUserCreation
Scenario: enable two factor authentication at processing center

Meta:
@TCName TCEditInstitute
@testDataFileName testdata
@sheetName Institute
@edit_institute_wibmo
Given login to bank as a Bankadmin
When user edits institution to enable two factor authentication
Then two factor authentication options are configured

Scenario: disable two factor authentication at processing center

Meta:
@TCName TCEditInstitute
@testDataFileName testdata
@sheetName Institute
@edit_institute_wibmo
Given login to bank as a Bankadmin
When user edits institution to disable two factor authentication
Then two factor authentication options are configured

Scenario: validate audit functionality for institution
Meta:
@TCName TC_validate_Audit_Report
@testDataFileName testdata
@sheetName AuditReport
@edit_institute_AuditReport
Given login to portal as existing bank as a Customeruser
Then configuration changes should be audited in audit report
