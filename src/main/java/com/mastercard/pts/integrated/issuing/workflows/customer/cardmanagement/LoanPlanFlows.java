package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LoanPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class LoanPlanFlows {
	
	@Autowired
	private Navigator navigator;
	
	public void addLoanPlan(LoanPlan loanPlan){
		LoanPlanPage page = navigator.navigateToPage(LoanPlanPage.class);
		page.addLoanPlan(loanPlan);
	}

}
