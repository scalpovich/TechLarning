Narrative:
In order to work on UI verification Agent Portal
As an Agent User
I want to validate transactions tab UI verification Agent Portal Pages Loaded based on role Agent

Meta:
@StoryName S224290
@AgentBV

Scenario: UI verification Agent Portal - Transactions - Load Balance - Request Page
Meta:
@TestId TC378890
Given user is logged in agent portal as agent user
When user navigates to load balance request page
Then load balance request page is loaded and master detail content title is Load Balance Request
And LoadBalanceRequest page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Load Balance - View Pending Requests Page
Meta:
@TestId TC378891
Given user is logged in agent portal as agent user
When user navigates to load balance view pending requests page
Then load balance view pending requests page is loaded and master detail content title is Load Balance View
And LoadBalanceViewPendingRequests page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Load Balance - Approve Page
Meta:
@TestId TC378889
Given user is logged in agent portal as agent user
When user navigates to load balance approve page
Then load balance approve page is loaded and master detail content title is Load Balance Approve
And LoadBalanceApprove page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Balance Refund - Request Page
Meta:
@TestId TC378884
Given user is logged in agent portal as agent user
When user navigates to balance refund request page
Then balance refund request page is loaded and master detail content title is Refund Wallet - Request
And BalanceRefundRequest page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Balance Refund - Approve Page
Meta:
@TestId TC378883
Given user is logged in agent portal as agent user
When user navigates to balance refund approve page
Then balance refund approve page is loaded and master detail content title is Refund Wallet - Approve
And BalanceRefundApprove page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Card to Cash Transaction Page
Meta:
@TestId TC378887
Given user is logged in agent portal as agent user
When user navigates to card to cash transaction page
Then card to cash transaction page is loaded and master detail content title is Cash Remittance Booking
And CardToCashTransaction page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Card to Cash Lookup Page
Meta:
@TestId TC378886
Given user is logged in agent portal as agent user
When user navigates to card to cash lookup page
Then card to cash lookup page is loaded and master detail content title is Cash Remittances
And CardToCashLookup page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Cancel Card to Cash Page
Meta:
@TestId TC378885
Given user is logged in agent portal as agent user
When user navigates to cancel card to cash page
Then cancel card to cash page is loaded and master detail content title is Cancel Remittance Booking
And CancelCardToCash page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Cash Remittance Payout Page
Meta:
@TestId TC378888
Given user is logged in agent portal as agent user
When user navigates to cash remittance payout page
Then cash remittance payout page is loaded and master detail content title is Cash Remittance Payout
And CashRemittancePayout page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - Transfer Funds Page
Meta:
@TestId TC378894
Given user is logged in agent portal as agent user
When user navigates to transfer funds page
Then transfer funds page is loaded and master detail content title is Transfer Funds
And TransferFunds page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - View Charges Page
Meta:
@TestId TC378893
Given user is logged in agent portal as agent user
When user navigates to view charges page
Then view charges page is loaded and master detail content title is View Charges
And TransactionsViewCharges page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - Transaction History Page
Meta:
@TestId TC378892
Given user is logged in agent portal as agent user
When user navigates to transaction history page
Then transaction history page is loaded and master detail content title is Transaction History
And TransactionHistory page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - Balance Enquiry Page
Meta:
@TestId TC378882
Given user is logged in agent portal as agent user
When user navigates to balance enquiry page
Then balance enquiry page is loaded and master detail content title is Balance Enquiry
And BalanceEnquiry page of transactions tab is rendered correctly
And user sign out from agent portal