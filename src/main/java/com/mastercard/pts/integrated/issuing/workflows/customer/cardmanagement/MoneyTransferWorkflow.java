package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MoneySend;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.VisaMoneyTransfer;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.InitiateVisaMoneyTransferPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.MoneySendPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class MoneyTransferWorkflow {

	@Autowired
	private Navigator navigator;

	public void processMaterCardMoneySendRequest(MoneySend moneySend, Device sourceDevice){
		MoneySendPage page = navigator.navigateToPage(MoneySendPage.class);
		page.searchDeviceAndSelectWallet(sourceDevice);
		page.submitMoneySendRequest(moneySend);
	}
	
	public void processMaterCardMoneySendRequestFromSecondWallet(MoneySend moneySend, Device sourceDevice){
		MoneySendPage page = navigator.navigateToPage(MoneySendPage.class);
		page.searchDeviceAndSelectWallet(sourceDevice);
		page.submitMoneySendRequest(moneySend);
	}

	public void processVisaMoneyTransferRequest(VisaMoneyTransfer visaMoneyTransfer, Device sourceDevice){
		InitiateVisaMoneyTransferPage page = navigator.navigateToPage(InitiateVisaMoneyTransferPage.class);
		page.searchDeviceAndSelectWallet(sourceDevice);
		page.submitVisaMoneyTransferRequest(visaMoneyTransfer);
	}
	
	public void processVisaMoneyTransferRequestFromSecondWallet(VisaMoneyTransfer visaMoneyTransfer, Device sourceDevice){
		InitiateVisaMoneyTransferPage page = navigator.navigateToPage(InitiateVisaMoneyTransferPage.class);
		page.searchDeviceAndSelectWallet(sourceDevice);
		page.submitVisaMoneyTransferRequest(visaMoneyTransfer);
	}
}
