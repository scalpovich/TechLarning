package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.AggregateLoadLimit;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AggregateLoadLimitFlow;

@Component
public class AggregateLoadLimitSteps  {

	@Autowired
	AggregateLoadLimit aggLoadLimit;
	@Autowired
	AggregateLoadLimitFlow aggregateLoadLimitFlow; 
	
	@When("user creates aggregate load limit plan")
	public void userCreatesLinkingAPI() {
		aggLoadLimit=AggregateLoadLimit.createDataProvider();
		aggregateLoadLimitFlow.addAggregateLimitPlan(aggLoadLimit);

	}	
}
