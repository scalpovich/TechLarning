package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;



import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListReasonPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.StopListReasonWorkflow;

@Component
public class StopListReasonSteps {

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private StopListReasonWorkflow stopListReasonWorkflow;

	

	@Then("user add all raesons in stoplist reason page")
	public void thenUserCanAddStopListReasonInStoplistReasonPage() {
		StopListReasonPlan listReasonPlan = StopListReasonPlan.createWithProvider(provider);
		stopListReasonWorkflow.addStopListReasonPlan(listReasonPlan);
	}
}
