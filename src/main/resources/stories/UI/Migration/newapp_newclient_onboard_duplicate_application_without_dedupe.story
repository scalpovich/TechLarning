Narrative:
In order to verify user is not able to board a duplicate application when dedupe plan is not configured
As a user
I want to board a duplicate application when dedupe plan is not configured.

Meta:
@StoryName credit_emv_retail
Scenario:1.1 To verify user is able to board a duplicate application when dedupe plan is not configured.
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product without dedupe for mastercard
And User fills Business Mandatory Fields Screen for Credit product
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV" with dedupe
And user verifies the credit application device
And user approves the credit application device
And user processesAll close batch for new Application
And user processesAll deviceGeneration batch for new Application
And user searches for created application
And user sign out from customer portal

Scenario:1.2 To process Pre-Production batch
Given user is logged in institution
When credit processes pre-production batch using new Application
Then user sign out from customer portal

Scenario:1.3 To process Device-Production batch
Given user is logged in institution
When credit processes deviceproduction batch using new Application
Then user sign out from customer portal

Scenario:1.4 To process Pin-Generation batch
Given user is logged in institution
When new Application processes pin generation batch for credit
Then user sign out from customer portal

Scenario:1.5 To search New Application on HelpDesk Screen
Given user is logged in institution
When User search for new application on search screen for credit and validates the status as NORMAL
Then user sign out from customer portal

Scenario:1.6 To get the Client Code and Generate the Device Activity Report
Given user is logged in institution
When user gets the client code
And generate device activity report
Then user sign out from customer portal