package com.mastercard.pts.integrated.issuing.workflows.agent.inventory;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.*;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class AgentUiVerificationInventoryWorkflow {
	@Autowired
	private Navigator navigator;

	public void verifyAcceptancePage() {
		AcceptancePage page = navigator.navigateToPage(AcceptancePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyInventoryStatusPage() {
		InventoryStatusPage page = navigator.navigateToPage(InventoryStatusPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOrderCancellationPage() {
		OrderCancellationPage page = navigator.navigateToPage(OrderCancellationPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyOrderPage() {
		OrderPage page = navigator.navigateToPage(OrderPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStatusPage() {
		StatusPage page = navigator.navigateToPage(StatusPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStockReturnPage() {
		StockReturnPage page = navigator.navigateToPage(StockReturnPage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStockTransferAcceptancePage() {
		StockTransferAcceptancePage page = navigator.navigateToPage(StockTransferAcceptancePage.class);
		page.verifyUiOperationStatus();
	}

	public void verifyStockTransferIntraBranchPage() {
		StockTransferIntraBranchPage page = navigator.navigateToPage(StockTransferIntraBranchPage.class);
		page.verifyUiOperationStatus();
	}

}