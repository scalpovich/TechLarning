Narrative:
As a(n)  Customer portal user 
I want to configure the new institute with the required setup
So that new device can be created for Credit


Meta:
@InstituteSetUpCredit
@InstitutionSetUpForAllType
Scenario: Scenario1 - Institution parameter setup for Credit type/ Mastercard
Meta:
@Regression
@Smoke
@CreditMastercard
@TCName AmexInstitutionSetup
@sheetName S205014

Given login to portal as existing bank as a Customeruser
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Mastercard
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Mastercard for product Credit for BinType as Dual Message Type
When user creates HSM Device Keys for Mastercard
When user creates HSM ZPK Network Keys for Mastercard(CIS)
When user creates MDK keys for Mastercard
When user creates MCG
When user creates message 1100 transaction routing plan for Balance Inquiry with routing code SMS and Send to destination action
When user creates Dedupe Plan
When user creates aggregate load limit plan
When user creates easy pay plan rule
When user creates aggregate load limit plan
When user creates linking API to Institution
When user creates channel Routing plan for Point Of Sale channel and CBS1 interface
When user creates Acount Range Routing plan
When user creates Allowed Load Currency
!-- When user creates Manual Alerts of EMV Card for product type credit 
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

Scenario: Scenario1 - Institution parameter setup for Credit type/ Visa
Meta:
@Regression
@Smoke
@CreditVisa
@TCName AmexInstitutionSetup
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
When user creates Device BIN for Visa for product Credit for BinType as Dual Message Type
When user creates HSM Device Keys for Visa
When user creates HSM ZPK Network Keys for Visa(DMS)
When user creates MDK keys for Visa
When user creates MCG
When user creates message 1100 transaction routing plan for Balance Inquiry with routing code SMS and Send to destination action
When user creates Dedupe Plan
When user creates aggregate load limit plan
When user creates easy pay plan rule
When user creates aggregate load limit plan
When user creates linking API to Institution
When user creates channel Routing plan for Point Of Sale channel and CBS1 interface
When user creates Acount Range Routing plan
When user creates Allowed Load Currency
!-- When user creates Manual Alerts of EMV Card for product type credit
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Visa
When user creates Transaction Plan for Credit and transaction type Purchase/Auth Completion
When user creates Transaction Limit Plan for Credit and plan type as Device/Wallet/Promotion Entity Plan
When user creates Document checklist for Credit for document type Passport
When user creates Template of type Device Template and of length 16
When user creates Template of type Card Pack ID Template and of length 16
When user creates DeviceJoining Fee plan for Credit
When user creates Membership Fee plan for Credit
When user creates Device Event Based Fee Plan for Credit
When user creates an Embossing File Template
When user creates a Vendor of Category Personalization with Embossing template attached

Scenario: Scenario1 - Institution parameter setup for Credit type/ Rupay
Meta:
@Regression
@Smoke
@CreditRupay
@TCName AmexInstitutionSetup
@sheetName S205014

Given login to portal as existing bank as a Customeruser 
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Network MemberShip for Rupay
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Rupay for product Credit for BinType as Dual Message Type
When user creates HSM Device Keys for Rupay
When user creates HSM ZPK Network Keys for RPY
When user creates MDK keys for Rupay
When user creates MCG
When user creates message 1100 transaction routing plan for Balance Inquiry with routing code SMS and Send to destination action
When user creates Dedupe Plan
When user creates aggregate load limit plan
When user creates easy pay plan rule
When user creates aggregate load limit plan
When user creates linking API to Institution
When user creates channel Routing plan for Point Of Sale channel and CBS1 interface
When user creates Acount Range Routing plan
When user creates Allowed Load Currency
!-- When user creates Manual Alerts of EMV Card for product type credit 
When user creates Saving account type
When user creates IPKCertificationInformation for interchange Rupay
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



Scenario: Scenario1 - Institution parameter setup for Credit type/ Amex
Meta:
@Regression
@Smoke
@CreditAmex
@TCName AmexInstitutionSetup
@sheetName S205014

Given login to portal as existing bank as a Customeruser
When user creates a Network MemberShip for Amex
When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05
When user creates a Transaction Registration
When user creates an Institution Currency with status as Active
When user creates a Zonal Office
When user creates a Regional Office
When user creates a Branch Office
When user creates a Plastic Code
When user creates Picture Code
When user creates Device BIN for Amex for product Credit for BinType as Dual Message Type
When user creates HSM Device Keys for Amex
When user creates HSM ZPK Network Keys for Amex(DMS)
When user creates MDK keys for Amex
When user creates MCG
When user creates message 1100 transaction routing plan for Balance Inquiry with routing code SMS and Send to destination action
When user creates Dedupe Plan
When user creates aggregate load limit plan
When user creates easy pay plan rule
When user creates aggregate load limit plan
When user creates linking API to Institution
When user creates channel Routing plan for Point Of Sale channel and CBS1 interface
When user creates Acount Range Routing plan
When user creates Allowed Load Currency
!-- When user creates Manual Alerts of EMV Card for product type credit 
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
