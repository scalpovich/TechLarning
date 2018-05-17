package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCG;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MCGFlows;

@Component
public class MCGSteps {

	@Autowired
	MCGFlows mcgflows;

	@Autowired
	MCG mcg;
	
	@Autowired
	KeyValueProvider provider;
	
	@When("user creates MCG")	
	public void whenUserCreatesMCG() {
		mcg = MCG.getMCGDetails(provider);
		mcgflows.addMCG(mcg);
	}
	
	@When("user creates MCG with MCC")	
	public void whenUserCreatesMCGwithMCC() {
		mcg = MCG.getMCGDetails(provider);
	    mcgflows.addMCGwithMCC(mcg);
	}
}