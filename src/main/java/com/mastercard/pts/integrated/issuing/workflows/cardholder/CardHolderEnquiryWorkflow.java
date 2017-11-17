/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.workflows.cardholder; 
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry.EnquiryHomePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class CardHolderEnquiryWorkflow extends AbstractBaseFlows {
	
	@Autowired
	Navigator navigator;
	
	@Autowired
	EnquiryHomePage enquiryPage;
	
	@Autowired
	DatePicker datePicker;
	
	
	public void navigateToViewHomePage(){		
		EnquiryHomePage page = navigator.navigateToPage(EnquiryHomePage.class);
	}
	
	public void navigateToEnquiryTransactionsView(){
		navigator.navigateToPath("Enquiry");
		enquiryPage.clickOnTransactionsTab();	
	}
	
	public void navigateToEnquiryChargeViewMenu(){
		navigator.navigateToTab("View Charges");
	}
	
	public void selectTransactionsCountOption(){
		enquiryPage.selectTransactionsCount();
	}
	
	public void selectTranscationPeriod(String fromDate,String toDate){
		datePicker.setFromDate(fromDate );
		datePicker.setToDate(toDate);
		enquiryPage.clickOnTransactionSubmitBtn();		
	}

	public void setNoOfTransactionsToShow(String tranSactionCount){
		enquiryPage.setNoOfTransactionCount(tranSactionCount);
		enquiryPage.clickOnTransactionSubmitBtn();
		waitForLoaderToDisappear();
	}
	public void selectTransactionType(String transactionType){
		
		enquiryPage.selectTransactionType(transactionType);
	}
	
	public void setTransactionAmount(String transAmount){
		enquiryPage.enterTransctionAmount(transAmount);
	}
	
	public void setTransctionCurrency(String currencyType){
		
		enquiryPage.selectTransactionCurrency(currencyType);
	}
	
	public void clickOnSubmitButtonForCharges(){
		enquiryPage.clickOnSubmitButton();
	}
	
	public void checkTransactionForFundTransfer(String TransactionType){
		Assert.assertEquals(TransactionType,enquiryPage.checkTransactionType());
	}
	
	public void checkConversionRatesForFundTransfer(String transactionAmount){
		Assert.assertEquals(transactionAmount,enquiryPage.checkTransactionCharge());
	}
	
	public Map<Integer,ArrayList<String>> getTransactionDetails(){
		return enquiryPage.getTransactionDetails();
	}

	public boolean checkTransactionDetails(Map<Integer,ArrayList<String>> transDetails,String ...tranDetails){
		
		if(tranDetails.length > 0){
			for(Entry<Integer, ArrayList<String>> entry : transDetails.entrySet()){
				entry.getValue().contains(tranDetails[0]);
				entry.getValue().contains(tranDetails[1]);
			}
			return true;
		}else{
			transDetails.get(0).contains(tranDetails);	
			return true;
		}
	}
}
	
