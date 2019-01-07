Narrative:
As a Cardhodler
I want to able to login into cardholder portal 
In order to do transacations 


Meta:
@CR

Scenario:To Verify the hardholder user is able to sign up
Meta:
@signUpCardholderPortal
@TCName TC_signUpCardholderPortal
Given login to cardholder portal as existing Cardholder user


Scenario:To Verify the hardholder user is able to login
Meta:
@cardHolderLoginScenario
@TCName TC_LoginCardholderPortal
Given login to cardholder portal as existing Cardholder user
Then cardholder logouts from cardholder portal

Scenario:Change cardholder password
Meta:
@cardHolderChangePassword
@TCName TC_cardHolderChangePassword
Given login to cardholder portal as existing Cardholder user
Then update cardholder login password

Scenario:Change cardholder password
Meta:
@cardHolderChangePassword
@TCName TC_cardHolderChangePassword
Given login to cardholder portal as existing Cardholder user
Then update cardholder transaction password


Scenario:Change cardholder sequrity questions
Meta:
@cardHolderChangeSequrityQuestion
@TCName TC_cardHolderChangeSequrityQuestion
Given login to cardholder portal as existing Cardholder user
Then update cardholder user sequrity questions



Scenario:Change cardholder alise 
Meta:
@cardHolderChangeAlise
@TCName TC_cardHolderChangeAlise
Given login to cardholder portal as existing Cardholder user
Then update cardholder user's userID with chpUser@123

Scenario:Recover the password by using UserID
Meta:
@cardHolderRecoverPassword
@TCName TC_cardHolderRecoverPassword
Given open card holder application
Then recover forgotes password for user with &userId

Scenario: Unblock user using UserID
Meta:
@cardHolderUnblockUser
@TC_Name TC_cardHolerUnblockUser
Given open card holder application
Then unblock cardholder account and userID is 10000172850000001


