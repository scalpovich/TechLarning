package com.mastercard.pts.integrated.issuing.steps.devicecreation;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NewDeviceFlows;

@Component
public class NewDeviceSteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	NewDevice newDevice;

	@Autowired
	Program program;

	@Autowired
	NewDeviceFlows newDeviceflows;

	@When("user configures the device range for Corporate Travel card, single wallet single currency for MagStripe")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRanges() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Emv")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Emv Card",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesEmv() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Mag Stripe Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for MagStripe")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Emv")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Emv Card",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardEmv() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Mag Stripe Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardPhysicalNFC() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for MagStripe")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Single currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Emv")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Emv Card",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Single currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardEmv() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Mag Stripe Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Single currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardPhysicalNFC() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for MagStripe")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Emv")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Magnetic Stripe",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardEmv() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Mag Stripe Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardPhysicalNFC() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Emv Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesEmvPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Emv Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardEmvPaypass() {

		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Emv Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Single currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardEmvPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Emv Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardEmvPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesNFCPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardNFCPaypass() {

		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Single currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardNFCPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Physical NFC Device - Paypass",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardNFCPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Static Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Static Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesStaticVirtual() {

	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Static Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Static Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardStaticVirtual() {

		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Static Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Static Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Single currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardStaticVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Static Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Static Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardStaticVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Limited Validity Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Limited Validity Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesLimitedValidity() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Limited Validity Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Limited Validity Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardLimitedValidity() {

		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Limited Validity Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Limited Validity Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardLimitedValidity() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Limited Validity Virtual Card")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Limited Validity Virtual Card",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardLimitedValidity() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, single wallet single currency for Mobile")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Single currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Mobile",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Single currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createProgramAndDeviceRangesLimitedMobile() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate Travel card, Multi Wallet Multi Currency for Mobile")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Corporate Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Mobile",
			"When user creates a Program for Mastercard for product Prepaid for program Corporate Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Corporate customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesCorporateTravelcardMobile() {

		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Single Wallet Single Currency for Mobile")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Mobile",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelCardMobile() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail Travel card, Multi Wallet Multi Currency for Mobile")
	@Composite(steps = {
			"When user creates a wallet plan of default type for program Retail Travel card - Multi currency for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for product Prepaid for device type as Mobile",
			"When user creates a Program for Mastercard for product Prepaid for program Retail Travel card - Multi currency",
			"When user creates Business Mandatory Fields for Individual customer type from the file BusinessMandatoryFields.xlsx for Prepaid",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesRetailTravelcardMobile() {
		System.out.println("inside composite steps");
	}

	@Then("user should be able to create $DeviceType for $product product for $CustomerType customer")
	public void createNewPrepaidDevice(@Named("DeviceType") String DeviceType, @Named("product") String product,
			@Named("CustomerType") String CustomerType) {
		newDevice.setDeviceType(DeviceType);
		deviceCreation.setProduct(product);
		newDevice.setCustomerType(CustomerType);
		String devicenumber = newDeviceflows.createNewDevicePrepaid();
		newDevice.setDeviceNumber(devicenumber);

	}

}
