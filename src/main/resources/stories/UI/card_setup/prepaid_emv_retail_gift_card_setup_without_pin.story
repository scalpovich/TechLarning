prepaid emv retail giftcard card without pin

Narrative:
In order to provide to client easy-to-use payment method for e-commerce retail
As an issuer
I want to create a prepaid emv retail giftcard card without pin for client

Meta:
@StoryName S203707
@oldReferenceSheet_S203707
@SanityTest
@CardCreation

Scenario: Set up prepaid emv retail giftcard card without pin
Meta:
@TestId TC398452
Given user is logged in institution
And prepaid emv device without pin is available with balance amount
And user has current wallet balance amount information for prepaid device
And user sign out from customer portal

!-- Scenario: Set up prepaid emv retail giftcard card
!-- Meta:
!-- @TestId TC398452
!-- Given user is logged in institution
!-- And device range for program with device plan for "prepaid" "emv" card
!-- //And prepaid "emv" device without pin is available with balance amount
!-- When user creates new device of prepaid type for new client
!-- Then device has "normal" status

!-- Scenario: prepaid emv retail giftcard card device production
!-- Meta:
!-- @TestId TC408068
!-- Given user is logged in institution
!-- And a new device was created
!-- When processes pre-production batch for prepaid
!-- When processes device production batch for prepaid
!-- When processes pin generation batch for prepaid
!-- Then device has "normal" status