Program Setup for virtual corporate gift card prepaid card

Narrative:
In order to sell prepaid cards
As an issuer
I want to set up a program for virtual corporate gift card prepaid card

Meta:
@StoryName S190638
@SanityTest
@CardCreation


Scenario: Set up program for virtual corporate gift card prepaid card
Meta:
@TestId TC398349
Given user is logged in institution
When User fills Statement Message Plan for prepaid product
And User fills Marketing Message Plan for prepaid product
And User fills Prepaid Statement Plan
And User fills MCC Rules for prepaid product
And User fills Dedupe Plan
When User fills Transaction Plan for prepaid product
And User fills Transaction Limit Plan for prepaid product
And User fills Document Checklist Screen for prepaid product
And User fills Device Joining and Membership Fee Plan for prepaid product
And User fills Device Event Based Fee Plan for prepaid product
!-- And User fills Device Card Pack ID template for prepaid product
!-- And User fills Device template for prepaid product
!-- And User fills Device Priority Pass ID template for prepaid product
And User fills Device Plan for prepaid product
And User fills Wallet Fee Plan for prepaid product
And User fills Wallet Plan for prepaid product
And User fills Program section for prepaid product
And User fills Business Mandatory Fields Screen for prepaid product
And User fills Device Range section for prepaid product
Then prepaid device plan and program are made available for Device Creation