package com.mastercard.pts.integrated.issuing.steps.credit;

import org.jbehave.core.annotations.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SurchargeWailverPlanPage;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.workflows.credit.SurchargeWaiverPlanWorkflow;

@Component
public class surchargeWaiverPlanStep {
	@Autowired
	 SurchargeWailverPlanPage surchargeWailverPlanPage;
	@Autowired
	 SurchargeWailverPlan surchargeWailverPlan;
	@Autowired
     SurchargeWaiverPlanWorkflow surchargeWaiverPlanWorkflow;
	@Autowired
	DatePicker datePicker;

	@Then("User navigates to Add Surcharge Waiver Fee Plan Page and adds a valid Fee Plan by entering valid values")
	public void thenSurchargeWaiverPlanOfCardManagementTab() {
		surchargeWailverPlan.surchargeWaiverFeePlanDataProvider();
		surchargeWaiverPlanWorkflow.verifyValidSurchargeWaiverPlanCode(surchargeWailverPlan);
		
	}
	@Then("User navigates to Add Surcharge Waiver Detail Fee Plan Page and adds a valid plan by entering valid values")
	public void thenSurchargeWaiverPlanDetailOfCardManagementTab() {
	surchargeWaiverPlanWorkflow.addSurchargeWaiverPlanDetails(surchargeWailverPlan,datePicker);
		
	}
	

}
