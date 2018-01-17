package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.WalletType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WalletPlanFlows;

@Component
public class WalletPlanSteps {

	@Autowired
	WalletPlan plan;

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	WalletPlanFlows walletplanflows;

	@Autowired
	TestContext context;

	@When("user creates a Open loop wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAopenloopWalletPlan(
			@Named("walletType") String walletType,
			@Named("Programtype") String programType,
			@Named("product") String product) {
		plan = WalletPlan.walletplanDataprovider();
		plan.setWalletType(walletType);
		plan.setProgramType(programType);
		plan.setProductType(product);
		String walletPlan = "";
		if (walletType.contains(WalletType.DEFAULT_WALLET)) {
			walletPlan = walletplanflows.createOpenWalletPlan(plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMCG_WALLET)) {
			walletPlan = walletplanflows.createClosedWhitelistedMCGWalletPlan(plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMERCHANT_WALLET)) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(plan);
		}
		plan.setWalletPlan(walletPlan);
		Assert.assertNotNull(walletPlan);
		plan.setOpenloopWalletPlan(walletPlan);
		context.put(ContextConstants.OPEN_WALLET, walletPlan);

	}

	@When("user creates a Closed loop wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAclosedloopWalletPlan(
			@Named("walletType") String walletType,
			@Named("Programtype") String programType,
			@Named("product") String product) {
		plan = WalletPlan.walletplanDataprovider();
		plan.setWalletType(walletType);
		plan.setProgramType(programType);
		plan.setProductType(product);
		String walletPlan = "";
		if (walletType.contains(WalletType.DEFAULT_WALLET)) {
			walletPlan = walletplanflows.createClosedWalletPlan(plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMCG_WALLET)) {
			walletPlan = walletplanflows.createClosedWhitelistedMCGWalletPlan(plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMERCHANT_WALLET)) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(plan);
		}
		Assert.assertNotNull(walletPlan);
		plan.setClosedloopWalletPlan(walletPlan);
		context.put(ContextConstants.CLOSED_WALLET, walletPlan);
	}

	@When("user creates Wallet Plan for $ProgramType")
	public void createCreditWalletPlan(@Named("ProgramType") String programType) {
		plan = WalletPlan.getWalletPlanDataFromExcel();
		plan.setProgramType(programType);
		walletplanflows.createCreditWalletPlanForWhiteListedMCG(plan);
	}

	@Then("wallet plan should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY,walletplanflows.getFeedbackText());
		Assert.assertTrue(walletplanflows.isRecordFoundInTable(plan));
	}

}