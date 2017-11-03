Institution Creation

Narrative:
In order to create institution
As a user
I want to create prerequisites in customer portal and agent portal

Meta:
@StoryName S190640
@SanityInstitutionSetup
@FullSanity

Scenario: creating new institution in customer portal as admin user
Meta:
@TestId TC398332

Given user is logged in customer portal as admin user in processing institution
When create new institution
And check for new Institution status
!-- And create prerequisites device and network keys
When user is logged in agent portal as admin user
And user creates new agency
And user creates new branch
And user creates new agent
And user creates new agency user
And user creates new branch user
And user creates new agent user

When user is logged in institution
And user creates new business calendar
And user creates new holiday configuration
And user creates new cutover profile
And user creates new network membership
And user creates new institute currency
And user creates new office
And user creates new plastic code
And user creates new picture code
And user creates new device bin
And user creates new issuer public key
!-- And user enables transaction registration
And user adds the vendor masters
And user adds embossing pin Priority pass file names
And user adds embossing pin priority pass file template
!-- need to create a courieer agency from Distribution --> SetUp --> Courier Master
!-- create user Auto001 for Institutiojn.. create and add permissions
!-- add zip code (location parameters screen)
!-- add roles and assign permissions (Agent Portal)
!-- Created user should be assigned permissions for institution
!-- And user creates new corportate user  - nOT DONE YET
!-- Change data style for And user adds the vendor masters in Institution creation story 
