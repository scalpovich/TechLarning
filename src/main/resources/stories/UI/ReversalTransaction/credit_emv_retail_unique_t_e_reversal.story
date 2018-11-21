Narrative:
In order to validate Reversal Funcationality
As an issuer
I want to perform reversal transaction

Meta:
@StoryName credit_emv_retail

Scenario: 1.1 Create EMV credit device
Given setting json values in excel for Credit
When user is logged in institution
And for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:1.3 Perform Unique transaction
Meta:
TestID TC831213
Given connection to MAS is established
When perform an EMV_PURCHASE_T_E_UNIQUE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user verifies available Card limit for card after transaction
And validate auth report
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal

Scenario: 1.4 Perform Unique Transactionn Reversal
Meta:
TestID TC831213
Given user perform reversal transaction of type 17
When user is logged in institution
Then search Purchase Reversal authorization and verify 000-Successful status
And validate auth report
And user verifies available balance after reversals transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
And user sign out from customer portal
