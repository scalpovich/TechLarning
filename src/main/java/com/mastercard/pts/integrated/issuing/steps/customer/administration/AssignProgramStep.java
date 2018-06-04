package com.mastercard.pts.integrated.issuing.steps.customer.administration;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.workflows.customer.administration.AssignProgramWorkflow;

@Component
public class AssignProgramStep {

	@Autowired
	AssignProgramWorkflow assignProgramWorkflow;

	@Autowired
	private TestContext context;


	@When("user assign service code to program")
	public void assignServiceCodeToProgram(){
		if(System.getProperty("env").equalsIgnoreCase("stageSA")){
			Program	program = context.get(ContextConstants.PROGRAM);
			assignProgramWorkflow.assignServiceCodeToProgram(program);
		}
	}
}
