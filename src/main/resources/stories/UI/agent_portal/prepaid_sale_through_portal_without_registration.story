Prepiad Sale Through Portal

Narrative:
In order to do prepaid card sale
As an Agent User
I want to fill sale related information through portal: Without registration

Meta:
@StoryName S193815
@sanitycards
@CR1

Scenario: Prepaid - Admin User - Assign Program to Agency
Meta:
@TestId TC406266
Given user is logged in institution
And bulk card generation for prepaid emv is completed
And user sign out from customer portal
And user is logged in agent portal as admin user
When user fills information to assign program to agency and submits form
Then program assigned to agency successfully
And user sign out from agent portal

Scenario: Prepaid - Admin User - Assign Program to Branch
Meta:
@TestId TC406267
Given user is logged in agent portal as admin user
When user fills information to assign program to branch and submits form
Then program assigned to branch successfully
And user sign out from agent portal

Scenario: Prepaid - Agent User - Assign Program to Agent
Meta:
@TestId TC406268
Given user is logged in agent portal as admin user
When user fills information to assign program to agent and submits form
Then program assigned to agent successfully
And user sign out from agent portal

Scenario: Prepaid - Agency User - Order Request
Meta:
@TestId TC406269
Given user is logged in agent portal as agency user
When user fills order details and submits the form
Then order is successful
And user sign out from agent portal

Scenario: Prepaid - Customer User - Dispatch
Meta:
@TestId TC406270
Given user is logged in institution
When user fills quantity to be dispatched and submits the form
Then dispatch is successful
And user sign out from customer portal

Scenario: Prepaid - Agency User - Order Acceptance
Meta:
@TestId TC406271
Given user is logged in agent portal as agency user
When user fills the order acceptance details and submits the form
Then order acceptance is successful
And user sign out from agent portal

Scenario: Prepaid - Agency User - Status
Meta:
@TestId TC406272
Given user is logged in agent portal as agency user
When user fills status details and submits the form
Then status column updates with type of order accepted
And user sign out from agent portal

Scenario: Prepaid - Agent User - Device Sale without Registration
Meta:
@TestId TC406273
Given user is logged in agent portal as agent user
When user fills program details without registration
Then application creation is successful
And user sign out from agent portal

Scenario: Prepaid - Customer User - Help Desk Status
Meta:
@TestId TC406274
Given user is logged in institution
When user fills General details with product prepaid and submits the form for notregistered device
Then status should be ready for sale
And delivery date is updated in general details
And user sign out from customer portal