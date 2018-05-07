package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanType;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
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
    
	@Autowired
	private TestContext context;

	@When("user adds loan plan")
	public void userAddsLoanplan() {
		loanPlan=LoanPlan.getLoanPlanData();
		LoanType loanTypedata=context.get(ConstantData.LOAN_TYPE_OBJECT);
		loanPlanFlows.addLoanPlan(loanPlan,loanTypedata);
	}

}
