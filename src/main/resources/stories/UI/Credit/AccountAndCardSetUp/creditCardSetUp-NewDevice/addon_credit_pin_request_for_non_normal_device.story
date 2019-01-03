Narrative:
As a user
I want to verify that pin request failed for blocked or expired add-on device
In order to create add-on credit card


Meta:
@StoryName credit_emv_retail

Scenario: 1 To verify that pin request failed for blocked add-on device 
Meta:
@TC858299
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card [1] User fills Device Plan for credit product for MASTERCARD [02]
And for EMV Card [2] User fills Supplementary Device Plan for credit product for MASTERCARD [02]
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Add-on Device fills Existing Program Retail Credit Card section for credit product for MASTERCARD [02]
And for Primary Device and New Client user fills Device Range section for credit product
And for Add-on Device and Existing Client user fills Device Range section for credit product
And credit device is created using new device screen for Individual [0] and Primary Device [P] and New Client [N] and Magnetic Stripe Card [1]
And credit device is created using new device screen for Individual [0] and Add-on Device [A] and New Client [N] and EMV Card [2]
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
Then device has "normal" status
And user creates service request for Block Device [111] service
And device has "blocked" status
And service request Pin Request  [305] should be fail for blocked add-on device

Scenario: 2 To verify that pin request failed for expired add-on device 
Meta:
@TC858299
Given device has "blocked" status
When user creates service request for Unblock Device [116] service
And user set expired date and status code in database
Then device has "expired" status
And service request Pin Request  [305] should be fail for expired add-on device
And user sign out from customer portal

