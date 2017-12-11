package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.WalletType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WalletPlanFlows;

@Component
public class WalletPlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	WalletPlan walletplan;

	@Autowired
	WalletPlanFlows walletplanflows;

	@When("user creates a Open loop wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAopenloopWalletPlan(@Named("walletType") String walletType,
			@Named("Programtype") String programType, @Named("product") String product) {
		WalletPlan.walletplanDataprovider();
		walletplan.setWalletType(walletType);
		walletplan.setProgramType(programType);
		deviceCreation.setProduct(product);
		String walletPlan = "";
		if (walletType.contains(WalletType.DEFAULT_WALLET)) {
			walletPlan = walletplanflows.createOpenWalletPlan(deviceCreation, walletplan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMCG_WALLET)) {
			walletPlan = walletplanflows.createClosedWhitelistedMCGWalletPlan(deviceCreation, walletplan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMERCHANT_WALLET)) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(deviceCreation, walletplan);
		}

		Assert.assertNotNull(walletPlan);
		walletplan.setOpenloopWalletPlan(walletPlan);
	}

	@When("user creates a Closed loop wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAclosedloopWalletPlan(@Named("walletType") String walletType,
			@Named("Programtype") String programType, @Named("product") String product) {
		WalletPlan.walletplanDataprovider();
		walletplan.setWalletType(walletType);
		walletplan.setProgramType(programType);
		deviceCreation.setProduct(product);
		String walletPlan = "";
		if (walletType.contains(WalletType.DEFAULT_WALLET)) {
			walletPlan = walletplanflows.createClosedWalletPlan(deviceCreation, walletplan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMCG_WALLET)) {
			walletPlan = walletplanflows.createClosedWhitelistedMCGWalletPlan(deviceCreation, walletplan);
		}
		if (walletType.contains(WalletType.WHITELISTEDMERCHANT_WALLET)) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(deviceCreation, walletplan);
		}
		Assert.assertNotNull(walletPlan);
		walletplan.setClosedloopWalletPlan(walletPlan);
	}

}