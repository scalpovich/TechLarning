!-- auther:e076168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to do enquires

Meta:
@CR
@ChardHolderEnquery

Scenario:To Verify charges for refund on wallet closure 
Meta:
@ViewChargeForRefundOnWalletClosure
@TCName TC_viewChargeForRefundOnWalletClosure
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for fund transfer

Scenario:To Verify transaction history for selected wallet by number of transaction to display
Meta:
@ViewTransactionHistoryForWallet
@TCName TC_viewTransactionHistoryForWallet
@sheetName CardHolder
Given login to cardholder portal as existing Cardholder user
When check transaction history for selected wallet

Scenario:To Verify transaction history for selected wallet between selected from and to date
Meta:
@ViewTransactionHistoryBetweedPerdiod
@TCName TC_viewTransactionHistoryForWallet
@sheetName CardHolder
Given login to cardholder portal as existing Cardholder user
When check transaction history between selected duration
Then verify transaction details