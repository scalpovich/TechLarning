package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.WalletType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WalletPlanFlows;

import junit.framework.Assert;

@Component
public class WalletPlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	WalletPlan plan;

	@Autowired
	WalletPlanFlows walletplanflows;

	@When("user creates a Open loop wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAopenloopWalletPlan(@Named("walletType") String walletType,
			@Named("Programtype") String programType, @Named("product") String product) {
		WalletPlan.walletplanDataprovider();
		plan.setWalletType(walletType);
		plan.setProgramType(programType);
		deviceCreation.setProduct(product);
		String walletPlan = "";
		if (walletType.contains(WalletType.DEFAULT_WALLET)) {
			walletPlan = walletplanflows.createOpenWalletPlan(deviceCreation, plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMCG_WALLET)) {
			walletPlan = walletplanflows.createClosedWhitelistedMCGWalletPlan(deviceCreation, plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMERCHANT_WALLET)) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(deviceCreation, plan);
		}

		Assert.assertNotNull(walletPlan);
		plan.setOpenloopWalletPlan(walletPlan);
	}

	@When("user creates a Closed loop wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAclosedloopWalletPlan(@Named("walletType") String walletType,
			@Named("Programtype") String programType, @Named("product") String product) {
		WalletPlan.walletplanDataprovider();
		plan.setWalletType(walletType);
		plan.setProgramType(programType);
		deviceCreation.setProduct(product);
		String walletPlan = "";
		if (walletType.contains(WalletType.DEFAULT_WALLET)) {
			walletPlan = walletplanflows.createClosedWalletPlan(deviceCreation, plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMCG_WALLET)) {
			walletPlan = walletplanflows.createClosedWhitelistedMCGWalletPlan(deviceCreation, plan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMERCHANT_WALLET)) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(deviceCreation, plan);
		}
		Assert.assertNotNull(walletPlan);
		plan.setClosedloopWalletPlan(walletPlan);
	}
	
	@When("user creates Wallet Plan for $ProgramType") 
	public void createCreditWalletPlan(@Named("ProgramType") String programType) {
		plan = WalletPlan.getWalletPlanDataFromExcel();
		plan.setProgramType(programType);
		walletplanflows.createCreditWalletPlanForWhiteListedMCG(plan);
	}
	
	@Then("wallet plan should get created successfully")
	public void verifySurchargePlan() {
		Assert.assertEquals(ConstantData.RECORD_ADDED_SUCCESSFULLY, walletplanflows.getFeedbackText());
	}

}