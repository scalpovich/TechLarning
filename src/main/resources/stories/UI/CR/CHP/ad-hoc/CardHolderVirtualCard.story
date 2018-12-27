Narrative:
As a Cardhodler
I want to able to login into cardholder portal 
In order to access virtual card service for cardholder
When create virtual prepaid card request
Meta:
@VirtualCardScenarios


Scenario:Create virtual prepaid card request
Meta:
@TCName TC_RequestVirtualPrepaidCard
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When create virtual prepaid card request
Then verify virtual prepaid card request status
And user logouts from cardholder portal

Scenario:Create request for Limited Validity Virtual Card
@TCName TC_RequestLimitedValidityVirtualCard
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When request limited validity virtual card
Then verify virtual prepaid card request status
And user logouts from cardholder portal

Scenario:Cancel the requested limited validity virtual card 
@TCName TC_CancelRequestedLimitedValidityVirtualCard
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When cancel limited validity virtual card request
Then verify virtual prepaid card request status
And user logouts from cardholder portal