3d secure prepaid msr retail gift card pinless authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card pinless
As an issuer
I want to create an magnetic stripe prepaid card pinless and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift
@oldReferenceSheet_prepaid_msr

Scenario: Set up prepaid msr retail gift card authorization pinless
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card without pin
When user creates new device of prepaid type for new client
Then device has "normal" status
Then user sign out from customer portal

Scenario: prepaid msr retail gift card authorization pinless device production
Given user is logged in institution
And a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
Then device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then device has "normal" status
Then user activates device through helpdesk
Then embossing file batch was generated in correct format
Then user sign out from customer portal

Scenario: perform 3D_SECURE_CAVV authorization on corporate msr card
When connection to MAS is established
When perform an 3D_SECURE_CAVV MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user is logged in institution
Then search E-Commerce Transaction authorization and verify 000-Successful status
And user sign out from customer portal