Narrative:
In order to a create a Payment Upload CSV from the set of input parameters
As a user
I want to onboard credit emv retail general purpose card and do payments with Payment Upload Batch and Return it

Meta:
@StoryName credit_emv_retail

Scenario: 1.1 Set up credit emv retail general purpose card device production
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
Then device has "normal" status
And user sign out from customer portal

Scenario: 1.2 Create Payment Upload Csv, Process Payment Upload batch and verify Payment Details on HelpDesk
When user is logged in institution
And create Payment Upload CSV for Outstation_Cheque|Cash_Payment|DD_Payment|Local_Cheque and upload it on server
And user processes Payment upload batch for credit
And device has "normal" status
Then user verify Unbilled amount for Payment category
And user logouts from customer portal

Scenario: 1.3 Create Payment Upload Csv for Return, Process Payment Upload batch and verify Payment Details on HelpDesk after Return
When user is logged in institution
And create Payment Upload CSV for Outstation_Cheque_return|Cash_Payment_return|DD_Payment_return|Local_Cheque_return and upload it on server
And user processes Payment upload batch for credit
And device has "normal" status
Then user verifies Payment Unbilled after payment return
And user logouts from customer portal