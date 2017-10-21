package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.PlasticCodeFlows;

@Component
public class PlasticCodeSteps {

	@Autowired
	PlasticCodeFlows plasticcodeflows;

	@Autowired
	PlasticCode plasticcode;

	@When("user creates a Plastic Code")
	public void whenUserCreatesAPlascticCode() {
		plasticcode = PlasticCode.plasticcodeDataprovider();
		String PlasticCode = plasticcodeflows.addPlasticCode(plasticcode);
		plasticcode.setPlasticCodeNumber(PlasticCode);

	}
}