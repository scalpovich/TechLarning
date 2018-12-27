Narrative:
As a Cardhodler
I want to able to login into customer portal 
In order to do the wallet to wallet transactions

Meta:
@VerifyWalletToWalletTransfer
@TCName TC_walletToWalletTransfer
@sheetName CardHolder

Scenario: To Verify functionality of wallet to wallet transfer 

Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When fund transfer through wallet to wallet
Then verify wallet to wallet transfer fund transfer stauts
Then cardholder logouts from cardholder portal