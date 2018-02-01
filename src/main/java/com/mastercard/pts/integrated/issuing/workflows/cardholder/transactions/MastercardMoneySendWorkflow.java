package com.mastercard.pts.integrated.issuing.workflows.cardholder.transactions;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.cardholder.transactions.MastercardMoneySend;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.cardholder.transactions.MastercardMoneySendPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Workflow
public class MastercardMoneySendWorkflow extends AbstractBaseFlows {

	@Autowired
	private Navigator navigator;

	public String doMmsTransaction(MastercardMoneySend mms, Device device) {
		MastercardMoneySendPage page = navigator.navigateToPage(MastercardMoneySendPage.class);
		page.doTransaction(mms, device);
		page.confirmTransaction(mms);
		return page.verifyResponse();
	}
}