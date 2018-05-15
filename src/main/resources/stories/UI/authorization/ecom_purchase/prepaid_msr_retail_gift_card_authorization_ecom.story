ECOMM_PURCHASE transaction on prepaid msr retail gift card authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift
@oldReferenceSheet_prepaid_msr
@SanityCardsWithAuthorization
@ECOM_PURCHASE

Scenario: ECOMM_PURCHASE transaction on prepaid msr retail gift card
Meta:
@TestId TC406658
Given user is logged in institution
When prepaid magnetic stripe device is available with balance amount
When user has current wallet balance amount information for prepaid device
When device has "normal" status
When user has wallet number information for prepaid device
When user performs adjustment transaction
When user has current wallet balance amount information for prepaid device
Then a new device was created
When user processes pre-production batch for prepaid
When user processes device production batch for prepaid
Then embossing file batch was generated in correct format
Then user activates device through helpdesk
When connection to MAS is established
When perform an ECOMM_PURCHASE MAS transaction
Then MAS test results are verified
When MAS simulator is closed
Then user sign out from customer portal