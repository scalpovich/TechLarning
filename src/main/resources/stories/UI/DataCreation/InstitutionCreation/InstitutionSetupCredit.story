Narrative:
As a(n)  Customer portal user 
I want to configure the new institute with the required setup
So that new device can be created for Debit


Meta:
@InstituteTestDebit

Scenario: Scenario1 - Institution parameter setup for Debit type/ Mastercard
Meta:
@Regression
@Smoke
@CreditMastercard
@TCName AmextInstituionSetup
@sheetName S205014

Given login to portal as existing bank as a Customeruser 
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Mastercard
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office  for Amex
When user creates a Regional Office  for Amex
When user creates a Branch Office  for Amex
When user creates a Plastic Code  for Amex
When user creates Picture Code  for Amex
When user creates Device BIN for Mastercard for product Credit for BinType as Dual Message Type
When Create HSM Device Keys
When Create HSM Network Keys
When Create MDK keys
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Mastercard
When user creates Transaction Plan for Credit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Credit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Credit for document type Passport
When user creates Template of type Device Template and of length 16
When user creates Template of type Card Pack ID Template and of length 16
When user creates DeviceJoining Fee plan for Credit
When user creates Membership Fee plan for Credit
When user creates Device Event Based Fee Plan for Credit
When user creates Maintenance Wallet Fee Plan for Credit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached

Scenario: Scenario1 - Institution parameter setup for Debit type/ Visa
Meta:
@Regression
@Smoke
@DebitVisa
@TCName AmextInstituionSetup
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Visa
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Visa for product Debit for BinType as Dual Message Type
When user creates Device BIN for Visa for product Debit for BinType as Single Message Type
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Visa
When user creates Transaction Plan for Debit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Debit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Debit for document type Passport
When user creates Template of type Device Template and of length 24
When user creates Template of type Card Pack ID Template and of length 24
When user creates DeviceJoining Fee plan for Debit
When user creates Membership Fee plan for Debit
When user creates Device Event Based Fee Plan for Debit
When user creates a wallet plan of default type for program Retail Debit Card for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Visa for product Debit for device type as Magnetic Stripe Card
When user creates a Program for Visa for product Debit for program Retail Debit Card
When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Debit
When user creates a Device Range for product Debit

Scenario: Scenario1 - Institution parameter setup for Debit type/ Rupay
Meta:
@Regression
@Smoke
@DebitRupay
@TCName AmextInstituionSetup
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Visa
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Rupay for product Debit for BinType as Dual Message Type
When user creates Device BIN for Rupay for product Debit for BinType as Single Message Type
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Rupay
When user creates Transaction Plan for Debit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Debit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Debit for document type Passport
When user creates Template of type Device Template and of length 24
When user creates Template of type Card Pack ID Template and of length 24
When user creates DeviceJoining Fee plan for Debit
When user creates Membership Fee plan for Debit
When user creates Device Event Based Fee Plan for Debit
When user creates Maintenance Wallet Fee Plan for Debit
When user creates a wallet plan of default type for program Retail Debit Card for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
When user creates a Device Plan for Rupay for product Debit for device type as Magnetic Stripe
When user creates a Program for Rupay for product Debit for program Retail Debit Card
When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Debit
When user creates a Device Range for product Debit



Scenario: Scenario1 - Institution parameter setup for Debit type/ Amex
Meta:
@Regression
@Smoke
@CreditAmex
@TCName AmextInstituionSetup
@sheetName S205014

!-- Given login to bank as a Bankadmin
Given login to portal as existing bank as a Customeruser 
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Amex
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Amex for product Credit for BinType as Dual Message Type
When Create HSM Device Keys for Amex
When Create HSM ZPK Network Keys for Amex(DMS)
When Create MDK keys for Amex
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Amex
When user creates Transaction Plan for Credit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Credit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Credit for document type Passport
When user creates Template of type Device Template and of length 16
When user creates Template of type Card Pack ID Template and of length 16
When user creates DeviceJoining Fee plan for Credit
When user creates Membership Fee plan for Credit
When user creates Device Event Based Fee Plan for Credit
When user creates Maintenance Wallet Fee Plan for Credit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached
