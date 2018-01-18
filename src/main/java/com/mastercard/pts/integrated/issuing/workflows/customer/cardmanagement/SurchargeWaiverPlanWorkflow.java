package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWaiverPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.SurchargeWaiverPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;

/**
 * @author e076177
 *
 */
@Workflow
public class SurchargeWaiverPlanWorkflow {
	@Autowired
	private Navigator navigator;
	@Autowired 
	DatePicker datePicker;
	private SurchargeWaiverPlanPage page;
	
	public void addValidSurchargeWaiverPlan(SurchargeWaiverPlan surchargeWailverPlan) {
		page = navigator.navigateToPage(SurchargeWaiverPlanPage.class);
		page.addButtonToEnterSurchargeWaiverPlanFrame();
		page.addMandatoryLabelsAndFields();
		page.enterSurchargeWaiverPlanCode(surchargeWailverPlan);
		page.enterSurchargeWaiverPlanDescription(surchargeWailverPlan);
		page.selectCurrency();
		page.settingMandatoryValuesWithLabels();
		page.addDetailsButtonClick();
		page.addNewButtonClick(); 
		CustomUtils.ThreadDotSleep(3000);
	   }
	
	public void addSurchargeWaiverPlanDetails(SurchargeWaiverPlan surchargeWailverPlan)
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
	
	public void verifyRecordsInTableBasedOnFilter()
    {
		page.searchFunctionalityCheck();
    }
	
    public void verifyEditOperationForAddedRecord()
    {
    	page.editFunctionalityCheck();
    }
    
    public void verifyDeleteOperationForAddedRecord()
    {
    	page.deleteFunctionalityCheck();
    }
}
