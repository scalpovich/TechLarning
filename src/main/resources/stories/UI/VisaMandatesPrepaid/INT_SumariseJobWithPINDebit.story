Narrative:
In order to provide to client easy-to-use payment method
As an issuer
I want to perform Balance Inquiry through vts

Meta:
@StoryName d_msr_corp

Scenario: Set up Debit msr retail general purpose pin card and perform Balance Inquiry transaction
Given setting json values in excel for Debit
When user is logged in institution
And User fills Device Plan for "Debit" "magnetic stripe" card
And User fills Wallet Plan for Debit product
And User fills Program section for Debit product
And User fills Business Mandatory Fields Screen for Debit product
And User fills Device Range section for Debit product
And user assigns service code to program
Then user creates new device of Debit type for new client

Scenario: Debit msr corporate travel card device production
Given user is logged in institution
When a new device was created
And processes pre-production batch for Debit
And processes device production batch for Debit
And processes pin generation batch for Debit
And user has wallet number information for Debit device
And user performs adjustment transaction
And device has "normal" status
And user sign out from customer portal

Scenario: Pin Generation
Given connection to FINSim is established
When Pin Offset file batch was generated successfully
And embossing file batch was generated in correct format
And PIN is retrieved successfully with data from Pin Offset File
Then FINSim simulator is closed

Scenario: Transaction - Balance_Enquiry transaction
When connection to VISA is established
When perform an INT_POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Balance Inquiry authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Perform Cash Advance Authorization transaction
When connection to VISA is established
When perform an INT_POS-Magstripe-CashAdvance_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Magstripe-CashAdvance_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Cash Advance/ Cash @ POS / Cash Out authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Cash Withdrawl Full Reversal
When connection to VISA is established
When perform an INT_POS-Retail-Magstripe-cashRev_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-Magstripe-cashRev_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search CWD - Full Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Cash Withdrawl Partial Reversal
When connection to VISA is established
When perform an INT_POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-Magstripe-cashPrev_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search CWD - Partial Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Cash eWithdrawl
When connection to VISA is established
When perform an INT_POS_Retail_Magstripe_cash_withdrawal_with_Pin VISA transaction
When VISA test results are verified for INT_POS_Retail_Magstripe_cash_withdrawal_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search CWD authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Eligibility_Inquiry transaction
When connection to VISA is established
When perform an INT_POS-Magstripe-egilibility-Inquiry_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Magstripe-egilibility-Inquiry_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Eligibility Inquiry authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - PreAuth transaction
When connection to VISA is established
When perform an INT_POS-Retail-PreAuth_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-PreAuth_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Pre-Auth authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - PreAuth Completion transaction
When connection to VISA is established
When perform an INT_POS-Retail-PreAuthCompletion_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-PreAuthCompletion_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Pre-Auth Completion authorization and verify Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Purchase  transaction
When connection to VISA is established
When perform an INT_POS-Retail-Magstripe-purchase_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-Magstripe-purchase_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Purchase authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Purchase Reversal transaction
When connection to VISA is established
When perform an INT_POS-Retail-Magstripe-cashPrev_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-Magstripe-cashPrev_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Purchase Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Quasi Cash transaction
When connection to VISA is established
When perform an INT_POS-Magstripe-QuasiCash_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Magstripe-QuasiCash_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Quasi Cash authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Refund transaction
When connection to VISA is established
When perform an INT_POS-Retail-Refund_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-Refund_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - Refund Reversal transaction
When connection to VISA is established
When perform an INT_POS-Retail-RefundReversal_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-RefundReversal_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Refund Reversal authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal

Scenario: Transaction - ReturnofGoods transaction
When connection to VISA is established
When perform an INT_POS-Retail-Magstripe-returns-of-goods_with_Pin VISA transaction
When VISA test results are verified for INT_POS-Retail-Magstripe-returns-of-goods_with_Pin
Then VISA simulator is closed
And user is logged in institution
Then search Refund authorization and verify 000-Successful status
Then verify fixed transaction fee applied on purchase transaction
And user sign out from customer portal
