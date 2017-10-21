TEMPLATE for Program Setup

Narrative:
In order to sell prepaid cards
As an issuer
I want to set up a program



Scenario: Set up program for prepaid card
Given user is logged in institution

When User filled Dedupe Plan
When User filled Statement Message Plan for prepaid product
When User filled Marketing Message Plan for prepaid product
When User filled MCC Rules for prepaid product
When User filled Prepaid Statement Plan
When User filled Transaction Plan for prepaid product
When User filled Transaction Limit Plan for prepaid product
When User filled Document Checklist Screen for prepaid product
When User filled Device Joining and Membership Fee Plan for prepaid product
When User filled Device Event Based Fee Plan for prepaid product
!-- And User fills Device Card Pack ID template for prepaid product
!-- And User fills Device template for prepaid product
!-- And User fills Device Priority Pass ID template for prepaid product
When User filled Device Plan for prepaid product
When User filled Wallet Fee Plan for prepaid product
When User filled Wallet Plan for prepaid product
When User filled Program section for prepaid product
When User filled Business Mandatory Fields Screen for prepaid product
When User filled Device Range section for prepaid product
Then prepaid device plan and program are made available for Device Creation