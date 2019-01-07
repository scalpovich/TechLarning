!-- @author: e076560
Narrative:
As a Customer portal user
I want to validate temporary credit limit for VISA MSR Corporate card
So that credit limit should be validated

Meta:
@StoryName credit_visa_corp_limit

Scenario:1 Device onboarding (part A)
Given setting json values in excel for Credit
When user is logged in institution
And for Magnetic Stripe Card User fills Device Plan for credit product for Visa
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Corporate Credit Card
And User Primary Device fills New Program Corporate Credit Card section for credit product for Visa
And for Primary Device and New Client user fills Device Range section for credit product
Then user sign out from customer portal

Scenario:2 Device onboarding (part B)
Given user is logged in institution
When credit device is created using new device screen for Corporate and Primary Device and New Client and Magnetic Stripe Card
And credit processes pre-production batch using new Device
And credit processes deviceproduction batch using new Device for Supplementary
And credit processes pingeneration batch using new Device for Supplementary
And device has "normal" status
And user raises Permanent [P] credit limit change request for Corporate
And device has "normal" status
Then user verifies available Permanent [P] limit type
And user sign out from customer portal

Scenario:3 Perform Authorization transaction
Given user is logged in institution
When user raises an authorization request
Then status of request is "approved"
And search Purchase authorization and verify 000-Successful status
When user verifies available balance after transaction
And device has "normal" status
And user verifies available Card limit for card after transaction
Then user sign out from customer portal