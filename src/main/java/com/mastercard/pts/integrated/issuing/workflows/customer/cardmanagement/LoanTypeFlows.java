package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanType;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LoanTypePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class LoanTypeFlows {
	
	@Autowired
	private Navigator navigator;
	
	public void addLoanType(LoanType loanType){
		LoanTypePage page = navigator.navigateToPage(LoanTypePage.class);
		page.addLoanType(loanType);	
	}

}
