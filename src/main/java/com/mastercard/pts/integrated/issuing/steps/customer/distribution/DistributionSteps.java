package com.mastercard.pts.integrated.issuing.steps.customer.distribution;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Order;
import com.mastercard.pts.integrated.issuing.domain.customer.distribution.Dispatch;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.distribution.DistributionWorkflow;


@Component
public class DistributionSteps {
	private static final String CARD_PACKID_CREATION_MESSAGE = "Dispatched sucessfully with Dispatch Number";
	@Autowired
	private TestContext context;
	
	@Autowired
	private DistributionWorkflow distributionWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Given("user fills quantity to be dispatched and submits the form")
	@When("user fills quantity to be dispatched and submits the form")
	public void whenUserFillsQuantityToBeDispatchedAndSubmitsTheForm(){
		Order order = context.get(ContextConstants.ORDER);
		
		Dispatch dispatch = Dispatch.createWithProvider(provider);
		dispatch.setOrderNumber(order.getOrderNumber());
		String lastCardPackId = distributionWorkflow.dispatchOrder(dispatch);
		dispatch.setLastCardPackId(lastCardPackId);
		context.put(ContextConstants.DISPATCH, dispatch);
	}
	
	@Then("dispatch is successful")
	public void thenDispatchIsSuccessful(){
		assertThat("Order Creation Failed", distributionWorkflow.getCardPackIdCreationMessage(), containsString(CARD_PACKID_CREATION_MESSAGE));
	}

}
