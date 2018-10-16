Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to  gets caught in dedupe after application send to Pushback and corrected


Meta:
@StoryName credit_card	 
Scenario: To verify application gets caught in dedupe after application send to Pushback and corrected, updated with previous card data.
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary fills new Program Retail Credit Card section for credit product for mastercard
And User fills Business Mandatory Fields Screen for Credit product
And User fills Device Range section for credit product
And "credit" is created with "Primary Device" as application type with application sub-type as "New" and customer of type "Individual" with "EMV" with dedupe
And credit device is created using new Application screen for Individual and "Primary Device" and New Client and EMV Card
And user verifies the credit application device
Then user pushback the credit application device
And user checks in Incomplete Application and adds duplicate data for the credit application device
And verify duplicate application caught on dedupeSDN
And user logouts from customer portal