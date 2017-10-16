package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionPlan;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionPlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionRegistrationPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.ProcessingCenterPage;
import com.mastercard.pts.integrated.issuing.pages.customer.processingcenter.TransactionTypePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

/**
 * @author E060549
 * 
 *
 */

@Component
public class TransactionFlows {

	@Autowired
	TransactionTypePage transactiontypepage;

	@Autowired
	ProcessingCenterPage processingcenterpage;

	@Autowired
	MenuSubMenuPage menusubmenupage;

	@Autowired
	Navigator navigator;

	@Autowired
	TransactionRegistrationPage transactionregistrationpage;

	public String addTransactionPlan(DeviceCreation deviceCreation, TransactionPlan transactionplan) {
		menusubmenupage.waitForElementVisible(menusubmenupage.getCardManagement());
		TransactionPlanPage transactionplanpage = navigator.navigateToPage(TransactionPlanPage.class);
		transactionplanpage.clickaddTransactionPlan();
		String transactionPlan = transactionplanpage.addTransactionPlan(deviceCreation);
		transactionplanpage.clickTransaction(transactionplan);
		transactionplanpage.clickSaveButton();
		transactionplanpage.verifyTransactionPlanSuccess();
		return transactionPlan;
	}

	public void listTransactionCustomer() {
		menusubmenupage.clickMenuSubOption(menusubmenupage.getInstitutionParameterSetup(),
				menusubmenupage.getTransactionRegistration());
		transactionregistrationpage.listTransactiontypes(MapUtils.fnGetInputDataFromMap("InterchangeType"));
	}

	public void listTransactiontypes() {
		menusubmenupage.waitForElementVisible(processingcenterpage.getProcessingCenter());
		processingcenterpage.clickSubOptionProcessingCenter(processingcenterpage.getSetup(),
				processingcenterpage.getMasterParameters());
		menusubmenupage.waitForElementVisible(processingcenterpage.getTransactiontype());
		processingcenterpage.getTransactiontype().click();
		transactiontypepage.listTransactiontypes(MapUtils.fnGetInputDataFromMap("InterchangeType"));
	}

	public void viewTransactionDetails(ExamplesTable TransactionCode) {
		try {
			transactiontypepage.viewTransactiontype(TransactionCode);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void checkTransactionChannels(ExamplesTable Transactions) {
		Boolean value = transactionregistrationpage.checkTransactionChannelEnabled(Transactions);
		Assert.assertEquals("Transaction channels are open for the options", true, value);
	}

	public void selectTransaction() {
		menusubmenupage.clickMenuSubOption(menusubmenupage.getInstitutionParameterSetup(),
				menusubmenupage.getTransactionRegistration());
		String message = transactionregistrationpage
				.selectTransaction(MapUtils.fnGetInputDataFromMap("TransactionType"));
		Assert.assertEquals(message, Constants.Record_SAVED_Successfully);
	}

}
