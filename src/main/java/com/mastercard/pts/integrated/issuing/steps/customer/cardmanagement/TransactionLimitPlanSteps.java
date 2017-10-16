package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionLimitPlanFlows;

@Component
public class TransactionLimitPlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	public TransactionLimitPlan transactionlimitplan;

	@Autowired
	TransactionLimitPlanFlows transactionlimitplanflows;

	@When("user creates Transaction Limit Plan for $product and plan type as $plan")
	public void whenUserCreatesTransactionLimitPlanForPrepaidAndPlanTypeAsDeviceWalletPromotionEntityPlan(
			@Named("product") String product, @Named("plan") String plan) {
		transactionlimitplan = TransactionLimitPlan.transactionlimitDataProvider();
		deviceCreation.setProduct(product);
		deviceCreation.setPlanType(plan);
		transactionlimitplanflows.createTransactionLimitPlan(deviceCreation, transactionlimitplan);

	}
}