package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LinkingAPIToInstitution;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LinkingAPIFlow;

@Component
public class LinkingAPIStep  {
 
	@Autowired
	LinkingAPIToInstitution linkingAPIToInstitution;
	
	@Autowired
	LinkingAPIFlow  linkingAPIflow;
	
	@When("user creates linking API to Institution")
	public void userCreatesLinkingAPI() {
		linkingAPIToInstitution=LinkingAPIToInstitution.linkingAPIInstitutionDataProvider();
		linkingAPIflow.addLinkingAPIDetails(linkingAPIToInstitution);

	}
	
}
