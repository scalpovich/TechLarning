Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user 
I want to verify error message if the credit limit is greater

Meta:
@StoryName greater_limit_credit_emv_retail.csv				 
Scenario:TC_Add on cardVerifyError Message_Card Credit limit greater than primary credit limit.
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Add-on Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Add-on Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit device is created with increased limit using new device screen for Individual and Add-on Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL