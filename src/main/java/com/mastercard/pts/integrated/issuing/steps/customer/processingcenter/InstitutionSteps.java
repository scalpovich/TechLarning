package com.mastercard.pts.integrated.issuing.steps.customer.processingcenter;

import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.InstitutionCreationWorkflow;

@Component
public class InstitutionSteps {
	private static final Logger logger = LoggerFactory.getLogger(InstitutionSteps.class);

	@Autowired
	private InstitutionCreationWorkflow institutionCreationWorkflow;

	@Autowired
	private DataProvider provider;
	
	@Autowired
	private TestContext context;
	
	@When("create new institution")
	public void newInstitutionCreation(){
		context.put("NEW_INSTITUION_CREATED", false);
		Institution inst=Institution.createWithProvider(provider);
		if(institutionCreationWorkflow.isInstituteNotPresent(inst)){
			institutionCreationWorkflow.createNewInstitute(inst);
			context.put("NEW_INSTITUION_CREATED", true);
		}
		else
			logger.error("institution is already available in system");
	}
	
}
