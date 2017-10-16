package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//TODO: Auto-generated Javadoc
/**
 * @author e074127 Institution Creation Steps
 */
@Component
public class InstitutionSetUpSteps {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@When("user creates institution setup for prepaid type mastercard")
	@Composite(steps = {
			"When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05",
			"When user creates a Network MemberShip for Mastercard",
			"When user creates a Transaction Registration",
			"When user creates an Institution Currency with status as Active",
			"When user creates a Zonal Office",
			"When user creates a Regional Office",
			"When user creates a Branch Office",
			"When user creates a Plastic Code",
			"When user creates Picture Code",
			"When user creates Device BIN for Mastercard for product Prepaid for BinType as Dual Message Type",
			"When user creates Device BIN for Mastercard for product Prepaid for BinType as Single Message Type",
			"When user creates MCG",
			"When user creates Dedupe Plan",
			"When user creates Saving account type",
			"When user creates IPKCertificationInformation for interchange Mastercard",
			"When user creates a Statement Message Plan for Prepaid",
			"When user creates Marketing Message Plan for Prepaid",
			"When user creates Prepaid Statement Plan",
			"When user creates Transaction Plan for Prepaid and transaction type Purchase/Auth Completion",
			"When user creates Transaction Limit Plan for Prepaid and plan type as Device/Wallet/Promotion Entity Plan",
			"When user creates Document checklist for Prepaid for document type Passport",
			"When user creates Template of type Device Template and of length 24",
			"When user creates Template of type Card Pack ID Template and of length 24",
			"When user creates DeviceJoining Fee plan for Prepaid",
			"When user creates Membership Fee plan for Prepaid",
			"When user creates Device Event Based Fee Plan for Prepaid",
			"When user creates Maintenance Wallet Fee Plan for Prepaid",
			"When user creates a wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createInstitutionPrepaidMC() {

	}

	@When("user creates institution setup for prepaid type visa")
	@Composite(steps = {
			"When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05",
			"When user creates a Network MemberShip for Visa",
			"When user creates a Transaction Registration",
			"When user creates an Institution Currency with status as Active",
			"When user creates a Zonal Office",
			"When user creates a Regional Office",
			"When user creates a Branch Office",
			"When user creates a Plastic Code",
			"When user creates Picture Code",
			"When user creates Device BIN for Visa for product Prepaid for BinType as Dual Message Type",
			"When user creates Device BIN for Visa for product Prepaid for BinType as Single Message Type",
			"When user creates MCG",
			"When user creates Dedupe Plan",
			"When user creates Saving account type",
			"When user creates IPKCertificationInformation for interchange Visa",
			"When user creates a Statement Message Plan for Prepaid",
			"When user creates Marketing Message Plan for Prepaid",
			"When user creates Prepaid Statement Plan",
			"When user creates Transaction Plan for Prepaid and transaction type Purchase/Auth Completion",
			"When user creates Transaction Limit Plan for Prepaid and plan type as Device/Wallet/Promotion Entity Plan",
			"When user creates Document checklist for Prepaid for document type Passport",
			"When user creates Template of type Device Template and of length 24",
			"When user creates Template of type Card Pack ID Template and of length 24",
			"When user creates DeviceJoining Fee plan for Prepaid",
			"When user creates Membership Fee plan for Prepaid",
			"When user creates Device Event Based Fee Plan for Prepaid",
			"When user creates Maintenance Wallet Fee Plan for Prepaid",
			"When user creates a wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createInstitutionPrepaidVisa() {

	}

	@When("user creates institution setup for prepaid type Rupay")
	@Composite(steps = {
			"When user creates a Cutover profile with cutover hours as 00 and cutover minutes as 05",
			"When user creates a Network MemberShip for Rupay",
			"When user creates a Transaction Registration",
			"When user creates an Institution Currency with status as Active",
			"When user creates a Zonal Office",
			"When user creates a Regional Office",
			"When user creates a Branch Office",
			"When user creates a Plastic Code",
			"When user creates Picture Code",
			"When user creates Device BIN for Rupay for product Prepaid for BinType as Dual Message Type",
			"When user creates Device BIN for Rupay for product Prepaid for BinType as Single Message Type",
			"When user creates MCG",
			"When user creates Dedupe Plan",
			"When user creates Saving account type",
			"When user creates IPKCertificationInformation for interchange Rupay",
			"When user creates a Statement Message Plan for Prepaid",
			"When user creates Marketing Message Plan for Prepaid",
			"When user creates Prepaid Statement Plan",
			"When user creates Transaction Plan for Prepaid and transaction type Purchase/Auth Completion",
			"When user creates Transaction Limit Plan for Prepaid and plan type as Device/Wallet/Promotion Entity Plan",
			"When user creates Document checklist for Prepaid for document type Passport",
			"When user creates Template of type Device Template and of length 24",
			"When user creates Template of type Card Pack ID Template and of length 24",
			"When user creates DeviceJoining Fee plan for Prepaid",
			"When user creates Membership Fee plan for Prepaid",
			"When user creates Device Event Based Fee Plan for Prepaid",
			"When user creates Maintenance Wallet Fee Plan for Prepaid",
			"When user creates a wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Rupay for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Rupay for product Prepaid for program Retail General Purpose",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createInstitutionPrepaidRupay() {

	}

}