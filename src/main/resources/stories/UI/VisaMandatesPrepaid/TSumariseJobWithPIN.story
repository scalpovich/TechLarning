Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Balance Inquiry through vts

Meta:
@StoryName VISAPrePaidMSR
@visa_transaction_types

Scenario: Set up prepaid msr retail general purpose pin card and perform cash withdrawal transaction
Given user is logged in institution
And device range for program with device plan for "prepaid" "magnetic stripe" card for an interface
When user creates new device of prepaid type for new client
When device has "normal" status
When a new device was created
When processes pre-production batch for prepaid
When processes device production batch for prepaid
When processes pin generation batch for prepaid
When device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction with 10000 amount
When user has current wallet balance amount information for prepaid device
Then device has "normal" status

Scenario: Pin Generation
When Pin Offset file batch was generated successfully
Then connection to FINSim is established
And embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - Balance_Enquiry transaction
When connection to VISA is established
When perform an POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin VISA transaction
When VISA test results are verified for POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Perform Cash Advance Authorization transaction
When connection to VISA is established
When perform an POS-Magstripe-CashAdvance_with_Pin VISA transaction
When VISA test results are verified for POS-Magstripe-CashAdvance_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Cash Advance/ Cash @ POS / Cash Out authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Cash Withdrawl Full Reversal
When connection to VISA is established
When perform an POS-Retail-Magstripe-cashRev_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-Magstripe-cashRev_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search CWD - Full Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Cash Withdrawl Partial Reversal
When connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search CWD - Partial Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Cash eWithdrawl
When connection to VISA is established
When perform an POS_Retail_Magstripe_cash_withdrawal_with_Pin VISA transaction
When VISA test results are verified for POS_Retail_Magstripe_cash_withdrawal_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search CWD authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Eligibility_Inquiry transaction
When connection to VISA is established
When perform an POS-Magstripe-egilibility-Inquiry_with_Pin VISA transaction
When VISA test results are verified for POS-Magstripe-egilibility-Inquiry_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Eligibility Inquiry authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - PreAuth transaction
When connection to VISA is established
When perform an POS-Retail-PreAuth_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-PreAuth_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - PreAuth Completion transaction
When connection to VISA is established
When perform an POS-Retail-PreAuthCompletion_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-PreAuthCompletion_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Pre-Auth Completion authorization and verify Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Purchase  transaction
When connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-Magstripe-purchase_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Purchase Reversal transaction
When connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Purchase Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Quasi Cash transaction
When connection to VISA is established
When perform an POS-Magstripe-QuasiCash_with_Pin VISA transaction
When VISA test results are verified for POS-Magstripe-QuasiCash_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Quasi Cash authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Refund transaction
When connection to VISA is established
When perform an POS-Retail-Refund_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-Refund_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - Refund Reversal transaction
When connection to VISA is established
When perform an POS-Retail-RefundReversal_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-RefundReversal_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Refund Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - ReturnofGoods transaction
When connection to VISA is established
When perform an POS-Retail-Magstripe-returns-of-goods_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-Magstripe-returns-of-goods_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

Scenario: Transaction - STIP Advice transaction
When connection to VISA is established
When perform an POS-Retail-STIP_with_Pin VISA transaction
When VISA test results are verified for POS-Retail-STIP_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search STIP - Purchase/Auth Completion authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal
