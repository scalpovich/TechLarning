Narrative:
As a user
I want to verify that pin request failed for blocked or expired add-on device
In order to create add-on prepaid card


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
Then User search for new device Supplementary on search screen for credit and validates the status as NORMAL
And user blocks the device from helpdesk screen
And pin request should be fail for blocked add-on device

Scenario: 2 To verify that pin request failed for expired add-on device 
Meta:
@TC858299
Given user unblocks the device from helpdesk screen
When user set expired date and status code in database
Then pin request should be fail for expired add-on device
And user sign out from customer portal

