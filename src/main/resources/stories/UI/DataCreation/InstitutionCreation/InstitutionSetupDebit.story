Narrative:
As a(n)  Customer portal user 
I want to configure the new institute with the required setup
So that new device can be created for Debit


Meta:
@InstituteSetUpDebit
@InstituionSetUpForAllType
Scenario: Scenario1 - Institution parameter setup for Debit type/ Mastercard
Meta:
@Regression
@Smoke
@DebitMastercard
@TCName TC264306_Embossing File Generation
@sheetName S205014


Given login to portal as existing bank as a Customeruser
When user creates Allowed Load Currency for INR
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Mastercard
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Mastercard for product Debit for BinType as Dual Message Type
When user creates HSM Device Keys for Mastercard
When user creates HSM ZPK Network Keys for Mastercard(CIS)
When user creates MDK keys for Mastercard
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Mastercard
When user creates Transaction Plan for Debit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Debit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Debit for document type Passport
When user creates Template of type Device Template and of length 16
When user creates Template of type Card Pack ID Template and of length 16
When user creates DeviceJoining Fee plan for Debit
When user creates Membership Fee plan for Debit
When user creates Device Event Based Fee Plan for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached

Scenario: Scenario1 - Institution parameter setup for Debit type/ Visa
Meta:
@Regression
@Smoke
@DebitVisa
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates Allowed Load Currency for INR
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
When user creates HSM Device Keys for Visa
When user creates HSM ZPK Network Keys for Visa(SMS)
When user creates MDK keys for Visa
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Visa
When user creates Transaction Plan for Debit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Debit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Debit for document type Passport
When user creates Template of type Device Template and of length 16
When user creates Template of type Card Pack ID Template and of length 16
When user creates DeviceJoining Fee plan for Debit
When user creates Membership Fee plan for Debit
When user creates Device Event Based Fee Plan for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached

Scenario: Scenario1 - Institution parameter setup for Debit type/ Rupay
Meta:
@Regression
@Smoke
@DebitRupay
@TCName TC264306_Embossing File Generation
@sheetName S205014
Given login to portal as existing bank as a Customeruser
When user creates Allowed Load Currency for INR
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for RUPAY
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Rupay for product Debit for BinType as Dual Message Type
When user creates HSM Device Keys for Rupay
When user creates HSM ZPK Network Keys for RPY
When user creates MDK keys for Rupay
When user creates MCG
When user creates Dedupe Plan
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Rupay
When user creates Transaction Plan for Debit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Debit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Debit for document type Passport
When user creates Template of type Device Template and of length 16
When user creates Template of type Card Pack ID Template and of length 16
When user creates DeviceJoining Fee plan for Debit
When user creates Membership Fee plan for Debit
When user creates Device Event Based Fee Plan for Debit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached