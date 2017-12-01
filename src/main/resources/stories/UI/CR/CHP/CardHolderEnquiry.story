!-- auther:e076168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to do enquires

Meta:
@CR
@ChardHolderEnquery

Scenario:To Verify charges for Fund Transfer 
Meta:
@ViewChargeForFundTransfer
@TCName TC_ViewChargeForFundTransfer
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for Fund Transfer
Then verify total debit amount for transaction
Then verify transaction conversation rate

Scenario:To Verify charges for Intra Client - Wallet to Wallet Transfer(Debit) 
Meta:
@ViewChargeForWalletToWalletDebit
@TCName TC_ViewChargeForWalletToWalletDebit
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for Intra Client - Wallet to Wallet Transfer(Debit)
Then verify transaction conversation rateViewChargeForWalletToWalletDebit
Then verify total debit amount for transaction

Scenario:To Verify charges for Refund on Wallet Closure 
Meta:
@ViewChargeForWalletClosure 
@TCName TC_ViewChargeForWalletClosure
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for Refund on Wallet Closure
Then verify transaction conversation rate
Then verify total debit amount for transaction

Scenario:To Verify charges for Visa Money Transfer Debit
Meta:
@ViewChargeForVisaMoneyTransferDebit
@TCName TC_ViewChargeForVisaMoneyTransferDebit
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for Visa Money Transfer Debit
Then verify transaction conversation rate
Then verify total debit amount for transaction


Scenario:To Verify charges for Intra Bank - Wallet to Wallet Transfer(Debit)
Meta:
@ViewChargeForIntraBnkWalletToWalletTransferDebit
@TCName TC_ViewChargeForIntraBnkWalletToWalletTransferDebit
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for Intra Bank - Wallet to Wallet Transfer(Debit)
Then verify transaction conversation rate
Then verify total debit amount for transaction

Scenario:To Verify charges for MasterCard MoneySend - Sending
Meta:
@ViewChargeForMasterCardMoneySend
@TCName TC_ViewChargeForMasterCardMoneySend
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for MasterCard MoneySend - Sending
Then verify transaction conversation rate
Then verify total debit amount for transaction

Scenario:To Verify transaction history for selected wallet by number of transaction to display
Meta:
@ViewTransactionHistoryForWallet
@TCName TC_viewTransactionHistoryForWallet
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check transaction history for selected wallet

Scenario:To Verify transaction history for selected wallet between selected from and to date
Meta:
@ViewTransactionHistoryBetweedPerdiod
@TCName TC_viewTransactionHistoryForWallet
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check transaction history between selected duration
Then verify transaction details