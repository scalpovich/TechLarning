package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.util.Objects;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
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
    
    @Autowired
   	private KeyValueProvider keyValueProvider;
    
    @Autowired
	private TestContext context;
    
    private LoanPlan loanPlan;
    
    private Program program;
	

	@When("user adds loan plan")
	public void userAddsLoanplan() {
		loanPlan=LoanPlan.getLoanPlanData();
		LoanType loanTypedata=context.get(ConstantData.LOAN_TYPE_OBJECT);
		loanPlanFlows.addLoanPlan(loanPlan,loanTypedata);
	}
	
	@When("user creates loan plan for $type")
	public void userCreateLoanPlan(String type) { 		
		loanPlan = LoanPlan.dataProvider(keyValueProvider);		
		if(Objects.nonNull(context.get(ContextConstants.PROGRAM))){
			program = context.get(ContextConstants.PROGRAM);		
			loanPlan.setProgramCode(program.buildDescriptionAndCode());
		}
		loanPlanFlows.addLoanPlan(loanPlan);
	}
}
