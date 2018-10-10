Narrative:
In order to validate High Risk Country,MCC,MCG,Merchant Location
As an issuer
I want to perform transaction for EMV Credit card

Meta:
@Author Nitin Kumar
@StoryName credit_emv_retail

Scenario:1 Set up Credit emv retail
Given setting json values in excel for Credit
And user is logged in institution
When for EMV Card User fills Device Plan for credit product for Mastercard
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User fills MCC Rules for credit product
And User Primary Device fills New Program Retail Credit Card section for credit product for Mastercard
And for Primary Device and New Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual and Primary Device and New Client and EMV Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device
And credit processes pingeneration batch using new Device for Supplementary
And User search for new device on search screen for credit and validates the status as NORMAL
Then user sign out from customer portal
And embossing file batch was generated in correct format

Scenario:2 Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario:3 Perform EMV-RetailGeneralPurposeCard Purchase 1st transaction
Given connection to MAS is established
When perform an EMV_PURCHASE_HRM MAS transaction
Then MAS test results are verified
And MAS simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:4 validate the High Risk MCC Report
Given user is logged in institution
Then validate the authCode in RAMP-REP05 report
And user sign out from customer portal

Scenario:5 validate the High Risk Country Report
Given user is logged in institution
Then validate the authCode in RAMP-REP04 report
And user sign out from customer portal

Scenario:6 validate the High Risk Merchant Location Report
Given user is logged in institution
Then validate the authCode in RAMP-REP06 report
And user sign out from customer portal
