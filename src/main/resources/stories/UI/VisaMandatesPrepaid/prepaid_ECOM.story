Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform ECOM through vts

Meta:
@StoryName VISAPREPAID
@visa_transaction_types

Scenario: Set up prepaid msr retail general purpose pin card and perform Balance Inquiry transaction
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "magnetic stripe" card
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
And user assigns service code to program
Then user creates new device of prepaid type for new client

Scenario: prepaid msr corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for prepaid
And processes device production batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status

Scenario: Transaction - Balance_Enquiry transaction
When connection to VISA is established
When perform an POS-Retail-ECOM_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-ECOM
Then search E-Commerce  Transaction* authorization and verify 000-Successful status
And user sign out from customer portal
Then VISA simulator is closed

Scenario: Calculate fees and available balance
When user is logged in institution
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal