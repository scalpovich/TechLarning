package com.mastercard.pts.integrated.issuing.steps;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DatabaseFlows;

@Component
public class DatabaseSteps {


	@Autowired
	DatabaseFlows dbFlow;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private DBUtility dbUtils;

	@When("update institution date to first of next month")
	@Given("update institution date to first of next month")
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
	
	@Then("loyalty plan expiry date is updated to $expiryDate")
	public void updateLoyaltyExpiryDateTo(String expiryDate) {
		Device device = context.get(ContextConstants.DEVICE);
		dbFlow.updateLoyaltyExpiryDate(expiryDate, device.getDeviceNumber());
	}

	@Then("add adjustment transaction of $amount at backend")
	public void addAdjustmentTransaction(String amount) {
		Device device = context.get(ContextConstants.DEVICE);
		dbFlow.addAdjustmentTransaction(device.getDeviceNumber(), context.get(Constants.USER_INSTITUTION_SELECTED), amount);
	}
	
	@Then("activate loyalty plan")
	public void activateLoyaltyPlan() {
		InstitutionData data = context.get(CreditConstants.JSON_VALUES);
		String plan = data.getLoyaltyPlan();
		dbFlow.activateLoyaltyPlan(plan.substring(plan.indexOf("[")+1, plan.indexOf("]")), context.get(Constants.USER_INSTITUTION_SELECTED));
	}

	@When("promotion plan $plan expiry date is updated to $expiryDate")
	@Then("promotion plan $plan expiry date is updated to $expiryDate")
	public void updatePromotionExpiryDateTo(String plan, String expiryDate) {
		String currentDateString = dbUtils.getCurrentDateForInstitution(context.get(Constants.USER_INSTITUTION_SELECTED));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
	    LocalDateTime dateTime = LocalDateTime.parse(currentDateString, formatter);
	    if(expiryDate.equals("yesterday"))
			dateTime = dateTime.minusDays(1);
		else
			dateTime = dateTime.plusYears(10);
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yy");
	    expiryDate = dateTime.format(formatter1);
		dbFlow.updatePromotionExpiryDate(expiryDate, plan, context.get(Constants.USER_INSTITUTION_SELECTED));
	}
}
