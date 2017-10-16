package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.PrepaidStatementPlanFlows;

@Component
public class PrepaidStatementPlanSteps {

	public PrepaidStatementPlan prepaidstatementplan;

	@Autowired
	PrepaidStatementPlanFlows prepaidstmtflows;

	@When("user creates Prepaid Statement Plan")
	public void whenUserCreatesPrepaidStatementPlan() {
		prepaidstatementplan = PrepaidStatementPlan.prepaidstatementDataprovider();
		String prepaidStmntplan = prepaidstmtflows.createPrepaidStatementPlan(prepaidstatementplan);
		prepaidstatementplan.setPrepaidStatementPlan(prepaidStmntplan);
	}
}