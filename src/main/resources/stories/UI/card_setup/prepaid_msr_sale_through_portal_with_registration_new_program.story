Prepiad Sale Through Portal

Narrative:
In order to do prepaid card sale
As an Agent User
I want to fill sale related information through portal: new program with registration

Meta:
@StoryName S193816
@SanityCards

Scenario: Prepaid - Admin User - Assign Program to Agency
Meta:
@TestId TC406247
Given user is logged in institution
And bulk card generation for prepaid magnetic stripe is completed
And user sign out from customer portal
And user is logged in agent portal as admin user
When user fills information to assign program to agency and submits form
Then program assigned to agency successfully
And user sign out from agent portal

Scenario: Prepaid - Admin User - Assign Program to Branch
Meta:
@TestId TC406250
Given user is logged in agent portal as admin user
When user fills information to assign program to branch and submits form
Then program assigned to branch successfully
And user sign out from agent portal

Scenario: Prepaid - Agent User - Assign Program to Agent
Meta:
@TestId TC406252
Given user is logged in agent portal as admin user
When user fills information to assign program to agent and submits form
Then program assigned to agent successfully
And user sign out from agent portal

Scenario: Prepaid - Agency User - Order Request
Meta:
@TestId TC406253
Given user is logged in agent portal as agency user
When user fills order details and submits the form
Then order is successful
And user sign out from agent portal

Scenario: Prepaid - Customer User - Dispatch
Meta:
@TestId TC406255
Given user is logged in institution
When user fills quantity to be dispatched and submits the form
Then dispatch is successful
And user sign out from customer portal

Scenario: Prepaid - Agency User - Order Acceptance
Meta:
@TestId TC406256
Given user is logged in agent portal as agency user
When user fills the order acceptance details and submits the form
Then order acceptance is successful
And user sign out from agent portal

Scenario: Prepaid - Agency User - Status
Meta:
@TestId TC406258
Given user is logged in agent portal as agency user
When user fills status details and submits the form
Then status column updates with type of order accepted
And user sign out from agent portal

Scenario: Prepaid - Agent User - Device Sale with Registration
Meta:
@TestId TC406210
Given user is logged in agent portal as agent user
When user fills program details with registration
Then registration is successful
And user sign out from agent portal

Scenario: Prepaid - Agent User - Application Approval
Meta:
@TestId TC406261
Given user is logged in agent portal as agent user
When user fills card sale checker details and submits the form
Then approval is successful
And user sign out from agent portal

Scenario: Prepaid - Customer User - Help Desk Status
Meta:
@TestId TC406262
Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
Then status should be normal
And sale date is updated in general details
And user sign out from customer portal

Scenario: Prepaid - Customer User - Help Desk Activate Device
Meta:
@TestId TC406263
Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
And user activates device through helpdesk
Then activation of registered device prepaid is successful and activation date is updated
And user sign out from customer portal

Scenario: Prepaid - New Program to Existing Device - Admin User - Assign Program to Agency 
Meta:
@TestId TC406247
Given user is logged in institution
And bulk card generation for prepaid magnetic stripe is completed
And user sign out from customer portal
And user is logged in agent portal as admin user
When user fills information to assign program to agency and submits form
Then program assigned to agency successfully
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Admin User - Assign Program to Branch
Meta:
@TestId TC406250
Given user is logged in agent portal as admin user
When user fills information to assign program to branch and submits form
Then program assigned to branch successfully
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Agent User - Assign Program to Agent
Meta:
@TestId TC406252
Given user is logged in agent portal as admin user
When user fills information to assign program to agent and submits form
Then program assigned to agent successfully
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Agency User - Order Request
Meta:
@TestId TC406253
Given user is logged in agent portal as agency user
When user fills order details and submits the form
Then order is successful
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Customer User - Dispatch
Meta:
@TestId TC406255
Given user is logged in institution
When user fills quantity to be dispatched and submits the form
Then dispatch is successful
And user sign out from customer portal

Scenario: Prepaid - New Program to Existing Device - Agency User - Order Acceptance
Meta:
@TestId TC406256
Given user is logged in agent portal as agency user
When user fills the order acceptance details and submits the form
Then order acceptance is successful
And user sign out from agent portal

Scenario: Prepaid -  New Program to Existing Device - Agency User - Status
Meta:
@TestId TC406258
Given user is logged in agent portal as agency user
When user fills status details and submits the form
Then status column updates with type of order accepted
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Agent User - Device Sale with new program Registration
Meta:
@TestId TC406259
Given user is logged in agent portal as agent user
When user fills program details with new program for prepaid product magnetic stripe device
Then registration is successful
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Agent User - Application Approval
Meta:
@TestId TC406261
Given user is logged in agent portal as agent user
When user fills card sale checker details and submits the form
Then approval is successful
And user sign out from agent portal

Scenario: Prepaid - New Program to Existing Device - Customer User - Help Desk Status
Meta:
@TestId TC406262
Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
Then status should be normal
And sale date is updated in general details
And user sign out from customer portal

Scenario: Prepaid - New Program to Existing Device - Customer User - Help Desk Activate Device
Meta:
@TestId TC406263
Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
And user activates device through helpdesk
Then activation of registered device prepaid is successful and activation date is updated
And user sign out from customer portal
