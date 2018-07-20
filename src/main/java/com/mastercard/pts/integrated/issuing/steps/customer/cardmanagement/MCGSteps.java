package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MCG;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MCGFlows;

@Component
public class MCGSteps {

	@Autowired
	MCGFlows mcgflows;

	@Autowired
	MCG mcg;
	
	@When("user creates MCG")	
	public void whenUserCreatesMCG() {
		String MCG = mcgflows.addMCG();
		mcg.setMCG(MCG);
	}
}