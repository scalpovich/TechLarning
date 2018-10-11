Narrative:
In order to a add scoring parameters on New Credit Application under customer portal cardmanagement tab
As a user
I want to assert pages

Meta:
@StoryName credit_emv_retail

Scenario: 1.0 To verify application should be 'Referred' for score range is within Auto approval range and caught in Risk
Meta:
@TC858241
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score and risk
And User Adds Credit Limit Rule on program for fieldName AGE
And User fills Business Mandatory Fields Screen for credit product
When User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
When user verifies the credit application device
When user processes close batch for new Application
When user processesAll riskAnalysis batch for new Application
When user processesAll applicationScoring batch for new Application
When user refers the credit application device
When user processesAll creditBureauVerification batch for new Application
When user processes deviceGeneration batch for new Application

Scenario: 2.0 To verify credit application is boarded successfully when WF rule is configured for Application Score with the set value within auto approval range.
Meta:
@TC858242
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User Adds Credit Limit Rule on program for fieldName AGE
And User fills Business Mandatory Fields Screen for credit product
When User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
When user verifies the credit application device
When user processes close batch for new Application
When user processesAll riskAnalysis batch for new Application
When user processesAll applicationScoring batch for new Application
When user processes deviceGeneration batch for new Application
When user searches for created application
When credit processes pre-production batch using new Application
When credit processes deviceproduction batch using new Application
When new Application processes pin generation batch for credit
Then User search for new application on search screen for credit and validates the status as NORMAL

Scenario: 3.0 To verify credit application is Rejected when Work Flow rule is configured for Application Score with the set value within auto Reject range.
Meta:
@TC858243
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program for auto reject
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User Adds Credit Limit Rule on program for fieldName AGE
And User fills Business Mandatory Fields Screen for credit product
When User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
When user verifies the credit application device
When user processes close batch for new Application
When user processesAll applicationScoring batch for new Application
Then application status appeared as rejected on search application screen

Scenario: 4.0 To verify credit application is Referred when Work Flow rule is configured for Application Score with the set value within auto Referred range.
Meta:
@TC858244
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program for auto refer
And User Adds Risk Analysis Rule for fieldName1 AGE and fieldName2 Credit Limit on program
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User Adds Credit Limit Rule on program for fieldName AGE
And User fills Business Mandatory Fields Screen for credit product
When User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
When user verifies the credit application device
When user processes close batch for new Application
When user processesAll applicationScoring batch for new Application
Then application status appeared as refered on search application screen
