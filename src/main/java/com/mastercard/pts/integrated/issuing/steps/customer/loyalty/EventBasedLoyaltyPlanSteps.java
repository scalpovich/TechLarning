package com.mastercard.pts.integrated.issuing.steps.customer.loyalty;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.EventBasedLoyaltyPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.loyalty.PromotionPlan;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ProductType;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.loyalty.UiVerificationLoyaltyWorkflow;

@Component
public class EventBasedLoyaltyPlanSteps {
	
	@Autowired
	private UiVerificationLoyaltyWorkflow uiVerificationLoyaltyWorkflow;

	@Autowired
	private TestContext context;

	@Autowired
	private KeyValueProvider Provider;

	@Autowired
	private EventBasedLoyaltyPlan eventbasedLoyaltyPlan;

	
	@When("user adds event based loyalty plan for product $Product and type $Type")
	public void addEventBasedLoyaltyPlan(String Product , String Type){
	eventbasedLoyaltyPlan = EventBasedLoyaltyPlan.createWithProvider(Provider);
	eventbasedLoyaltyPlan.setProductType(ProductType.fromShortName(Product));
	eventbasedLoyaltyPlan.setType(ProductType.fromShortName(Type));
	context.put(ContextConstants.EVENT_BASED_LOYALTY_PLAN, eventbasedLoyaltyPlan);
	uiVerificationLoyaltyWorkflow.addEventBasedLoyaltyPlan(eventbasedLoyaltyPlan);
	}

}
