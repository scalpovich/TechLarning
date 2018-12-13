Narrative:
In order to a create a Credit Device under customer portal cardmanagement tab
As a user
I want to perform Transaction on corporate credit card to check differenr status Refer/Capture.

Meta:
@CreditRegression
@CreditWithPin
@StoryName credit_emv_retail
@Abhishek_Credit				 
Scenario:1.1 creation of mastercard_corporate_primary_EMV Card credit device
Meta:
@TestId TC548377
Given setting json values in excel for Credit
Given user is logged in institution
When for EMV Card User fills without pin Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
Then credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then device has "normal" status
And embossing file batch was generated in correct format
And user sign out from customer portal

Scenario:1.2 When User Change device status to Capture of Lost Status
Given user is logged in institution
When User Changes Device Status to Capture [3]
And user stoplists a card from stoplist device screen
And user sign out from customer portal

Scenario:1.3 Perform EMV_PURCHASE Authorization transaction
Given connection to MAS is established
When perform an EMV_PURCHASE MAS transaction
Then MAS test results are verified
And user is logged in institution
And search Capture authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.4 When User Chnage device status to Refer of Lost Status
Given user is logged in institution
When User Changes Device Status to Refer [2]
And user stoplists a card from stoplist device screen
Then user sign out from customer portal

Scenario:1.5 Perform EMV_PURCHASE Authorization transaction
When perform an EMV_PURCHASE MAS transaction on the same card
Then MAS test results are verified
And user is logged in institution
And search Refer authorization and verify 000-Successful status
And user sign out from customer portal
Then MAS simulator is closed