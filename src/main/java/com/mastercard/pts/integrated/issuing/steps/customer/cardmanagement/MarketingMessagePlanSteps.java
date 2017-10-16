package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MarketingMessagePlanFlows;

@Component
public class MarketingMessagePlanSteps {

	@Autowired
	DeviceCreation deviceCreation;

	public MarketingMessagePlan marketingmessageplan;

	@Autowired
	MarketingMessagePlanFlows mktmessagePlanflows;

	@When("user creates Marketing Message Plan for $product")
	public void whenUserCreatesMarketingMessagePlanForPrepaid(@Named("product") String product) {
		deviceCreation.setProduct(product);
		marketingmessageplan = MarketingMessagePlan.marketingmessageprovider();
		String marketingMessagePlan = mktmessagePlanflows.createMarketingMessagePlan(deviceCreation,
				marketingmessageplan);
		marketingmessageplan.setMarketingMessagePlan(marketingMessagePlan);
	}
}