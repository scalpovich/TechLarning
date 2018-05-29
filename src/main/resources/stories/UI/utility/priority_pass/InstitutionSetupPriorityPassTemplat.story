Narrative:
As an customer portal user
I want to configure the instititue with Priority Pass
so device can be created with priority pass feature enabled


Meta:
@InstituteSetUpPrepaid
@InstitutionSetUpForAllType

Scenario:Configire priority pass for given Institution 
Meta:
@institutePriority
@TCName Institution_priority_setup
@sheetName Priority_setup

Given login to portal as existing bank as a Customeruser
When user creates Template of type Priority Pass ID [P] and of length 16
And user sign out from customer portal