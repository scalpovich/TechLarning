Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Purchase Reversal through vts

Meta:
@StoryName VISAPREPAID
@visa_transaction_types

Scenario: 01. Set up prepaid msr retail general purpose pin card and perform Purchase Reversal transaction
Given setting json values in excel for Prepaid
When user is logged in institution
And User fills Device Plan for "Prepaid" "magnetic stripe" card
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
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status

Scenario: 03. Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 04. Transaction - Purchase Reversal transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
And search Purchase Reversal authorization and verify 000-Successful status
And user sign out from customer portal
Then VISA simulator is closed

Scenario: 05. Calculate fees and available balance
Given user is logged in institution
When verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal