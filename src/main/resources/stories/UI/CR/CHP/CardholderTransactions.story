!-- auther: e076168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to do the transactions


Meta:
@CR
@CardHolderTransactions

Scenario: To Verify functionality of mastercard money send 
Meta:
@masterCardMoneyTransfer
@TCName TC_masterCardMoneyTransfer
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When fund transfer through MasterCard Money Send
Then verify MasterCard Money send fund transfer stauts
!-- Then cardholder logouts from cardholder portal

Scenario: To Verify functionality of wallet to wallet transfer 
Meta:
@CheckWalletToWalletTransfer
@TCName TC_walletToWalletTransfer
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When fund transfer through wallet to wallet transfer
!-- Then cardholder logouts from cardholder portal

Scenario:To Verify intra bank fund transfer
Meta:
@CheckIntraBankFundTransfer
@TCName TC_checkInterbankTransfer
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When check charges for intra bank fund transfer
!-- Then cardholder logouts from cardholder portal


Scenario:To Verify cardholder can book the cash remittance
Meta:
@CashRemittanceBooking
@TCName TC_cashRemittanceBookting
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When cardholder book the cash remittance
!-- Then cardholder logouts from cardholder portal


Scenario: User can be able to cancel the cash remittance request 
Meta:
@CancelCashRemittanceBooking
@TCName TC_cancelCashRemittanceBookting
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When cardholder cancel the cash remittance
!-- Then cardholder logouts from cardholder portal