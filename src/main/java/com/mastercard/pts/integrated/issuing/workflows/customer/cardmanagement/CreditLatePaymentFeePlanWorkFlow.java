package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LatePaymentFeePlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e076177
 *
 */
@Workflow
public class CreditLatePaymentFeePlanWorkFlow {
	@Autowired
	private Navigator navigator;
	private LatePaymentFeePlanPage page;
	public boolean userCreatesAValidLatePaymentFeePlan()
	{
		 page = navigator.navigateToPage(LatePaymentFeePlanPage.class);
		 page.addLatePaymentFeePlan();
		 page.addMandatoryLabelsAndFields();
		 page.enterLatePaymentFeePlancode();
		 page.enterLatePaymentFeeDescription();
		 page.selectLPCOn();
		 page.selectLPFeeValueDate();
		 page.selectCurrency();
		 page.settingMandatoryValuesWithLabels();
		 page.addLatePaymentFeePlanDetails();
		 page.enterMinimumRangeAmount();
		 page.enterFixedValue();
		 page.switchingBackToMainScreenAndSaveNewLatePaymentFeePlan();
		return page.successMessageDiplay();
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
