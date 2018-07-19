package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeeWaiverPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionFeeWaiverPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class TransactionFeeWaiverPlanFlows {

	@Autowired
	Navigator navigator;

	public void addTransactionFeeWaiverPlanForMultipleType(TransactionFeeWaiverPlan plan){
		TransactionFeeWaiverPlanPage page=navigator.navigateToPage(TransactionFeeWaiverPlanPage.class);
		page.setupTransactionTypeForSources(plan);
	}
}



