package com.mastercard.pts.integrated.issuing.steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DatabaseFlows;

@Component
public class DatabaseSteps {


	@Autowired
	DatabaseFlows dbFlow;
	
	@Autowired
	private TestContext context;
	
	@When("update institution date to first of next month")
	@Given("update institution date to first of next month")
	@Then("update institution date to first of next month")
	public void updateInstituteDate(){
			dbFlow.updateInstituteDateToFirstOfNextMonth(context.get(ContextConstants.INSTITUTION_DATE));
	}

	@Given("Verify $columnname has column value as $type")
	@Then("Verify $columnname has column value as $type")
	public void executeQueryToGetApplicationBlockStatus(String columnName, String expectedColumnValue) {

		Device device = context.get(ContextConstants.DEVICE);
		dbFlow.assertColumnStatus(device, columnName, expectedColumnValue);
	}
	
	@Given("update institution date to $noOfDays days")
	@When("update institution date to $noOfDays days")
	@Then("update institution date to $noOfDays days")
	public void updateInstitutionDateToNextDay(String noOfDays)
	{
		dbFlow.updateInstituteDateToGivenDays(context.get(ContextConstants.INSTITUTION_DATE),noOfDays);
	}
}
