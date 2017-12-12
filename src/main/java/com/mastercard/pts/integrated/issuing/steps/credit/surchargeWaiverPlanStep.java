package com.mastercard.pts.integrated.issuing.steps.credit;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SurchargeWailverPlanPage;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.workflows.credit.SurchargeWaiverPlanWorkflow;

@Component
public class surchargeWaiverPlanStep {
	private static final Logger logger = LoggerFactory.getLogger(surchargeWaiverPlanStep.class);
	@Autowired
	 SurchargeWailverPlanPage surchargeWailverPlanPage;
	
	@Autowired
	 SurchargeWailverPlan surchargeWailverPlan;
	@Autowired
     SurchargeWaiverPlanWorkflow surchargeWaiverPlanWorkflow;
	@Autowired
	DatePicker datePicker;
	
	//@Then("surchargeWaiverPlan of card management tab has proper field validation")
	@When("surchargeWaiverPlan of card management tab has proper field validation for below fields:$tagTable")
	public void thenSurchargeWaiverPlanOfCardManagementTabHasProperValidation(ExamplesTable tagTable) {
		surchargeWailverPlan.surchargeWaiverFeePlanDataProvider();
		for (int i = 0; i < tagTable.getRows().size(); i++) {

			String tagName = tagTable.getRow(i).get(
					tagTable.getHeaders().get(0));
			String expTagvalue = tagTable.getRow(i).get(
					tagTable.getHeaders().get(1));
			
	         logger.info("Value of i"+i+"tagname"+tagName+"expected"+expTagvalue);
	         surchargeWaiverPlanWorkflow.verifyValidSurchargeWaiverPlanCode(surchargeWailverPlan,datePicker,tagName,expTagvalue);

		}
		
		
	}
	@Then("surchargeWaiverPlan of card management tab has proper field validation for Invalid scenario")
	public void thenSurchargeWaiverPlanOfCardManagementTabHasProperValidationInvalid() {
		surchargeWailverPlan.surchargeWaiverFeePlanDataProvider();
		surchargeWaiverPlanWorkflow.verifyInvalidSurchargeWaiverPlanCode(surchargeWailverPlan);
		
	}
	

}
