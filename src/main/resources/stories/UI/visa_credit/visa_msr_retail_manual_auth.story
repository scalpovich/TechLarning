!-- @author: E076560
Narrative:
As a Customer portal user
I want to validate international manual auth on magstripe retail card
So that invalid device is not authorized

Meta:
@StoryName cr_visa_msr_manual_auth
@visa_msr_retail_intl_manual_auth
@ttt
Scenario:1 Device onboarding (part A)
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills Device Plan for credit product for Visa
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card
And User Primary Device fills New Program Retail Credit Card section for credit product for Visa
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:2 Device onboarding (part B)
Given user is logged in institution
When credit device is created using new device screen for Individual and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pinProduction batch using new Device for Supplementary
And device has "normal" status
And user notes down available Card limit for card
Then user sign out from customer portal

Scenario:3 Perform Authorization transaction
When user is logged in institution
And user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
When user verifies available balance after transaction
Then verify fixed transaction fee applied on purchase transaction
And device has "normal" status
When user verifies available Card limit for card after transaction
Then user sign out from customer portal

Scenario:4 Run Pre-clearing and EOD-Credit
Given user is logged in institution
When user wait for seven minutes to perform certain activity
And user sign out from customer portal
And user is logged in institution
When user processes Pre-clearing system internal batch for Credit
And user processes EOD-Credit system internal batch for Credit
And user verify Unbilled amount for Purchase category
And user sign out from customer portal