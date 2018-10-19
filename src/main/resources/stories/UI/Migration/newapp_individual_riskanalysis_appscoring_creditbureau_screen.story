Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to board credit device via New Application Screen with Risk Analysis, Application scoring and Credit Bureau
					 
Meta:
@StoryName credit_emv_retail	 
Scenario:To verify user is able to board credit device via New Application Screen with Risk Analysis, Application scoring and Credit Bureau
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program
And User Adds Credit Limit Rule on program for fieldName AGE
When User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
When user verifies the credit application device
When user processesAll close batch for new Application
When user processesAll riskAnalysis batch for new Application
When user processesAll applicationScoring batch for new Application
When user refer the credit application device
When user processesAll creditBureauVerification batch for new Application
When user processesAll deviceGeneration batch for new Application
When user searches for created application
When credit processes pre-production batch using new Application
When credit processes deviceproduction batch using new Application
When new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL