package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoanPlanFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class LoanPlanSteps extends AbstractBaseSteps {
    @Autowired
    private LoanPlanFlows loanPlanFlows;
    
    private LoanPlan loanPlan;

	@When("user adds loan plan")
	public void userAddsLoanplan() {
		loanPlan=LoanPlan.getLoanPlanData();
		loanPlanFlows.addLoanPlan(loanPlan);
	}

}
