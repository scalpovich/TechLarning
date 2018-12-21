Narrative:
In order to a add scoring parameters on New Credit Application under customer portal cardmanagement tab
As a user
I want to check the behaviour of auto approve,reject and refer functions, risk analysis and when score went out of auto-rejection range.

Meta:
@StoryName credit_emv_retail

Scenario: 1.1 To verify application should be 'Referred' for score range is within Auto approval range and caught in Risk
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
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processesAll close batch for new Application
And user processesAll riskAnalysis batch for new Application
And user processesAll applicationScoring batch for new Application
And user refer the credit application device
And user processes deviceGeneration batch for new Application

Scenario: 1.2 To verify credit application is boarded successfully when WF rule is configured for Application Score with the set value within auto approval range.
Meta:
@TC858242
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program As Approve
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processes close batch for new Application
And user processesAll applicationScoring batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And User search for new application on search screen for credit and validates the status as NORMAL

Scenario: 1.3 To verify credit application is Rejected when Work Flow rule is configured for Application Score with the set value within auto Reject range.
Meta:
@TC858243
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program As Reject
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processes close batch for new Application
And user processesAll applicationScoring batch for new Application
And application status appeared as rejected on search application screen

Scenario: 1.4 To verify credit application is Referred when Work Flow rule is configured for Application Score with the set value within auto Referred range.
Meta:
@TC858244
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program As Refer
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processes close batch for new Application
And user processesAll applicationScoring batch for new Application
And application status appeared as refered on search application screen

Scenario: 1.5 To verify credit application is Referred when Work Flow rule is configured for Application Score with the set value is falls outside the upper limit of any score setup(Refer, Reject/Approve).
Meta:
@TC858245
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User adds Fixed Score for fieldName MARITAL STATUS and fieldValue SINGLE on program
And User adds Variable Score for fieldName AGE on program
And User adds Approval Score on program with less end range for auto reject
And User Adds WorkFlow Rule for fieldName1 Customer and fieldName2 Individual on program for application score
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user processes close batch for new Application
And user processesAll applicationScoring batch for new Application
And application status "not appeared" as rejected on search application screen