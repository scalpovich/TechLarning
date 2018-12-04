Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Account Funding through vts

Meta:
@StoryName VISAPREPAID
@visa_transaction_types

Scenario: 01. Set up prepaid msr retail general purpose pin card and perform Account Funding transaction
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "magnetic stripe" card without pin
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: 02. prepaid msr corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status

Scenario: 03. Perform Account Funding Authorization transaction
Given connection to VISA is established
When perform an POS-Retail-AccountFund_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-AccountFund_with_Pin
And search E-Commerce Transaction* authorization and verify 000-Successful status
When verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal
And user sign out from customer portal
Then VISA simulator is closed
