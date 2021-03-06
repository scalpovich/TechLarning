Narrative:
In order to a validate 3 d secure Transaction on prepaid device
As a user
I want to perform 3 d secure Transaction without CVV2

Meta:
@StoryName p_emv_corp_general_purpose
@oldReferenceSheet_S203707

Scenario:1.1 Setup - prepaid emv corporate general purpose card
Given user is logged in institution
When device range for program with device plan for "prepaid" "emv" card without pin
And user creates new device of prepaid type for new client
Then user sign out from customer portal

Scenario:1.2 Device production - prepaid emv corporate general purpose card
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user activates device through helpdesk
And user sign out from customer portal
Then embossing file batch was generated in correct format

Scenario:1.3 perform 3D_SECURE_NO_CVV2 authorization on individual primary emv credit card 
Given connection to MAS is established
When perform an 3D_SECURE_NO_CVV2 MAS transaction
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 191-CVV2/CVC2/CVD2/4CSC Verification Failure status
And assert Decline response with 46041 AuthDecline Code and CVV2 not present for E-Comm transaction. as description
And user sign out from customer portal

Scenario:1.3 Skip CVV2/CVC2 Validation in 3DES Params
Given user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Credit and interchange Mastercard as check
Then user sign out from customer portal

Scenario:1.4 perform 3D_SECURE_NO_CVV2 authorization on prepaid emv corporate general purpose card
Given perform an 3D_SECURE_NO_CVV2 MAS transaction on the same card
When MAS test results are verified
And MAS simulator is closed
And user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal

Scenario:1.5 Skip CVV2/CVC2 Validation in 3DES Params
Given user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Credit and interchange Mastercard as uncheck
Then user sign out from customer portal