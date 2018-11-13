prepaid emv retail gift card pinless authorization

Narrative:
In order to provide to client easy-to-use retail general purpose prepaid card pinless
As an issuer
I want to create EMV prepaid card pinless and perform various transaction

Meta:
@StoryName p_emv_retail_gift

Scenario: 1.1 Set up prepaid emv retail general purpose card
Given user is logged in institution
When device range for program with device plan for "prepaid" "emv" card without pin
And user creates new device of prepaid type for new client
And user signs out from customer portal

Scenario: 1.2 prepaid emv retail general purpose card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user signs out from customer portal
And user is logged in institution
Then device has "normal" status

Scenario: 1.3 Prepaid - Admin User - Assign Program to Agency

Given user is logged in agent portal as admin user
When user fills information to assign program to agency and submits form
And program assigned to agency successfully
And user sign out from agent portal

Scenario: 1.4 Prepaid - Admin User - Assign Program to Branch

Given user is logged in agent portal as admin user
When user fills information to assign program to branch and submits form
And program assigned to branch successfully
And user sign out from agent portal

Scenario: 1.5 Prepaid - Agent User - Assign Program to Agent

Given user is logged in agent portal as admin user
When user fills information to assign program to agent and submits form
And program assigned to agent successfully
And user sign out from agent portal

Scenario: 1.6 Prepaid - Load Balance Request - Funded Agent

Given user is logged in agent portal as agent user
When user performs load balance request for Joining and Membership plan
And load balance request is successful
And user sign out from agent portal

Scenario: 1.7 Prepaid - Approve the Load Request - Funded Agent
Given user is logged in institution
When user has wallet balance information for prepaid device
Then user sign out from customer portal
When user is logged in agent portal as agent user
And user performs load balance approve
And load balance approve is successful
Then user sign out from agent portal
When user is logged in institution
And balance in helpdesk updated correctly for prepaid device
And user signs out from customer portal

Scenario: 1.8 Post maintenance batch and pre-clearing batch is run
Given user is logged in institution
When post maintenance batch is run
And "Pre-clearing" batch for prepaid is successful
And user signs out from customer portal

Scenario: 1.9 Joining and MemberShip Fees is been Deducted
Given user is logged in institution
When search with device in transaction screen and Verify Joining and Membership Fees
And user signs out from customer portal

