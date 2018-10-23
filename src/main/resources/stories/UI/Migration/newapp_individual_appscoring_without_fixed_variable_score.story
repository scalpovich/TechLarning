Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to board credit device via New Application Screen with Application scoring and Credit Bureau
					 
Meta:
@StoryName credit_card	 
Scenario:To verify user is able to board credit device via New Application Screen with Application scoring and Credit Bureau
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Approval Score on program As Refer
And User Adds WorkFlow Rule with Application Scoring for Customer and Individual on program
And User fills Device Range section for credit product
And "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processesAll close batch for new Application
And user processesAll applicationScoring batch for new Application
And user refer the credit application device
And user processesAll deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL