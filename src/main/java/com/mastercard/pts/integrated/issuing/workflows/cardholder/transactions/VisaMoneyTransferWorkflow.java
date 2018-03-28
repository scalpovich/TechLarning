package com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.cardholder.transactions.VisaMoneyTransfer;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.VisaMoneyTransferPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Workflow
public class VisaMoneyTransferWorkflow extends AbstractBaseFlows {

	@Autowired
	private Navigator navigator;

	public String doVtsTransaction(VisaMoneyTransfer vmt, Device device) {
		VisaMoneyTransferPage page = navigator.navigateToPage(VisaMoneyTransferPage.class);
		page.doTransaction(vmt, device);
		page.confirmTransaction(vmt);
		return page.verifyResponse();
	}
}