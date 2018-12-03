/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.steps.cardholder;

import java.util.ArrayList;
import java.util.Map;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderEnquiry;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardHolderEnquiryWorkflow;

@Component
public class CardholderEnquirySteps extends AbstractBaseFlows{
	
	final Logger logger = LoggerFactory.getLogger(CardholderEnquirySteps.class);
	
	@Autowired
	private CardHolderEnquiryWorkflow cardHolderEnqflow;
	
	private CardHolderEnquiry cardholderEnquiry;
		
	@When ("check charges for $transactionType")
	public void checkChargesForFundTransfer(@Named("transactionType")String transactionType){		
		cardholderEnquiry = CardHolderEnquiry.cardHolderEnquiryDataProvider();
		cardholderEnquiry.setTransactionType(transactionType);
		cardHolderEnqflow.navigateToViewHomePage();
		cardHolderEnqflow.navigateToEnquiryChargeViewMenu();
		cardHolderEnqflow.selectTransactionType(cardholderEnquiry.getTransactionType());
		cardHolderEnqflow.setTransactionAmount(cardholderEnquiry.getTransactionAmount());
		cardHolderEnqflow.setTransctionCurrency(cardholderEnquiry.getTransactionCurrency());
		cardHolderEnqflow.clickOnSubmitButtonForCharges();
	}
	
	@Then ("verify transaction conversation rate")
	public void verifyTransactionConversationRate(){
		cardHolderEnqflow.checkConversionRatesForFundTransfer(cardholderEnquiry.getConversionCharge());		
	}
	
	@Then ("verify total debit amount for transaction")
	public void verifyTtlDebitAmoutForTranct(){
		cardHolderEnqflow.checkTotalDebitAmt(cardholderEnquiry.getTransactionAmount());
	}
	
	@Then ("verify transaction type")
	public void verifyTransactionsType(){
		cardHolderEnqflow.checkTransactionForFundTransfer(cardholderEnquiry.getTransactionType());
	}
	
	@When ("check transaction history for selected wallet")
	public void checkTransactionHistoryForWallet(){
		cardholderEnquiry = CardHolderEnquiry.cardHolderEnquiryDataProvider();
		cardHolderEnqflow.navigateToEnquiryTransactionsView();
		cardHolderEnqflow.selectTransactionsCountOption();
		cardHolderEnqflow.setNoOfTransactionsToShow(cardholderEnquiry.getNoOfTransactionCount());
	}
	
	@When ("check transaction history between selected duration")
	public void checkTransactionHistoryBetweenDates(){
		cardholderEnquiry = CardHolderEnquiry.cardHolderEnquiryDataProvider();
		cardHolderEnqflow.navigateToEnquiryTransactionsView();
		cardHolderEnqflow.selectTranscationPeriod(cardholderEnquiry.getFromDate(),cardholderEnquiry.getToDate());		
	}
	
	@Then ("verify transaction details")
	public void verifyTransactionDetails(){
		Map<Integer,ArrayList<String>> transactionDetails = cardHolderEnqflow.getTransactionDetails();
		Assert.assertTrue(cardHolderEnqflow.checkTransactionDetails(transactionDetails,"cr","500"));
	}
}
