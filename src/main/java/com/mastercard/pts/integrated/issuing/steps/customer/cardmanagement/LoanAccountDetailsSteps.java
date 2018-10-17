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
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
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
		Device device = new Device();// context.get(ContextConstants.DEVICE);
		device.setDeviceNumber("5742539370867516");
		TransactionSearchDetails transaactionSerach = new TransactionSearchDetails();//context.get(ContextConstants.TRANSACTION_SEARCH_DETAILS);
		transaactionSerach.setTransaction("100.00");
		List<Map<String,String>> loanAccountDetails =  loanAccountWorkFlow.verifyLoanAccountDetail(device);	
		BigDecimal totalInt = new BigDecimal("0.00") ;
		BigDecimal totalIntCalculation = new BigDecimal("1.00");
		for (Map<String, String> map : loanAccountDetails) {
			if(map.get("Transaction Type").contains("Loan Installment"))
			{
				BigDecimal txnAmt = new BigDecimal(map.get("Transaction Amount"));
				BigDecimal PncpAmt = new BigDecimal(map.get("Principal Amount"));
				BigDecimal intAmt = new BigDecimal(map.get("Interest Amount"));
				assertThat("Transaction Amount Verified", PncpAmt.add(intAmt,  new MathContext(6)), equalTo(txnAmt));				
				assertThat("Principle Amount Verified", txnAmt.subtract(intAmt,  new MathContext(6)), equalTo(PncpAmt));
				assertThat("Interest Amount Verified", txnAmt.subtract(PncpAmt,  new MathContext(6)), equalTo(intAmt));
				totalInt.add(intAmt);
			}
			//outstanding amount  * 31 * Rate of interest / 365 / 100
//			totalIntCalculation = totalIntCalculation.multiply(new BigDecimal(transaactionSerach.getTransaction())).multiply(new BigDecimal("61.00")).multiply(new BigDecimal("2.00"));
//			totalIntCalculation = totalIntCalculation.divide(new BigDecimal("365.00")).divide(new BigDecimal("100.00"));
//			assertThat("Total Interest Amount Verified", totalInt, equalTo(totalIntCalculation));			
		}
	}

}
