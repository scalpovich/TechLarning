!-- Author e084017
Narrative:
As a(n) Customer portal user 
I want to onboard credit device using new application and verify then refer

Meta:
@StoryName credit_card_cobrand_number
@FileUpload
Scenario: To verify that Cobrand Number can be added and saved on Incomplete application screen
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
And credit device is created using new Application screen for Individual and "Primary Device" and New Client and EMV Card
And user checks in Incomplete Application for the credit application device
And user verifies the credit application device
And user processes close batch for new Application
And user processesAll riskAnalysis batch for new Application
And user processesAll applicationScoring batch for new Application
And user refer the credit application device
And user processesAll creditBureauVerification batch for new Application
And user processes deviceGeneration batch for new Application
And user searches for created application
And credit processes pre-production batch using new Application
And credit processes deviceproduction batch using new Application
And new Application processes pin generation batch for credit
And User search for new application on customer care screen for credit and validates the status as NORMAL
Then user logouts from customer portal

