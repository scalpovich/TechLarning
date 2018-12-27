Narrative:
As a cardhodler
I want to login into cardholder portal 
In order to assert cardholder services for given card

Meta:
@CR
@ChardHolderServices

Scenario:Replace device for device technology upgrade
Meta:
@TCName TC_deviceReplaceService
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then request for device replacement
And user logouts from cardholder portal

Scenario: Block device from further use
Meta:
@TCName TC_deviceBlockFromCardHolder
@sheetName CardHolder
Given read test data for scenario
When login to cardholder portal as existing Cardholder user
Then service request for block card
And user logouts from cardholder portal


Scenario: Unblock device if it is blocked
Meta:
@TCName TC_deviceUnblockFromCardholder
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When service request for unblock card
Then verify that card is unbloked successfully
And user logouts from cardholder portal

Scenario: Activate wallet from cardholder
Meta:
@TCName TC_walletActivateFromCardHolder
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When service request for activate wallet
Then verify that wallet is geting activated
And user logouts from cardholder portal

Scenario: Deactivate wallet from cardholder
Meta:
@TCName TC_walletDeActivateFromCardHolder
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When service request for deactivate wallet
Then user logouts from cardholder portal

Scenario: Activate E-Com transaction for life long duration 
Meta:
@TCName TC_activateEcomForLifeLong
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When activate ecom transaction for Life Long Activate duration
Then verify ecom transaction activation status
And user logouts from cardholder portal

Scenario: Activation E-Com transaction for hours only
Meta:
@TCName TC_activateEcomForNHours
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When activate ecom transaction for Activation for 'n' hours duration
Then ecom transaction activation for 10 hours
And verify ecom transaction activation status
And user logouts from cardholder portal

Scenario: Activate E-Com transaction for specified date
Meta:
@TCName TC_activationEcomForDuration
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When activate ecom transaction for Activation in Period duration
And activation of ecom transaction from 10/08/2018 to 31/08/2018
Then verify ecom transaction activation status
And user logouts from cardholder portal

Scenario: Activate travel device for period international use
Meta:
@TCName TC_activationForInternationalUse
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When activate international service for Activation in Period duration
Then activation of international use from 15/08/2018 to 21/08/2018
Then verify international use activation status
And user logouts from cardholder portal

Scenario: Activate travel device for specified hours international use 
Meta:
@TCName TC_activationNHoursForInternationalUse
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When activate international service for Activation for 'n' hours duration
And international use activation hours is 5
Then verify international use activation status
And user logouts from cardholder portal


Scenario: Activate travel device for  life long international use
Meta:
@TCName TC_activationLifeLongForInternationalUse
@sheetName CardHolder
Given read test data for scenario
And login to cardholder portal as existing Cardholder user
When activate international service for Life Long Activate duration
Then verify international use activation status
And user logouts from cardholder portal