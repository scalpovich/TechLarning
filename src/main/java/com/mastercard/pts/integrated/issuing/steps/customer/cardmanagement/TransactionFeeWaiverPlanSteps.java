package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeeWaiverPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionFeeWaiverPlanFlows;

@Component
public class TransactionFeeWaiverPlanSteps {
	
	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private TransactionFeeWaiverPlanFlows transactionFeeWaiverPlanFlows;

	@When("user creates a transaction fee waiver")
	public void createTransactionFeeWaiverPlan(){
		TransactionFeeWaiverPlan plan=TransactionFeeWaiverPlan.createWithProvider(provider);
		transactionFeeWaiverPlanFlows.addTransactionFeeWaiverPlanForMultipleType(plan);
	}
}

	
	
	
	
	
	
	
	
	


