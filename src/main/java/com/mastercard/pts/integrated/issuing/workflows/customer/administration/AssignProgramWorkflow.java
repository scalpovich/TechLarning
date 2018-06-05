package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.AssignProgramPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AssignProgramWorkflow {

	@Autowired
	private Navigator navigator;
	
	public void assignServiceCodeToProgram(Program program)
	{
		AssignProgramPage page=navigator.navigateToPage(AssignProgramPage.class);
		page.addServiceCodeToProgram(program);
	}
}
