package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NewDevice;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.NewDeviceFlows;

@Component
public class DeviceCompositeSteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	NewDevice newDevice;

	@Autowired
	Program program;

	@Autowired
	NewDeviceFlows newDeviceflows;

	@When("user configures the device range for Retail General Purpose, Visa, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorporateMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, MC, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCRetailMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, MC, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Magnetic Stripe and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCCorporateMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Emv Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorpEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Visa, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Emv Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Mastercard, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Emv Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMastercardCorpEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Mastercard, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Emv Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMastercardRetailEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Mastercard, Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Physical NFC Device - Mag Stripe Paypass and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCRetailNFCMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Visa, Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Physical NFC Device - Mag Stripe Paypass and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailNFCMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Physical NFC Device - Mag Stripe Paypass and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorporateNFCMSR() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Visa, Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Physical NFC Device - Emv Paypass and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailNFCEmv() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Mastercard, Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCCorporateNFCEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Mastercard, Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCRetailNFCEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorporateNFCEMV() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Mastercard, Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Physical NFC Device - Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCCorporateNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Visa, Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Physical NFC Device - Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Physical NFC Device - Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorporateNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorporateStaticVirtualCard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Mastercard, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCCorporateStaticVirtualCard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Visa, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailStaticVirtualCard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Mastercard, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCRetailStaticVirtualCard() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Visa, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaCorporateLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Corporate General Purpose, Mastercard, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCCorporateLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Visa, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Visa for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesVisaRetailLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user configures the device range for Retail General Purpose, Mastercard, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user creates a Device Plan for Mastercard for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createDeviceRangesMCRetailLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Magnetic Stripe and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailMSR() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Magnetic Stripe and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorporateMSR() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, MC, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Magnetic Stripe and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailMSR() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, MC, MSR")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Magnetic Stripe and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCCorporateMSR() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Emv Card and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorpEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Emv Card and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard, Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Physical NFC Device - Mag Stripe Paypass and Prepaid card,choose activation On Production and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailNFCPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Mastercard,  Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCCorporateNFCEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard,  Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailNFCEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa,  Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorporateNFCEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Physical NFC Device - Mag Stripe Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailNFCPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa, Physical NFC Device - Mag Stripe Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Physical NFC Device - Mag Stripe Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorporateNFCPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, Physical NFC Device - Emv Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Physical NFC Device - Emv Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailNFCEMVPaypass() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Mastercard, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Emv Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCCorporateEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard, EMV")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Emv Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailEMV() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard, Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Physical NFC Device - Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Physical NFC Device - Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa,  Physical NFC Device - Paypass")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Physical NFC Device - Paypass and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorporateNFCDevice() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorporateStaticVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailStaticVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Mastercard, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCCorporateStaticVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard, Static Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Static Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailStaticVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Visa, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaCorporateLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Corporate General Purpose, Mastercard, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Corporate General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Corporate General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCCorporateLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Visa, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Visa for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Visa for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesVisaRetailLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

	@When("user creates a paired device plan and configures the device range for Retail General Purpose, Mastercard, Limited Validity Virtual")
	@Composite(steps = {
			"When user creates a Open loop wallet plan of default type for program Retail General Purpose for Prepaid",
			"When user creates an Embossing File Template",
			"When user creates a Vendor of Category Personalization with Embossing template attached",
			"When user issues paired devices for Mastercard for Limited Validity Virtual Card and Prepaid card,choose activation Manual and delivery mode Mail",
			"When user creates a Single wallet Program for Mastercard for product Prepaid for program Retail General Purpose",
			"When user creates a Device Range for product Prepaid" })
	public void createPairedDevicePlanDeviceRangesMCRetailLimitedValidityVirtual() {
		System.out.println("inside composite steps");
	}

}
