Program Setup for emv corporate credit card

Narrative:
In order to sell credit cards
As an issuer
I want to set up a emv corporate credit card program

Meta:
@StoryName S190639
@SanityTest
@CardCreation

Scenario: Set up program emv corporate credit card
Meta:
@TestId TC398382
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
!-- And User fills Device Card Pack ID template for prepaid product
!-- And User fills Device template for prepaid product
!-- And User fills Device Priority Pass ID template for prepaid product
And User fills Device Plan for credit product
And User fills Billing Cycle
And User fills Payment Priority
And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product
And User fills MCC Rules for credit product
And User fills Program section for credit product
And User fills Business Mandatory Fields Screen for credit product
And User fills Device Range section for credit product
Then credit device plan and program are made available for Device Creation