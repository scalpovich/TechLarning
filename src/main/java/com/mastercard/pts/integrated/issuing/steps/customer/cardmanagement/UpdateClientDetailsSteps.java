package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ClientDetails;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.UpdateClientDetailsFlows;

@Component
public class UpdateClientDetailsSteps {

	@Autowired
	KeyValueProvider provider;
	
	@Autowired
	UpdateClientDetailsFlows updateClientDetailsFlows;

	private ClientDetails clientDetails;

	@When("user updates client details")
	public void updateClientDetails() {
		clientDetails = ClientDetails.getClientDetails(provider);
		updateClientDetailsFlows.updateClientDetails(clientDetails);
	}

}
