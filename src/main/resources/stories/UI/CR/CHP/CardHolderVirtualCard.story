!-- e07168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to access virtual card service for cardholder


Scenario:To create request for virtual prepaid card


Meta:
@RequestVirtualPrepaidCard
@TCName TC_RequestVirtualPrepaidCard
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When create virtual prepaid card request
Then verify virtual prepaid card request status


Meta:
@RequestLimitedValidityVirtualCard
@TCName TC_RequestLimitedValidityVirtualCard
@sheetName CardHolder
@testDataFileName testdata
Given login to cardholder portal as existing Cardholder user
When request limited validity virtual card
Then verify request status for limited validity virtual card
