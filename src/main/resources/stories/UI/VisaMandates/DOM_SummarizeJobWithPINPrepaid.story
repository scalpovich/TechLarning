Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Balance Inquiry through vts

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
And processes pin generation batch for prepaid
And user has wallet number information for prepaid device
And user performs adjustment transaction
And user has current wallet balance amount information for prepaid device
And device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - Balance_Enquiry transaction
Given connection to VISA is established
When perform an POS-Magstripe-balance-and-eligibility-Inquiry_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-balance-and-eligibility-Inquiry_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Balance Inquiry authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Perform Cash Advance Authorization transaction
Given connection to VISA is established
When perform an POS-Magstripe-CashAdvance_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-CashAdvance_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Cash Advance/ Cash @ POS / Cash Out authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Cash Withdrawal Full Reversal
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashRev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashRev_with_Pin
And VISA simulator is closed
And user is logged in institution
And search CWD - Full Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Cash Withdrawal Partial Reversal
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
And VISA simulator is closed
And user is logged in institution
And search CWD - Partial Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Cash eWithdrawal
Given connection to VISA is established
When perform an POS_Retail_Magstripe_cash_withdrawal_with_Pin VISA transaction
And VISA test results are verified for POS_Retail_Magstripe_cash_withdrawal_with_Pin
And VISA simulator is closed
And user is logged in institution
And search CWD authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Eligibility_Inquiry transaction
Given connection to VISA is established
When perform an POS-Magstripe-eligibility-Inquiry_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-eligibility-Inquiry_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Eligibility Inquiry authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - PreAuth transaction
Given connection to VISA is established
When perform an POS-Retail-PreAuth_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-PreAuth_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - PreAuth Completion transaction
Given connection to VISA is established
When perform an POS-Retail-PreAuthCompletion_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-PreAuthCompletion_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Pre-Auth Completion authorization and verify Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Purchase  transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-purchase_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Purchase Reversal transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Purchase Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Quasi Cash transaction
Given connection to VISA is established
When perform an POS-Magstripe-QuasiCash_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-QuasiCash_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Quasi Cash authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Refund transaction
Given connection to VISA is established
When perform an POS-Retail-Refund_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Refund_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Refund authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Refund Reversal transaction
Given connection to VISA is established
When perform an POS-Retail-RefundReversal_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-RefundReversal_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Refund Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - Return of Goods transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-returns-of-goods_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-returns-of-goods_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Refund authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: Transaction - STIP Advice transaction
Given connection to VISA is established
When perform an POS-Retail-STIP_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-STIP_with_Pin
And VISA simulator is closed
And user is logged in institution
And search STIP - Purchase/Auth Completion authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal
