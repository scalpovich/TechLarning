!-- @author: E076560
Narrative:
As a Customer portal user
I want to validate ecom transaction not allowed on cancelled card
So that invalid device is not authorized

Meta:
@StoryName credit_emv_corp_limit
@visa_msr_retail_cancelled_ecom
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
Then user raises service request to Device Closure
And user sign out from customer portal

Scenario:3 Perform Ecomm Transaction
Given connection to VISA is established
When perform an POS-Retail-ECOM VISA transaction
Then verify that response code 05 is received for POS-Retail-ECOM
And user is logged in institution
And search E-Commerce Transaction* authorization and verify 100-Do Not Honour status
And user sign out from customer portal
And VISA simulator is closed