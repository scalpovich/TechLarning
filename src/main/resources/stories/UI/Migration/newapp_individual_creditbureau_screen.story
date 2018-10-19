Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to create board credit device via New Application Screen with Credit Bureau
					 
Meta:
@StoryName credit_card	 
Scenario:To verify user is able to board credit device via New Application Screen with Credit Bureau
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User Adds WorkFlow Rule with Credit Brueau for Customer and Individual on program
When User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
When user verifies the credit application device
When user processesAll close batch for new Application
When user refer the credit application device
When user processesAll creditBureauVerification batch for new Application
When user processesAll deviceGeneration batch for new Application
When user searches for created application
When credit processes pre-production batch using new Application
When credit processes deviceproduction batch using new Application
When new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL