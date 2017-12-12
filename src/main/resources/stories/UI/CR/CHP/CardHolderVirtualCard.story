Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to access virtual card service for cardholder
When create virtual prepaid card request
Meta:
@VirtualCardScenarios


Scenario:Create virtual prepaid card request
Meta:
@RequestVirtualPrepaidCard
@TCName TC_RequestVirtualPrepaidCard
@sheetName CardHolder
@testDataFileName testdata
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When create virtual prepaid card request
Then verify virtual prepaid card request status

Scenario:Create request for Limited Validity Virtual Card
@RequestLimitedValidityVirtualCard
@TCName TC_RequestLimitedValidityVirtualCard
@sheetName CardHolder
@testDataFileName testdata
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When request limited validity virtual card
Then verify request status for limited validity virtual card

Scenario:Cancel the requested limited validity virtual card 
@CancelRequestedLimitedValidityVirtualCard
@TCName TC_CancelRequestedLimitedValidityVirtualCard
@sheetName CardHolder
@testDataFileName testdata
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When cancel limited validity virtual card request
Then verify request status for limited validity virtual card