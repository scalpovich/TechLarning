Magnetic Strip Prepaid Card Authorization

Narrative:
In order to provide to client easy-to-use multi-purpose prepaid card
As an issuer
I want to create an magnetic stripe prepaid card and perform various transaction

Meta:
@StoryName prepaid_msr_retail_gift
@oldReferenceSheet_prepaid_msr
@SanityCards
@UISanity

Scenario: Set up retail magnetic stripe prepaid card and perform purchase transaction
Meta:
@TestId TC406658
!-- Given connection to FINSim is established
Given user is logged in institution
When prepaid magnetic stripe device is available with balance amount
When user has current wallet balance amount information for prepaid device
When user sign out from customer portal
!-- When data in embossing file and pin offset file are generated successfully and PIN is retrieved successfully
!-- When perform an MSR_PURCHASE MAS transaction
!-- When MAS test results are verified
!-- And Auth file is generated from MAS
!-- And user is logged in institution
!-- Then after transaction wallet balance amount for prepaid device is updated correctly