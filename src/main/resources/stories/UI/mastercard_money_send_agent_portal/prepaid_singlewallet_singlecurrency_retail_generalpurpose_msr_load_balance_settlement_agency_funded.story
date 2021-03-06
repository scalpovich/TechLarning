Prepiad: Funded Agent : Initial Load - Load - Reload - Settlement - Preclearing - EOD - Program Balance Reports

Narrative:
In order to do prepaid load
As an Agency User
I want to do Initial Load - Load - Reload through agent portal

Meta:
@StoryName SWSC_MSR_RTLGP_AGNC_FUND
@CR1
@CardCreation
@InitialLoadAndLoad

Scenario: Prepaid - Admin User - Assign Program to Agency

Given user is logged in institution
And bulk card generation for prepaid magnetic stripe is completed
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

Scenario: Prepaid - Agency User - Order Request

Given user is logged in agent portal as agency user
When user fills order details and submits the form
Then order is successful
And user sign out from agent portal

Scenario: Prepaid - Customer User - Dispatch

Given user is logged in institution
When user fills quantity to be dispatched and submits the form
Then dispatch is successful
And user sign out from customer portal

Scenario: Prepaid - Agency User - Order Acceptance

Given user is logged in agent portal as agency user
When user fills the order acceptance details and submits the form
Then order acceptance is successful
And user sign out from agent portal

Scenario: Prepaid - Agency User - Status

Given user is logged in agent portal as agency user
When user fills status details and submits the form
Then status column updates with type of order accepted
And user sign out from agent portal

Scenario: Prepaid - Agent User - Device Sale with Registration

Given user is logged in agent portal as agent user
When user fills program details with registration
Then registration is successful
And user sign out from agent portal

Scenario: Prepaid - Agent User - Application Approval

Given user is logged in agent portal as agent user
When user fills card sale checker details and submits the form
Then approval is successful
And user sign out from agent portal

Scenario: Prepaid - Customer User - Help Desk Status

Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
Then status should be normal
And sale date is updated in general details
And user sign out from customer portal

Scenario: Prepaid - Customer User - Help Desk Activate Device

Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
And user activates device through helpdesk
Then activation of registered device prepaid is successful and activation date is updated
And initial load balance in helpdesk updated correctly for prepaid device
And user sign out from customer portal

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


Scenario: MMS transaction through agent portal
When user is logged in agent portal as agent user
When user navigates to transfer funds page
Then transfer funds page is loaded and master detail content title is Transfer Funds
And TransferFunds page of transactions tab is rendered correctly
Then user transfer fund through MMS using agent portal
And user sign out from agent portal
