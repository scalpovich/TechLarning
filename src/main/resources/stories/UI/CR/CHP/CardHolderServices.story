!-- auther:e076168

Narrative:
As a Cardhodler
I want to able to loing into cardholder portal 
In order to use the services for card

Meta:
@CR
@ChardHolderServices

Scenario:Device can replaced instanly for Device Technology Upgrade
Meta:
@deviceReplaceService
@TCName TC_deviceReplaceService
@sheetName CardHolder
Given read test data for scenario
Given login to cardholder portal as existing Cardholder user
When request for device replacement

!-- Scenario: Device can be blocked from cardholder portal
!-- Meta:
!-- @deviceBlockFromCardholder
!-- @TCName TC_deviceBlockFromCardHolder
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When service request for block card
!-- Then verify that card is getting blocked
!-- 
!-- 
!-- Scenario: Device can be unblock if it is blocked from cardholder portal
!-- Meta:
!-- @deviceUnblockFromCardholder
!-- @TCName TC_deviceUnblockFromCardholder
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When service request for unblock card
!-- Then verify that card is unbloked successfully
!-- 
!-- Scenario: Wallet can be activate from cardholder
!-- Meta:
!-- @walletActivateFromCardHolder
!-- @TCName TC_walletActivateFromCardHolder
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When service request for activate wallet
!-- Then verify that wallet is geting activated
!-- 
!-- Scenario: Wallet can be deactivate from cardholder
!-- Meta:
!-- @walletDeActivateFromCardHolder
!-- @TCName TC_walletDeActivateFromCardHolder
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When service request for deactivate wallet
!-- 
!-- 
!-- Scenario: Activate E-Com transaction for life long duration 
!-- Meta:
!-- @activateEcomForLifeLong
!-- @TCName TC_activateEcomForLifeLong
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When activate ecom transaction for Life Long Activate duration
!-- Then verify ecom transaction activation status
!-- 
!-- Scenario: Activation E-Com transaction for hours only
!-- Meta:
!-- @activateEcomForNHours
!-- @TCName TC_activateEcomForNHours
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When activate ecom transaction for Activation for 'n' hours duration
!-- Then ecom transaction  activation 10
!-- And verify ecom transaction activation status
!-- 
!-- 
!-- Scenario: Activation E-Com transaction for specified date
!-- Meta:
!-- @activationEcomForDuration
!-- @TCName TC_activationEcomForDuration
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When activate ecom transaction for Activation in Period duration
!-- Then activation of ecom transaction from 03/11/2017 to 15/11/2017
!-- Then verify ecom transaction activation status
!-- 
!-- 
!-- Scenario: Activate travel device for international use for period
!-- Meta:
!-- @activationForInternationalUse
!-- @TCName TC_activationForInternationalUse
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When activate international service for Activation in Period duration
!-- Then activation of international use from 03/11/2017 to 15/11/2017
!-- 
!-- Scenario: Activation travel device for international use for specified hours
!-- Meta:
!-- @activationNHoursForInternationalUse
!-- @TCName TC_activationNHoursForInternationalUse
!-- @sheetName CardHolder
!-- Given read test data for scenario
!-- And login to cardholder portal as existing Cardholder user
!-- When activate international service for Activation for 'n' hours duration
!-- Then international use activation hours is 5
!-- 
!-- 
!-- Scenario: Activation travel device for international use for life long
!-- Meta:
!-- @activationLifeLongForInternationalUse
!-- @TCName TC_activationLifeLongForInternationalUse
!-- @sheetName CardHolder
!-- Given login to cardholder portal as existing Cardholder user
!-- When activate international service for Life Long Activate duration
!-- Then verify international use activation status