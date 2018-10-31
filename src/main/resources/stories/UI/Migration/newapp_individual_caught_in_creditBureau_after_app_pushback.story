Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to  gets caught in Credit Bureau Verification after application send to Pushback and corrected.

Meta:
@StoryName credit_card
Scenario: To verify application gets caught in Credit Bureau Verification after application send to Pushback and corrected.
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User Adds WorkFlow Rule with Credit Bureau for Customer and Individual on program
And User fills Device Range section for credit product
Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV"
And user verifies the credit application device
And user pushback the credit application device
And user checks in Incomplete Application for the credit application device
And user processesAll creditBureauVerification batch for new Application
And user sign out from customer portal