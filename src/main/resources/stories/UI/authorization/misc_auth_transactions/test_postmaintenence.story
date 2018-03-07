prepaid msr retail gift card pinless authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card pinless
As an issuer
I want to create an magnetic stripe prepaid card pinless and perform various transaction

Meta:
@StoryName test_post_maintenence1

Scenario: Prepaid - Admin User - Assign Program to Agency

Given user is logged in institution
And bulk card generation for prepaid emv is completed
And user sign out from customer portal
And user is logged in agent portal as admin user
When user fills information to assign program to agency and submits form
Then program assigned to agency successfully
And user sign out from agent portal

Scenario: Prepaid - Admin User - Assign Program to Branch

Given user is logged in agent portal as admin user
When user fills information to assign program to branch and submits form
Then program assigned to branch successfully
And user sign out from agent portal

Scenario: Prepaid - Agent User - Assign Program to Agent

Given user is logged in agent portal as admin user
When user fills information to assign program to agent and submits form
Then program assigned to agent successfully
And user sign out from agent portal

Scenario: Prepaid - Load Balance Request - Funded Agent

Given user is logged in agent portal as agent user
When user performs load balance request
Then load balance request is successful
And user sign out from agent portal

Scenario: Prepaid - Approve the Load Request - Funded Agent
Given user is logged in institution
When user has wallet balance information for prepaid device
And user sign out from customer portal
And user is logged in agent portal as agent user
And user performs load balance approve
Then load balance approve is successful
And user sign out from agent portal
And user is logged in institution
And balance in helpdesk updated correctly for prepaid device
And user sign out from customer portal


Scenario: Post maintenance batch and pre-clearing batch is run
Meta:
@TestId 
Given user is logged in institution
When post maintenence batch is run
And user sign out from customer portal
Then "Pre-clearing" batch for prepaid is successful