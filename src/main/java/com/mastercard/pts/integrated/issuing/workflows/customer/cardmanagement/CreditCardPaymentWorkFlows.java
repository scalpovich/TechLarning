package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CashPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.LocalChequePage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OutstationChequeCollectionPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.OutstationChequeProcessingPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CreditCardPaymentWorkFlows {
	
	@Autowired
	private Navigator navigator;
	
	@Autowired
	TestContext context;
	
	LocalChequePage localChqPage;	
	CashPage cashPage;
	OutstationChequeCollectionPage outstationChequeCollectionPage;
	OutstationChequeProcessingPage outstationChequeProcessingPage;
	
	public void makeLocalChequePayment(Payment local){
		localChqPage = navigator.navigateToPage(LocalChequePage.class);
		localChqPage.addLocalChequePayment(local);
	}
	
	public void makeCashPayment(Payment cashPay){
		cashPage = navigator.navigateToPage(CashPage.class);
		cashPage.performCashPayment(cashPay);
	}

	public void makeOutStationCollectionPayment(Payment outStationCollection){
		Device device = context.get(ContextConstants.DEVICE);
		outstationChequeCollectionPage = navigator.navigateToPage(OutstationChequeCollectionPage.class);
		outstationChequeCollectionPage.performOutStationCollectionPayment(outStationCollection,device);
	}
	
	public boolean checkOutStationProcessing(){
		outstationChequeProcessingPage=navigator.navigateToPage(OutstationChequeProcessingPage.class);
		return outstationChequeProcessingPage.isTextAvailableinTable();
	}
}
