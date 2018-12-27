Narrative:
As a Cardhodler
I want to able to login into cardholder portal 
In order to do enquires

Meta:
@CR
@ChardHolderEnquery

Scenario:To Verify charges for Fund Transfer 
Meta:
@TCName TC_ViewChargeForFundTransfer
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then check Billing Amount charges for Fund Transfer transaction


Scenario:To Verify charges for Intra Client - Wallet to Wallet Transfer(Debit) 
Meta:
@TCName TC_ViewChargeForWalletToWalletDebit
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then check Billing Amount charges for Intra Client - Wallet to Wallet Transfer(Debit) transaction

Scenario:To Verify charges for Refund on Wallet Closure 
Meta:
@TCName TC_ViewChargeForWalletClosure
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then check Billing Amount charges for Wallet Closure transaction

Scenario:To Verify charges for Visa Money Transfer Debit
Meta:
@TCName TC_ViewChargeForVisaMoneyTransferDebit
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then check Billing Amount charges for Visa Money Transfer Debit transaction


Scenario:To Verify charges for Intra Bank - Wallet to Wallet Transfer(Debit)
Meta:
@TCName TC_ViewChargeForIntraBnkWalletToWalletTransferDebit
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then check Billing Amount charges for Intra Bank - Wallet to Wallet Transfer(Debit) transaction

Scenario:To Verify charges for MasterCard MoneySend - Sending
Meta:
@TCName TC_ViewChargeForMasterCardMoneySend
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then check Billing Amount charges for MasterCard MoneySend - Sending transaction

Scenario:To Verify transaction history for selected wallet by number of transaction to display
Meta:
@TCName TC_viewTransactionHistoryForWallet
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When check transaction history for selected wallet

Scenario:To Verify transaction history for selected wallet between selected from and to date
Meta:
@TCName TC_viewTransactionHistoryForWallet
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When check transaction history between selected duration
Then verify transaction details