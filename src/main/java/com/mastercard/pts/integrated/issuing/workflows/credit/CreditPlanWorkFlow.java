package com.mastercard.pts.integrated.issuing.workflows.credit;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CreditPlanWorkFlow {
	@Autowired
	private Navigator navigator;
	@Autowired
	CreditPlanPage page;
	public void userCreatesAValidCreditPlan()
	{
	 page = navigator.navigateToPage(CreditPlanPage.class);
	 page.addcreditplan();
	}
    public void verifyRecordsInTableBasedOnFilter()
    {
     page.enterFilterValuesBasedOnRecordCreated();
    }
    public void verifyEditOperationForAddedRecord()
    {
     page.editFunctionalityCheck();
    }
}
