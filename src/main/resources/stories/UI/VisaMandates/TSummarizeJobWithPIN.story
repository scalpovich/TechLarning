Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Balance Inquiry through vts

Meta:
@StoryName VISAPrePaidMSR
@visa_transaction_types

Scenario: 01. Set up prepaid msr retail general purpose pin card and perform cash withdrawal transaction
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

Scenario: 02. Pin Generation
When Pin Offset file batch was generated successfully
Then connection to FINSim is established
And embossing file batch was generated in correct format
When PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: 03. Transaction - Balance_Enquiry transaction
Given connection to VISA is established
When perform an POS-Magstripe-balance-and-eligibility-Inquiry_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-balance-and-eligibility-Inquiry_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Balance Inquiry authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 04. Perform Cash Advance Authorization transaction
Given connection to VISA is established
When perform an POS-Magstripe-CashAdvance_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-CashAdvance_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Cash Advance/ Cash @ POS / Cash Out authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 05. Transaction - Cash Withdrawl Full Reversal
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashRev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashRev_with_Pin
And VISA simulator is closed
And user is logged in institution
And search CWD - Full Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 06. Transaction - Cash Withdrawl Partial Reversal
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
And VISA simulator is closed
And user is logged in institution
And search CWD - Partial Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 07. Transaction - Cash eWithdrawl
Given connection to VISA is established
When perform an POS_Retail_Magstripe_cash_withdrawal_with_Pin VISA transaction
And VISA test results are verified for POS_Retail_Magstripe_cash_withdrawal_with_Pin
And VISA simulator is closed
And user is logged in institution
And search CWD authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 08. Transaction - Eligibility_Inquiry transaction
Given connection to VISA is established
When perform an POS-Magstripe-eligibility-Inquiry_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-eligibility-Inquiry_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Eligibility Inquiry authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 09. Transaction - PreAuth transaction
Given connection to VISA is established
When perform an POS-Retail-PreAuth_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-PreAuth_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Pre-Auth authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 10. Transaction - PreAuth Completion transaction
Given connection to VISA is established
When perform an POS-Retail-PreAuthCompletion_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-PreAuthCompletion_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Pre-Auth Completion authorization and verify Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 11. Transaction - Purchase  transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-purchase_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-purchase_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Purchase authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 12. Transaction - Purchase Reversal transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-cashPrev_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Purchase Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 13. Transaction - Quasi Cash transaction
Given connection to VISA is established
When perform an POS-Magstripe-QuasiCash_with_Pin VISA transaction
And VISA test results are verified for POS-Magstripe-QuasiCash_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Quasi Cash authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 14. Transaction - Refund transaction
Given connection to VISA is established
When perform an POS-Retail-Refund_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Refund_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Refund authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 15. Transaction - Refund Reversal transaction
Given connection to VISA is established
When perform an POS-Retail-RefundReversal_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-RefundReversal_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Refund Reversal authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 16. Transaction - ReturnofGoods transaction
Given connection to VISA is established
When perform an POS-Retail-Magstripe-returns-of-goods_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-Magstripe-returns-of-goods_with_Pin
And VISA simulator is closed
And user is logged in institution
And search Refund authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal

Scenario: 17. Transaction - STIP Advice transaction
Given connection to VISA is established
When perform an POS-Retail-STIP_with_Pin VISA transaction
And VISA test results are verified for POS-Retail-STIP_with_Pin
And VISA simulator is closed
And user is logged in institution
And search STIP - Purchase/Auth Completion authorization and verify 000-Successful status
And verify fixed transaction fee applied on purchase transaction
And user verifies available balance after transaction
Then user sign out from customer portal
