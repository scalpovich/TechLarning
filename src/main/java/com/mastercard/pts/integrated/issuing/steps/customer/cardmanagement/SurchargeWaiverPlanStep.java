package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWaiverPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.SurchargeWaiverPlanWorkflow;

/**
 * @author e076177
 *
 */
@Component
public class SurchargeWaiverPlanStep {
	@Autowired
	KeyValueProvider provider;
	@Autowired
	 SurchargeWaiverPlan surchargeWailverPlan;
	@Autowired
     SurchargeWaiverPlanWorkflow surchargeWaiverPlanWorkflow;
	

	@When("User Adds Surcharge Waiver Fee Plan by entering valid values")
	public void thenSurchargeWaiverPlanOfCardManagementTab() {
	surchargeWailverPlan=SurchargeWaiverPlan.surchargeWaiverFeePlanDataProvider(provider);	
	surchargeWaiverPlanWorkflow.addValidSurchargeWaiverPlan(surchargeWailverPlan);
		
	}
	
	@When("User Adds Surcharge Waiver Detail Fee Plan by entering valid values")
	public void thenSurchargeWaiverPlanDetailOfCardManagementTab() {
	surchargeWaiverPlanWorkflow.addSurchargeWaiverPlanDetails(surchargeWailverPlan);
		
	}
	
	@Then("user searches the added Surcharge Waiver Detail Fee Plan based on filter Values")
	public void whenUserVerifiesRecordAddedBasedOnFilter()
	{
		surchargeWaiverPlanWorkflow.verifyRecordsInTableBasedOnFilter();
	}
	@Then("user verifies edit operation of added Surcharge Waiver Detail Fee Plan")
	public void whenUserVerifiesAndEditSurchargeWaiverPlan()
	{
		surchargeWaiverPlanWorkflow.verifyEditOperationForAddedRecord();
	}
	@Then("user verifies delete operation of added Surcharge Waiver Detail Fee Plan")
	public void whenUserVerifiesAndDeleteSurchargeWaiverPlan()
	{
		surchargeWaiverPlanWorkflow.verifyDeleteOperationForAddedRecord();
	}
}
