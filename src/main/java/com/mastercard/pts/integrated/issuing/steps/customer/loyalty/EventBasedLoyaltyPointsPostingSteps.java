package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPointsPosting;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component
public class EventBasedLoyaltyPointsPostingSteps {
	
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider Provider;

	@Autowired
	private EventBasedLoyaltyPointsPosting eventbasedLoyaltyPointsPosting;

	
	@When("user adds posts the event based loyalty points for product $Product")
	public void addEventBasedLoyaltyPointsposting(String Product){
		Device device = context.get(ContextConstants.DEVICE);
		EventBasedLoyaltyPlan eventbasedLoyaltyPlan = context.get(ContextConstants.EVENT_BASED_LOYALTY_PLAN);
		eventbasedLoyaltyPointsPosting.setDeviceNumber(device.getDeviceNumber());
		eventbasedLoyaltyPointsPosting.setEventName(eventbasedLoyaltyPlan.buildDescriptionAndCode());
		eventbasedLoyaltyPointsPosting.setProductType(ProductType.fromShortName(Product));
		eventbasedLoyaltyPointsPosting.setMemo("MEMO");
		uiVerificationLoyaltyWorkflow.addEventBasedLoyaltyPointsposting(eventbasedLoyaltyPointsPosting);
	}

}
