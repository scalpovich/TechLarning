package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;


@Component
public class CardHolderPortalMenuConfigSteps extends AbstractBaseFlows{
	
	@Autowired
	private TestContext context;
	
	@Then ("add menus to access card holder portal")
	@When ("add menus to access card holder portal")
	public void addMenuAcessToCardHolderPortal(){		
		chpMenuConfig.navigateToCardHolderPortalPage();
		Program program = context.get(ContextConstants.PROGRAM);		
		chpMenuConfig.addMenuOptionsToaccess(program.getProduct(),program.getProgramCodeDevice());
	}
}
