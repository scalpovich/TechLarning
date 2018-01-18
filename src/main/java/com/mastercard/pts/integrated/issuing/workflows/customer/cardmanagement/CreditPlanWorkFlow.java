package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreditPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

/**
 * @author e076177
 *
 */
@Component
public class CreditPlanWorkFlow {
	@Autowired
	private Navigator navigator;
	private CreditPlanPage creditPlanPage;
	public boolean userCreatesAValidCreditPlan(CreditCardCreditPlan creditCardCreditPlan )
	{
	 creditPlanPage = navigator.navigateToPage(CreditPlanPage.class);
	 creditPlanPage.addCreditPlan();
	 creditPlanPage.addMandatoryLabelsAndFields();
	 creditPlanPage.enterCreditPlanCode(creditCardCreditPlan);
	 creditPlanPage.enterCreditPlanDescription(creditCardCreditPlan);
	 creditPlanPage.enterCreditPlanAbbreviation(creditCardCreditPlan);
	 creditPlanPage.selectPaymentDate(1);
	 creditPlanPage.enterPaymentDateDays(creditCardCreditPlan);
	 creditPlanPage.selectUnpaidDate(1);
	 creditPlanPage.enterUnpaidDateDays(creditCardCreditPlan);
	 creditPlanPage.selectTransactionRulePlan(1);
	 creditPlanPage.selectCurrency(1);
	 creditPlanPage.enterMinimumDue(creditCardCreditPlan);
	 creditPlanPage.enterTotalDue(creditCardCreditPlan);
	 creditPlanPage.selectPaymentPriorityPlan(1);
	 creditPlanPage.enterAllowedPercentage(creditCardCreditPlan);
	 creditPlanPage.settingMandatoryValuesWithLabels();
	 creditPlanPage.saveButtonClick();
	 return creditPlanPage.successMessageDisplay();
	}
	 
    public void verifyRecordsInTableBasedOnFilter()
    {
    creditPlanPage.searchFunctionalityCheck();
    }
    public void verifyEditOperationForAddedRecord()
    {
    creditPlanPage.editFunctionalityCheck();
    }
    public void verifyDeleteOperationForAddedRecord()
    {
    creditPlanPage.deleteFunctionalityCheck();
    }
}
