package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionRoutingPlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionRoutingFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstitutionSetupCredit, InstitutionSetupDebit ,InstitutionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class TransactionRoutingSteps {
	
	@Autowired
	TransactionRoutingFlows transactionRoutingFlows;
	
	@When("user creates message $messagecode transaction routing plan for $transactionType with routing code $routingCode and $Action action")
	public void whenUserCreatesTransactionRoutingPlan(@Named("messagecode") String messageType,@Named("transaction") String transactionType,@Named("RoutingCode") String routingCode,@Named("Action") String action) {
		TransactionRoutingPlan transRoutingPlan= new TransactionRoutingPlan();
		transRoutingPlan.setActionDdwn(action);
		transRoutingPlan.setMessageTypeDdwn(messageType);
		transRoutingPlan.setRoutingCodeDdwn(routingCode);
		transRoutingPlan.setTransactionTypeDdwn(transactionType);
		transactionRoutingFlows.addTransactionRouting(transRoutingPlan);
		
		
	}
	
}
