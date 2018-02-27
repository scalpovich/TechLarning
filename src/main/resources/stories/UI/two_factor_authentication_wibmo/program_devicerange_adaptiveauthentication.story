two factor authentication at processing center

Narrative:
In order to validate two factor authentication
As a user
I want to validate two factor authentication at processing center

Meta:
@StoryName c_helpdesk_wallet_transfer
@oldReferenceSheet_S203707
Scenario:1 validate two factor authentication at processing center

Meta:
@TCName TCEditInstitute
@testDataFileName testdata
@sheetName Institute
@edit_institute_wibmo
Given login to bank as a Bankadmin
When user edits institution to enable two factor authentication
Then user logouts from customer portal

Scenario:2 validate two factor authentication at program level and device range level
Meta:
@TCName TC264306_Embossing File Generation
@testDataFileName testdata
@sheetName S205014
@edit_institute_wibmo1111
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product prepaid for program Retail General Purpose
Then Adaptive Authentication CheckBox should be Enabled
When user creates a Device Range for product prepaid
When user edits the device range
Then Verify for Device Range Adaptive Authentication CheckBox should be Enabled
Then user should be able to create Magnetic Stripe card for Prepaid product for Individual customer
When user runs the pre production batch for product Prepaid
When user check for the Pre-Production batch success status for SYSTEM INTERNAL PROCESSING batch
Then user runs the device production batch for product Prepaid
!-- When user creates new device of prepaid type for new client of Individual customer
!-- Then device has "normal" status

Scenario:2 validate two factor authentication at program level and device range level
Meta:
@TCName TC264306_Embossing File Generation
@testDataFileName testdata
@sheetName S205014
@edit_institute_wibmo
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail Debit Card for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Debit card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Debit for program Retail Debit Card
Then Adaptive Authentication CheckBox should be Enabled
When user creates a Device Range for product prepaid
When user edits the device range
Then Verify for Device Range Adaptive Authentication CheckBox should be Enabled
Then user should be able to create Magnetic Stripe card for Debit product for Individual customer
When user runs the pre production batch for product Debit
When user check for the Pre-Production batch success status for SYSTEM INTERNAL PROCESSING batch
Then user runs the device production batch for product Debit


Scenario:3 validate two factor authentication at processing center

Meta:
@TCName TCEditInstitute
@testDataFileName testdata
@sheetName Institute
@edit_institute_wibmo2
Given login to bank as a Bankadmin
When user edits institution to disable two factor authentication
Then user logouts from customer portal

Scenario:4 validate two factor authentication at program level and device range level
Meta:
@TCName TC264306_Embossing File Generation
@testDataFileName testdata
@sheetName S205014
@edit_institute_wibmo2
Given login to portal as existing bank as a Customeruser
When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail
When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose
Then Adaptive Authentication CheckBox should be Disabled
When user creates a Device Range for product Prepaid
When user edits the device range
Then Verify for Device Range Adaptive Authentication CheckBox should be Disabled