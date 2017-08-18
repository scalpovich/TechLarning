package com.mastercard.pts.integrated.issuing.workflows.agent.inventory;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Acceptance;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Order;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Status;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.AcceptancePage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.InventoryStatusPage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.OrderCancellationPage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.OrderPage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.StatusPage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.StockReturnPage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.StockTransferAcceptancePage;
import com.mastercard.pts.integrated.issuing.pages.agent.inventory.StockTransferIntraBranchPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class InventoryWorkflow {
	private OrderPage opage;
	private AcceptancePage apage;
	private StatusPage spage;
	private OrderCancellationPage cpage;
	private StockTransferIntraBranchPage stibpage;
	private StockTransferAcceptancePage stapage;
	private StockReturnPage srpage;
	private InventoryStatusPage ispage;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToOrderPage() {
		opage = navigator.navigateToPage(OrderPage.class);
	}

	public String getOrderMasterDetailContentTitleText() {
		return opage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAcceptancePage() {
		apage = navigator.navigateToPage(AcceptancePage.class);
	}

	public String getAcceptanceMasterDetailContentTitleText() {
		return apage.getMasterDetailContentTitleText();
	}
	
	public void navigateToStatusPage() {
		spage = navigator.navigateToPage(StatusPage.class);
	}

	public String getStatusMasterDetailContentTitleText() {
		return spage.getMasterDetailContentTitleText();
	}
	
	public void navigateToOrderCancellationPage() {
		cpage = navigator.navigateToPage(OrderCancellationPage.class);
	}

	public String getOrderCancellationMasterDetailContentTitleText() {
		return cpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToStockTransferIntraBranchPage() {
		stibpage = navigator.navigateToPage(StockTransferIntraBranchPage.class);
	}

	public String getStockTransferIntraBranchMasterDetailContentTitleText() {
		return stibpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToStockTransferAcceptancePage() {
		stapage = navigator.navigateToPage(StockTransferAcceptancePage.class);
	}

	public String getStockTransferAcceptanceMasterDetailContentTitleText() {
		return stapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToStockReturnPage() {
		srpage = navigator.navigateToPage(StockReturnPage.class);
	}

	public String getStockReturnMasterDetailContentTitleText() {
		return srpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToInventoryStatusPage() {
		ispage = navigator.navigateToPage(InventoryStatusPage.class);
	}

	public String getInventoryStatusMasterDetailContentTitleText() {
		return ispage.getMasterDetailContentTitleText();
	}

	public String createOrder(Order order) {
		opage = navigator.navigateToPage(OrderPage.class);
		String orderNumber = opage.createOrder(order);
		order.setOrderNumber(orderNumber);
		return orderNumber;
	}
	
	public String getOrderCreationMessage(){
		return opage.getOrderCreationMessage();
	}

	public void acceptDispatch(Acceptance acceptance) {
		apage = navigator.navigateToPage(AcceptancePage.class);
		apage.acceptDispatch(acceptance);
	}
	
	public String getDispatchAcceptanceMessage(){
		return apage.getDispatchAcceptanceMessage();
	}

	public void statusInfo(Status status){
		spage = navigator.navigateToPage(StatusPage.class);
		spage.statusInfo(status);
	}
	
	public String getStatusMessage(){
		return spage.getStatusMessage();
	}
}
