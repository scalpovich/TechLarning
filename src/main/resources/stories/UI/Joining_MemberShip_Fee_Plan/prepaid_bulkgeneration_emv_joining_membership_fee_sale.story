prepaid msr retail gift card pinless authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card pinless
As an issuer
I want to create an magnetic stripe prepaid card pinless and perform various transaction

Meta:
@StoryName p_emv_retail_gift

Scenario: Set up prepaid emv retail general purpose card
Given user is logged in institution
And device range for program with device plan for "prepaid" "emv" card without pin
When user creates new device of prepaid type for new client
Then user signs out from customer portal

Scenario: prepaid emv retail general purpose card device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then user signs out from customer portal
Then user is logged in institution
Then device has "normal" status

Scenario: Prepaid - Admin User - Assign Program to Agency

When user is logged in agent portal as admin user
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

Scenario: Prepaid - Agent User - Device Sale without Registration and through Customer Registration
Given user is logged in agent portal as agent user
When user fills program details without registration
And user provides details through customer registration
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
And user sign out from customer portal

Scenario: Post maintenance batch and pre-clearing batch is run 
Given user is logged in institution
When post maintenence batch is run
Then "Pre-clearing" batch for prepaid is successful
And user signs out from customer portal

Scenario: Joining and MemberShip Fees is been Deducted
Given user is logged in institution
Then search with device in transaction screen and status for Joning and Membership Fees
And user signs out from customer portal