package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;


import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarkupFeePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MarkUpFeeWorkflow;

@Component 
public class MarkUpFeePlanSteps{

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private MarkUpFeeWorkflow markUpFeeWorkflow;
	
	@When("user creates a mark up fee plan")
	public void createMarkupFeePlan(){
		MarkupFeePlan plan = MarkupFeePlan.createWithProvider(provider);
		markUpFeeWorkflow.addMarkUpPlan(plan);
	}
}