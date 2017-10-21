package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
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
			Program = programflows.createprogramPrepaid(devicecreation, program);
		}

		if (product.contains("Prepaid") && programType.contains("Corporate Gift Card")
				|| programType.contains("Retail General Purpose")) {
			Program = programflows.createprogramPrepaid(devicecreation, program);
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
}