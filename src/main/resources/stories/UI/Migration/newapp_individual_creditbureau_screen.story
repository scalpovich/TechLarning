Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to create board credit device via New Application Screen with Credit Bureau
					 
Meta:
@StoryName credit_card	 
Scenario:1.1 To verify user is able to board credit device via New Application Screen with Credit Bureau
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User Adds WorkFlow Rule with Credit Bureau for Customer and Individual on program
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processesAll close batch for new Application
And user refer the credit application device
And user processesAll creditBureauVerification batch for new Application
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