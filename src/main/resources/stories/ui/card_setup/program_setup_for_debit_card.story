Program Setup for Debit Card

Narrative:
In order to sell Debit cards
As an issuer
I want to set up a program

Meta:
@StoryName S190640
@SmokeTest

Scenario: Set up program for debit card

Given user is logged in institution
When User fills Transaction Plan for debit product
And User fills Transaction Limit Plan for debit product
And User fills MCC Rules for debit product
And User fills Dedupe Plan
And User fills Document Checklist Screen for debit product
And User fills Device Joining and Membership Fee Plan for debit product
And User fills Device Event Based Fee Plan for debit product
!-- And User fills Device Card Pack ID template for prepaid product
!-- And User fills Device template for prepaid product
!-- And User fills Device Priority Pass ID template for prepaid product
And User fills Device Plan for debit product
And User fills Wallet Plan for debit product
And User fills Program section for debit product
And User fills Business Mandatory Fields Screen for debit product
And User fills Device Range section for debit product
Then debit device plan and program are available for Device Creation