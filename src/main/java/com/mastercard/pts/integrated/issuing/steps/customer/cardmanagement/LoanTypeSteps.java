package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanType;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoanTypeFlows;

/**
 * @author E076170
 * 
 *
 */

@Component
public class LoanTypeSteps extends AbstractBaseSteps {
    @Autowired
    private LoanTypeFlows loanTypeFlows;
    
    private LoanType loanType;

	@When("user adds loan type")
	public void userAddsLoanType() {
		loanType=LoanType.getLoanTypeData();
		loanTypeFlows.addLoanType(loanType);
	}

}
