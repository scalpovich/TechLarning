package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.WalletFeePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.WalletFeePlanFlows;

@Component
public class WalletFeePlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	public WalletFeePlan walletfeeplan;

	@Autowired
	WalletFeePlanFlows walletfeeplanflows;

	@When("user creates $type Wallet Fee Plan for $product")
	public void whenUserCreatesMaintenanceWalletFeePlanForPrepaid(@Named("type") String type,
			@Named("product") String product) {
		walletfeeplan = WalletFeePlan.walletfeeplanDataProvider();
		deviceCreation.setProduct(product);
		walletfeeplan.setWalletFeePlanType(type);
		walletfeeplanflows.createWalletFeePlan(deviceCreation, walletfeeplan);
	}
}