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

1

Scenario: Transaction - Balance_Enquiry transaction
When connection to VISA is established
When perform an POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin VISA transaction
When VISA test results are verified for POS-Magstripe-balance-and-egilibility-Inquiry_with_Pin
Then VISA simulator is closed

And user is logged in institution
Then search Balance Inquiry authorization and verify Successful status
Then verify fixed transaction fee applied on purchase transaction
When user verifies available balance after transaction
And user sign out from customer portal

2

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

3

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

4

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

5

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

6

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

7

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

8

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

9

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

10

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

11

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

12

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

13

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

14

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

15

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
