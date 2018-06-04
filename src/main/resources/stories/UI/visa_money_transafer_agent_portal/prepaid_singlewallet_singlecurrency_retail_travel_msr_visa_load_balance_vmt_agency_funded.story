Prepiad: Funded Agent : prepaid singlewallet singlecurrency retail travel msr visa load balance and vmt on agency funded

Narrative:
In order to do prepaid load
As an Agency User
I want to do Initial Load - Load - Reload through agent portal visa interface

Meta:
@StoryName SWSC_MSR_V_RTLTRVL_AGNC_FUND
@CR1
@CardCreation

Scenario: prepaid singlewallet singlecurrency retail travel msr visa load balance and vmt on agency funded
Given user is logged in non-default institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin for non-default institution
When user creates new device of prepaid type for non-default institution
Then device has "normal" status for non-default institution
Then user sign out from customer portal
Given user is logged in institution
And bulk card generation for prepaid magnetic stripe is completed for an interface
And user sign out from customer portal
And user is logged in agent portal as admin user
When user fills information to assign program to agency and submits form
Then program assigned to agency successfully
And user sign out from agent portal
Given user is logged in agent portal as admin user
When user fills information to assign program to branch and submits form
Then program assigned to branch successfully
And user sign out from agent portal
Given user is logged in agent portal as admin user
When user fills information to assign program to agent and submits form
Then program assigned to agent successfully
And user sign out from agent portal
Given user is logged in agent portal as agency user
When user fills order details and submits the form
Then order is successful
And user sign out from agent portal
Given user is logged in institution
When user fills quantity to be dispatched and submits the form
Then dispatch is successful
And user sign out from customer portal
Given user is logged in agent portal as agency user
When user fills the order acceptance details and submits the form
Then order acceptance is successful
And user sign out from agent portal
Given user is logged in agent portal as agency user
When user fills status details and submits the form
Then status column updates with type of order accepted
And user sign out from agent portal
Given user is logged in agent portal as agent user
When user fills program details with registration
Then registration is successful
And user sign out from agent portal
Given user is logged in agent portal as agent user
When user fills card sale checker details and submits the form
Then approval is successful
And user sign out from agent portal
Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
Then status should be normal
And sale date is updated in general details
And user sign out from customer portal
Given user is logged in institution
When user fills General details with product prepaid and submits the form for registered device
And user activates device through helpdesk
Then activation of registered device prepaid is successful and activation date is updated
And initial load balance in helpdesk updated correctly for prepaid device
And user sign out from customer portal
Given user is logged in agent portal as agent user
When user performs load balance request
Then load balance request is successful
And user sign out from agent portal
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
When user is logged in agent portal as agent user
When user navigates to transfer funds page
Then transfer funds page is loaded and master detail content title is Transfer Funds
And TransferFunds page of transactions tab is rendered correctly
Then user transfer fund through VMT using agent portal
And user sign out from agent portal
