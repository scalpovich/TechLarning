Narrative:
As a(n)  Customer portal user 
I want to Following additional fields should be available as part of embossing file template configuration
So that Embossing files can be generated with additional parameters configured in embossing file template 

Meta:

@InstitutionCreation
@TCName TC1InstituteCreation
@sheetName Institute

Scenario: New Institution creation 
!--Given login to existing bank as a Admin
 
 
Given login to portal as existing bank as a Admin
When user navigates to Procession Center page
Then user should be able to create new Institution 
