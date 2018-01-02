package com.mastercard.pts.integrated.issuing.workflows.credit;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SurchargeWailverPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;

@Workflow
public class SurchargeWaiverPlanWorkflow {
	@Autowired
	private Navigator navigator;
	@Autowired
	SurchargeWailverPlanPage page;
	
	public void addValidSurchargeWaiverPlan(SurchargeWailverPlan surchargeWailverPlan) {
		page = navigator.navigateToPage(SurchargeWailverPlanPage.class);
		page.enterWaiverPlanValid(surchargeWailverPlan);
		page.addDetailsButtonClick();
		page.addNewButtonClick(); 
		CustomUtils.ThreadDotSleep(3000);
	   }
	public void addSurchargeWaiverPlanDetails(SurchargeWailverPlan surchargeWailverPlan,DatePicker datePicker)
	{       
            page.interchangeSelect();
			page.mcgSelect();
			page.enterWaiverTransactionDescription(surchargeWailverPlan);
			page.effectiveDateSelect(datePicker, surchargeWailverPlan);
			page.endDateSelect(datePicker, surchargeWailverPlan);
			page.enterSurchargeRate(surchargeWailverPlan);
			page.saveButtonClick();
			page.saveButtonClickInner();
			Assert.assertTrue("Record is not added successfully",page.successMessageDiplay());
	}
}
