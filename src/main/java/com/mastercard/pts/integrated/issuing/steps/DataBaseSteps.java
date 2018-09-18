package com.mastercard.pts.integrated.issuing.steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DatabaseFlows;

@Component
public class DataBaseSteps {


	@Autowired
	DatabaseFlows dbFlow;
	
	@Autowired
	private TestContext context;

	
	@Given("Verify $type has column value as null")
	public void executeQueryToGetApplicationBlockStatus(String columnName) {

		Device device = context.get(ContextConstants.DEVICE);
		dbFlow.executeQueryToGetStatusAsNull(device, columnName);
	}

	@Given("Verify $type has column value as not null")
	public void executeQueryToGetApplicationBlockStatusAsNotNulll(String columnName) {

		Device device = context.get(ContextConstants.DEVICE);
		dbFlow.executeQueryToGetStatusNotNull(device, columnName);
	}

}