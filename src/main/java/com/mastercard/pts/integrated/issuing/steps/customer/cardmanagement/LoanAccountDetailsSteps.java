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
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.LoanAccountDetailsWorkFlow;

@Component
public class LoanAccountDetailsSteps extends AbstractBaseSteps {

	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private LoanAccountDetailsWorkFlow loanAccountWorkFlow;
	
	@When("user verifies loan account details")
	@Then("user verifies loan account details")
	public void userVerifiesLoanAccountDetails() {
		Device device = context.get(ContextConstants.DEVICE);
		LoanDetails loanDetails = context.get(ContextConstants.LOAN_SANCTION_DETAILS);	
		List<Map<String,String>> loanAccountDetails =  loanAccountWorkFlow.verifyLoanAccountDetail(device);	
		for (Map<String, String> map : loanAccountDetails) {
			if(map.get("Transaction Type").contains("Loan Installment"))
			{
				BigDecimal txnAmt = new BigDecimal(map.get(ConstantData.LOAN_TRANSACTION_AMOUNT));
				BigDecimal PncpAmt = new BigDecimal(map.get(ConstantData.PRINCIPAL_AMOUNT));
				BigDecimal intAmt = new BigDecimal(map.get(ConstantData.INTEREST_AMOUNT));
				assertThat("EMI Amount Verified", txnAmt.toString(), equalTo(loanDetails.getLoanEMI().replaceAll(",", "")));
				assertThat("Transaction Amount Verified", PncpAmt.add(intAmt,  new MathContext(6)), equalTo(txnAmt));				
				assertThat("Principle Amount Verified", txnAmt.subtract(intAmt,  new MathContext(6)), equalTo(PncpAmt));
				assertThat("Interest Amount Verified", txnAmt.subtract(PncpAmt,  new MathContext(6)), equalTo(intAmt));
			}

		}
	}

}
