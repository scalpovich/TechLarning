package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoanAccountDetailsWorkFlow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoanApprovalWorkFlow;

@Component
public class LoanApprovalSteps extends AbstractBaseSteps {

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private TestContext context;

	@Autowired
	private LoanApprovalWorkFlow loanApprovalWorkFlow;

	@When("user raises Loan request from loan approval screen")
	@Then("user raises Loan request from loan approval screen")
	public void userRaisesLoanRequestFromLoanApprovalScreen() {
		Device device = context.get(ContextConstants.DEVICE);
		LoanPlan loanPlan = context.get(ContextConstants.LOAN_PLAN);
		TransactionSearchDetails transactionDetails = context.get(ContextConstants.TRANSACTION_SEARCH_DETAILS);
		context.put(ContextConstants.LOAN_SANCTION_DETAILS, loanApprovalWorkFlow.raiseLoanApprovalRetailTransactionToLoan(loanPlan, device, transactionDetails.getARN()));
	}

}
