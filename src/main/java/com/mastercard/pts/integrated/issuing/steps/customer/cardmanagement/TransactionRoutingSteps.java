package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionRoutingPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionRoutingFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstituionSetupCredit, InstituionSetupDebit ,InstituionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class TransactionRoutingSteps {
	
	@Autowired
	TransactionRoutingFlows transactionroutingflows;
	
	@When("user creates message $1100 transaction routing plan for $BalanceInquiry with routing code $SMS and $Action action")
	public void whenUserCreatesTransactionRoutingPlan(@Named("Message") String messageType,@Named("transaction") String transactionType,@Named("RoutingCode") String routingCode,@Named("Action") String action) {
		TransactionRoutingPlan transRoutingPlan= new TransactionRoutingPlan();
		transRoutingPlan.setActionDdwn(action);
		transRoutingPlan.setMessageTypeDdwn(messageType);
		transRoutingPlan.setRoutingCodeDdwn(routingCode);
		transRoutingPlan.setTransactionTypeDdwn(transactionType);
		transactionroutingflows.addTransactionRouting(transRoutingPlan);
		
		
	}
	
}
