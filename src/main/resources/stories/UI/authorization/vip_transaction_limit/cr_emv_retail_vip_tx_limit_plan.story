Narrative:
In order to verify the transaction limit plan functionality for credit products
As a user
I want to trigger a purchase transaction on a retail credit card where client is vip
So that transaction limit plan for vip customer is verified

Meta:
@FR
@CreditFR
@StoryName cr_vip_transaction_limit
@vip_transaction_limit

Scenario:1 creation of corporate emv credit device
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal