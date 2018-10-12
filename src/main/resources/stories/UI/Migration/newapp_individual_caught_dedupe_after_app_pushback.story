Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to  gets caught in dedupe after application send to Pushback and corrected


Meta:
@StoryName credit_card	 
!-- Scenario: To verify application gets caught in dedupe after application send to Pushback and corrected
!-- Given setting json values in excel for Credit
!-- When user is logged in institution
!-- And for EMV Card User fills Device Plan for credit product for Mastercard
!-- And User fills Wallet Plan for credit product and program Retail Credit Card
!-- And User Primary fills new Program Retail Credit Card section for credit product for mastercard
!-- And User fills Business Mandatory Fields Screen for Credit product
!-- And User fills Device Range section for credit product
!-- Then "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV" with dedupe
!-- And user verifies the credit application device
!-- And user approves the credit application device
!-- And user processesAll close batch for new Application
!-- And user processesAll deviceGeneration batch for new Application
!-- And user searches for created application
!-- And credit processes pre-production batch using new Application
!-- And credit processes deviceproduction batch using new Application
!-- And new Application processes pin generation batch for credit
!-- And User search for new application on search screen for credit and validates the status as NORMAL
!-- Then user logouts from customer portal

Scenario: To verify application gets caught in dedupe after application send to Pushback and corrected, Duplicate Application.
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills Business Mandatory Fields Screen for Credit product
And User fills Device Range section for credit product
And "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV" with dedupe
And user verifies the credit application device
And user pushback the credit application device
And user checks in Incomplete Application and adds duplicate data for the credit application device
And reject duplicate application caught on dedupeSDN
Then user logouts from customer portal