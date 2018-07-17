package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.TransactionLimitPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class TransactionLimitPlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	TransactionLimitPlanPage pageToPass;
	
	public void createTransactionLimitPlan(DeviceCreation deviceCreation, TransactionLimitPlan transactionlimitplan) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		TransactionLimitPlanPage transactionLimitPlanPage = navigator.navigateToPage(TransactionLimitPlanPage.class);
		transactionLimitPlanPage.clickAddTransactionLimitPlan();
		transactionLimitPlanPage.addTransactionLimitPlan(deviceCreation, transactionlimitplan);
		transactionLimitPlanPage.clickaddTransactionLimitDetails();
		transactionLimitPlanPage.addTransactionLimitPlanDetails(transactionlimitplan);
		transactionLimitPlanPage.switchToAddTransactionLimitPlanFrame();
		transactionLimitPlanPage.clickSaveButton();
	}
	
	
	public void createTransactionLimitPlanWithoutDetails(TransactionLimitPlan transactionLimitPlan) {
		TransactionLimitPlanPage page = navigator.navigateToPage(TransactionLimitPlanPage.class);
		page.createTransactionLimitPlanWithoutDetails(transactionLimitPlan);
		pageToPass=page;
	}
	
	public void clickSave(){
	//	runWithinPopup("Add Transaction Limit Plan", () -> {
		WebElementUtils.scrollDown(driver(), 0, 300);
		pageToPass.clickSaveButton();
	//	});
	}
	
	public void addDetails(TransactionLimitPlan transactionLimitPlan) {
		pageToPass.addEachDetail(transactionLimitPlan);
	}


	public void deletePlan(String name) {
		TransactionLimitPlanPage page = navigator.navigateToPage(TransactionLimitPlanPage.class);
		page.deletePlan(name);
		
	}
	
	
}
