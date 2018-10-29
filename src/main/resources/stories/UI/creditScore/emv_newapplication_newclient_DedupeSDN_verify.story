Narrative:
In order to a add scoring parameters on New Credit Application under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@StoryName credit_emv_retail
Scenario:User is able to add Approval Score,Risk analysis for Credit Device SetUp and creates a Credit Device Using New Application
Meta:
@UserAddsApprovalScore
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills Business Mandatory Fields Screen for Credit product
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program
And User Adds Credit Limit Rule on program for fieldName AGE
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV" with dedupe
And user verifies the credit application device
And user processesAll close batch for new Application
And user processesAll riskAnalysis batch for new Application
And user processesAll applicationScoring batch for new Application
And user refer the credit application device
And user processesAll creditBureauVerification batch for new Application
And user approves the credit application device
And user processesAll deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And User search for new application on search screen for credit and validates the status as NORMAL

Scenario:User is able to add Approval Score,Risk analysis for Credit Device SetUp and creates a Credit Device Using New Application with Dedupe Verification
Meta:
@UserAddsApprovalScore
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills Business Mandatory Fields Screen for Credit product
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program
And User Adds Credit Limit Rule on program for fieldName AGE
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV" with dedupe
And approves duplicate application caught on dedupeSDN
And user verifies the credit application device
And user processesAll close batch for new Application
And user processesAll riskAnalysis batch for new Application
And user processesAll applicationScoring batch for new Application
And user refer the credit application device
And user processesAll creditBureauVerification batch for new Application
And user approves the credit application device
And user processesAll deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And User search for new application on search screen for credit and validates the status as NORMAL