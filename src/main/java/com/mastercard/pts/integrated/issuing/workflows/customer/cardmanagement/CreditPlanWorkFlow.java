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
	 creditPlanPage.addcreditplan();
	 creditPlanPage.addMandatoryLabelsAndFields();
	 creditPlanPage.enterCreditPlanCode(creditCardCreditPlan);
	 creditPlanPage.enterCreditPlanDescription(creditCardCreditPlan);
	 creditPlanPage.enterCreditPlanAbbreviation(creditCardCreditPlan);
	 creditPlanPage.selectPaymentDate();
	 creditPlanPage.enterPaymentDateDays(creditCardCreditPlan);
	 creditPlanPage.selectUnpaidDate();
	 creditPlanPage.enterUnpaidDateDays(creditCardCreditPlan);
	 creditPlanPage.selectTransactionRulePlan();
	 creditPlanPage.selectCurrency();
	 creditPlanPage.enterMinimumDue(creditCardCreditPlan);
	 creditPlanPage.enterTotalDue(creditCardCreditPlan);
	 creditPlanPage.selectPaymentPriorityPlan();
	 creditPlanPage.enterAllowedPercentage(creditCardCreditPlan);
	 creditPlanPage.settingMandatoryValuesWithLabels();
	 creditPlanPage.saveButtonClick();
	 return creditPlanPage.successMessageDiplay();
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
