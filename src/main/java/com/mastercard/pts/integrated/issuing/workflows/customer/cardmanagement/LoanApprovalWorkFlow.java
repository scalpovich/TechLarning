package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LoanApprovalRetailTransactionToLoanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LoanPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class LoanApprovalWorkFlow {

	@Autowired
	private Navigator navigator;

	public LoanDetails raiseLoanApprovalRetailTransactionToLoan(LoanPlan loanPlan, Device device, String arn) {
		LoanApprovalRetailTransactionToLoanPage loanApprovalRetailTransactionLoanPage;
		loanApprovalRetailTransactionLoanPage = navigator.navigateToPage(LoanApprovalRetailTransactionToLoanPage.class);
		return loanApprovalRetailTransactionLoanPage.retailTransactionToLoanFromLoanScreen(loanPlan, device, arn);
	}

}
