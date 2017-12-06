package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.ProgramType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.NewLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramFlows;

@Component
public class ProgramSteps {

	@Autowired
	DeviceCreation devicecreation;

	@Autowired
	WalletPlan walletplan;

	@Autowired
	DevicePlan deviceplan;

	@Autowired
	StatementMessagePlan statementmessageplan;

	@Autowired
	MarketingMessagePlan marketingmessageplan;

	@Autowired
	PrepaidStatementPlan prepaidstatementplan;

	@Autowired
	Program program;

	@Autowired
	ProgramFlows programflows;
	@Autowired
	NewLoyaltyPlan newLoyaltyPlan;

	@When("user creates a $wallettype wallet Program for $interchange for product $product for program $programType")
	public void whenUserCreatesAProgramForMastercardForProductPrepaidMultiWallet(@Named("wallettype") String walletType,
			@Named("interchange") String interchange, @Named("product") String product,
			@Named("programType") String programType) {
		program.ProgramDataProvider();
		program.setInterchange(interchange);
		devicecreation.setProduct(product);
		program.setProgramType(programType);
		program.setWalletType(walletType);
		program.setWalletPlan1(walletplan.getOpenloopWalletPlan());
		program.setWalletPlan2(walletplan.getClosedloopWalletPlan());
		program.setDevicePlanProgram("DevicePlan" + " " + "["+ deviceplan.getDevicePlan() + "]");
		String Program = "";
		if (product.contains(ProductType.Prepaid) && programType.contains(ProgramType.CORPORATE_GIFT_CARD)
				|| programType.contains(ProgramType.RETAIL_GENERAL_PURPOSE_CARD)
				|| programType.contains(ProgramType.CORPORATE_GENERAL_PURPOSE_CARD)) {
			Program = programflows.createprogramPrepaid(devicecreation, program,newLoyaltyPlan.getLoyaltyPlan());
			sDNUncheckProgram(Program);
		}

		if (product.contains(ProductType.Prepaid)
				&& programType.contains(ProgramType.CORPORATE_TRAVEL_SINGLECURRENCY_CARD)
				|| programType.contains(ProgramType.RETAIL_TRAVEL_SINGLECURRENCY_CARD)
				|| programType.contains(ProgramType.RETAIL_GIFT_CARD)) {
			Program = programflows.createprogramPrepaid(devicecreation, program,newLoyaltyPlan.getLoyaltyPlan());
			sDNUncheckProgram(Program);
		}

		if (product.contains(ProductType.Debit)) {
			Program = programflows.createProgramDebit(devicecreation, program);
		}

		if (product.contains(ProductType.Prepaid)
				&& programType.contains(ProgramType.CORPORATE_TRAVEL_MULTICURRENCY_CARD)
				|| programType.contains(ProgramType.RETAIL_TRAVEL_MULTICURRENCY_CARD)) {
			Program = programflows.createProgramPrepaidMultiCurrency(devicecreation, program);
			sDNUncheckProgram(Program);
		}
		Assert.assertNotNull(Program);
		program.setProgram(Program);

	}

	@When("user creates a Program for $interchange for product $product for program $programType")
	public void whenUserCreatesAProgramForMastercardForProductPrepaid(@Named("interchange") String interchange,
			@Named("product") String product, @Named("programType") String programType) {

		String Program = "";
		program.ProgramDataProvider();
		program.setInterchange(interchange);
		devicecreation.setProduct(product);
		program.setProgramType(programType);
		program.setDevicePlanProgram(deviceplan.getDevicePlan());
		if (product.contains("Prepaid") && programType.contains("Corporate Travel card - Single currency")
				|| programType.contains("Retail Travel card - Single currency")
				|| programType.contains("Corporate General Purpose")) {
			Program = programflows.createprogramPrepaid(devicecreation, program,newLoyaltyPlan.getLoyaltyPlan());
		}

		if (product.contains("Prepaid") && programType.contains("Corporate Gift Card")
				|| programType.contains("Retail General Purpose")) {
			Program = programflows.createprogramPrepaid(devicecreation, program,newLoyaltyPlan.getLoyaltyPlan());
		}

		if (product.contains("Prepaid") && programType.contains("Corporate General Purpose - Multi Wallet")
				|| programType.contains("Retail General Purpose - Multi Wallet")) {
			Program = programflows.createProgramPrepaidMultiCurrency(devicecreation, program);
		}

		if (product.contains("Debit")) {
			Program = programflows.createProgramDebit(devicecreation, program);
		}

		if (product.contains("Prepaid") && programType.contains("Corporate Travel card - Multi currency")
				|| programType.contains("Retail Travel card - Multi currency")) {
			Program = programflows.createProgramPrepaidMultiCurrency(devicecreation, program);
		}
		program.setProgramCode(Program);
	}
	public void sDNUncheckProgram(String value) {
		String[] a = value.split("\\[");
		String[] b = a[1].split("\\]");

		programflows.programEdit(b[0]);
		program.setProgramCode(b[0]);
	}
	@Then("Program should get created")
	public void VerifyProgramSuccess() {
		programflows.VerifyProgramSuccess();
	}
}