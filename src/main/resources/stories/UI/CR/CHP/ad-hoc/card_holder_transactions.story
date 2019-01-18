!-- auther: e076168

Narrative:
As a Cardhodler
I want to able to login into cardholder portal 
In order to do the transactions


Meta:
@CR
@CardHolderTransactions


Scenario: To verify functionality of Visa Money Transfer(Offline)
Meta:
@TCName TC_visaMoneyTransfer
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When fund transfer through wallet to wallet
Then verify Visa Money Transfer fund transfer stauts
And user logs out from cardholder portal

Scenario: To verify functionality of Visa Money Transfer(Real Time)
Meta:
@TCName TC_visaMoneyTransfer
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When fund transfer through wallet to wallet
Then verify Visa Money Transfer fund transfer stauts
And user logs out from cardholder portal


Scenario: To Verify functionality of wallet to wallet transfer 
Meta:
@TCName TC_walletToWalletTransfer
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When fund transfer through wallet to wallet
Then verify wallet to wallet transfer fund transfer stauts
And user logs out from cardholder portal

Scenario:To Verify functionality of intra bank fund transfer
Meta:
@TCName TC_checkInterbankTransfer
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When check charges for intra bank fund transfer
Then verify Intra bank fund transfer fund transfer stauts
Then cardholder logouts from cardholder portal

Scenario: To Verify functionality of mastercard money send 
Meta:
@TCName TC_masterCardMoneyTransfer
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When fund transfer through MasterCard Money Send
Then verify MasterCard Money send fund transfer stauts
And user logs out from cardholder portal

Scenario:To Verify cardholder can book the cash remittance
Meta:
@TCName TC_cashRemittanceBookting
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When cardholder book the cash remittance
Then user logs out from cardholder portal


Scenario: User can be able to cancel the cash remittance request 
Meta:
@TCName TC_cancelCashRemittanceBookting
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When cardholder cancel the cash remittance
Then user logs out from cardholder portal