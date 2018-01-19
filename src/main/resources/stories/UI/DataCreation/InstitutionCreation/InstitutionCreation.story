Institution and user creation story

Narrative:
As a(n)  Customer portal user 
I want to Create Automation Scripts
So that I can automate New Users and Institution Creation. 

Meta:
@UI
@all
@StoryName InstitutionAndUserCreation
@InstitutionAndUserCreation

Scenario:1 New Institution creation prepaid

Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
@PrepaidInstitutionCreation

Given login to bank as a Bankadmin
When user enter details to create new Prepaid Institution
Then user should be able to create new institute

Scenario:2 New user creation prepaid
Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
@PrepaidUserCreation

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal


Scenario:3 New Institution creation Debit

Meta:
@TCName TCInstituteCreationDC
@testDataFileName testdata
@sheetName Institute
@DebitInstitutionCreation

Given login to bank as a Bankadmin
When user enter details to create new Debit Institution
Then user should be able to create new institute

Scenario:4 New user creation prepaid
Meta:
@TCName TCInstituteCreationPR
@testDataFileName testdata
@sheetName Institute
@DebitUserCreation

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal

Scenario:5 New Institution creation Credit

Meta:
@TCName TCInstituteCreationCR
@testDataFileName testdata
@sheetName Institute
@CreditInstitutionCreation

Given login to bank as a Bankadmin
When user enter details to create new Credit Institution
Then user should be able to create new institute

Scenario:6 New user creation credit
Meta:
@TCName TCInstituteCreationCR
@testDataFileName testdata
@sheetName Institute
@CreditUserCreation

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal

Scenario:7 New Institution creation Debit Prepaid

Meta:
@TCName TCInstituteCreationDCPR
@testDataFileName testdata
@sheetName Institute
@DebitPrepaidInstitutionCreation

Given login to bank as a Bankadmin
When user enter details to create new Debit-Prepaid Institution
Then user should be able to create new institute

Scenario:8 New user creation Debit Prepaid
Meta:
@TCName TCInstituteCreationDCPR
@testDataFileName testdata
@sheetName Institute
@DebitPrepaidUserCreation

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal

Scenario:9 New Institution creation Credit Prepaid

Meta:
@TCName TCInstituteCreationPRCR
@testDataFileName testdata
@sheetName Institute
@CreditPrepaidInstitutionCreation

Given login to bank as a Bankadmin
When user enter details to create new Credit-Prepaid Institution
Then user should be able to create new institute

Scenario:10 New user creation Credit Prepaid
Meta:
@TCName TCInstituteCreationPRCR
@testDataFileName testdata
@sheetName Institute
@CreditPrepaidUserCreation

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal

Scenario:11 New Institution creation Credit Debit

Meta:
@TCName TCInstituteCreationDTCR
@testDataFileName testdata
@sheetName Institute
@CreditDebitInstitutionCreation

Given login to bank as a Bankadmin
When user enter details to create new Credit-Debit Institution
Then user should be able to create new institute

Scenario:12 New user creation Debit Credit
Meta:
@TCName TCInstituteCreationDTCR
@testDataFileName testdata
@sheetName Institute
@CreditDebitUserCreation

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal

Scenario:13 New Institution creation All Prepaid Credit Debit

Meta:
@TCName TCInstituteCreationAll
@testDataFileName testdata
@sheetName Institute
@InstitutionCreationWithAll

Given login to bank as a Bankadmin
When user enter details to create new ALL Institution
Then user should be able to create new institute


Scenario:14 New user creation Prepaid Debit Credit
Meta:
@TCName TCInstituteCreationAll
@testDataFileName testdata
@sheetName Institute
@UserCreationWithAll

Given login to bank as a Bankadmin
When user enter details to create new user
Then user should be able to create new user
And user sign out from customer portal



