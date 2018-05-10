two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName credit_msr_retail

Scenario:1 validate two factor authentication at processing center
Meta:
@TCName TCEditInstitute
@testDataFileName testdata
@sheetName Institute
@edit_institute_wibmo_credit12
Given login to bank as a Bankadmin
When user edits institution to enable two factor authentication
Then user logouts from customer portal

Scenario:2 validate two factor authentication at program level and device range level
Meta:
@edit_institute_wibmo_credit
Given user is logged in institution
When User fills Dedupe Plan
And User fills Statement Message Plan for credit product
And User fills Marketing Message Plan for credit product
And User fills Transaction Plan for credit product
And User fills Transaction Limit Plan for credit product
And User fills Document Checklist Screen for credit product
And User fills Device Joining and Membership Fee Plan for credit product
And User fills Device Event Based Fee Plan for credit product
And User fills Device Plan for credit product
And User fills Billing Cycle
And User fills Payment Priority
!-- And User fills Payment Bounce Reason
And User fills Transaction Rule Plan
And User fills Credit Plan
And User fills Wallet Fee Plan for credit product
And User fills Wallet Plan for credit product and program Retail Credit Card [9]
And User fills MCC Rules for credit product
And User fills Program section for credit product and program Retail Credit Card [9]
When User fills Device Range section for credit product
Then credit device is created using new device screen
Then credit processes pre-production batch using new Device
Then credit processes deviceproduction batch using new Device
Then User search for new device on search screen for credit and validates the status as NORMAL