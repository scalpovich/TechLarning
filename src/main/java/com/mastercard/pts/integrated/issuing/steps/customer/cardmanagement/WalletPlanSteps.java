package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WalletPlanFlows;

@Component
public class WalletPlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	public WalletPlan walletplan;

	@Autowired
	WalletPlanFlows walletplanflows;

	@When("user creates a wallet plan of $walletType type for program $Programtype for $product")
	public void whenUserCreatesAWhiteListedMerchantWalletPlan(@Named("walletType") String walletType,
			@Named("Programtype") String Programtype, @Named("product") String product) {
		String walletPlan = "";
		walletplan = WalletPlan.walletplanDataprovider();
		walletplan.setWalletType(walletType);
		walletplan.setProgramType(Programtype);
		deviceCreation.setProduct(product);
		if (walletType.contains("default")) {
			walletPlan = walletplanflows.createWalletPlan(deviceCreation, walletplan);
		}
		if (walletType.contains("White listed MCG")) {
			walletPlan = walletplanflows.createWhitelistedMCGWalletPlan(deviceCreation, walletplan);
		}
		if (walletType.contains("White listed Merchant")) {
			walletPlan = walletplanflows.createWhitelistedMerchantWalletPlan(deviceCreation, walletplan);
		}

		walletplan.setWalletPlan(walletPlan);

	}

}