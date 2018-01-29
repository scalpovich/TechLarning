package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class HelpdeskWorkflow {
	private HelpdeskGeneralPage helpDeskPage;
	
	@Autowired
	private Navigator navigator;

	public String getDeviceStatus(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getDeviceStatus(device);
	}
	
	public void setActiveDeviceNumberByCardPackId(HelpdeskGeneral helpdeskGeneral, String registeredType) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.setActiveDeviceNumberByCardPackId(helpdeskGeneral, registeredType);
	}
	
	public boolean verifyCurrencySetupDoneCorrectly(HelpdeskGeneral helpdeskGeneral, Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyCurrencySetupDoneCorrectly(helpdeskGeneral, device);
	}
		
	public void searchWithDeviceNumber(HelpdeskGeneral helpdeskGeneral){
		helpDeskPage.searchWithDeviceNumber(helpdeskGeneral);	
	}

	public void searchByDeviceNumber(Device device){
		helpDeskPage.searchByDeviceNumber(device);	
	}
	
	public String getDeviceNumberStatus() {
		return helpDeskPage.getDeviceNumberStatus();
	}
	
	public void clickCustomerCareEditLink() {
		helpDeskPage.clickCustomerCareEditLink();
	}
	
	public void storeSaleDate() {
		helpDeskPage.storeSaleDate();
	}
	
	public String saleDate() {
		return helpDeskPage.saleDate();
	}
	
	public void activateDevice(HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage.activateDevice(helpdeskGeneral);
	}
	
	public void setupDeviceCurrency(HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage.setupDeviceCurrency(helpdeskGeneral);
	}
	
	public void storeActivationDate() {
		helpDeskPage.storeActivationDate();
	}
	
	public String activationDate() {
		return helpDeskPage.activationDate();
	}
	
	public void storeDeliveryDate() {
		helpDeskPage.storeDeliveryDate();
	}
	
	public String deliveryDate() {
		return helpDeskPage.deliveryDate();
	}
	
	public void clickEndCall() {
		helpDeskPage.clickEndCall();
	}
	
	public BigDecimal getWalletBalance(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getWalletBalance(device);
	}
	
	public String getWalletNumber(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getWalletNumber(device);
	}
	
	public void walletToWalletTransfer(Device device){
		helpDeskPage.walletToWalletTransfer(device);
	}
	public String getWalletBalanceInformation(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getWalletBalanceInformation(device);
	}
	
	public boolean verifyBalanceUpdatedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyBalanceUpdatedCorreclty(beforeLoadBalanceInformation, transactionDetailsFromExcel, afterLoadBalanceInformation);
	}
	
	public boolean verifyBalanceNotChanged(String beforeLoadBalanceInformation, String afterLoadBalanceInformation) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyBalanceNotChanged(beforeLoadBalanceInformation, afterLoadBalanceInformation);
	}
	
	public boolean verifyBalanceDeductedCorreclty(String beforeLoadBalanceInformation, String transactionDetailsFromExcel, String afterLoadBalanceInformation) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyBalanceDeductedCorreclty(beforeLoadBalanceInformation, transactionDetailsFromExcel, afterLoadBalanceInformation);
	}
	
	public boolean verifyInitialLoadBalanceUpdatedCorreclty(String transactionDetailsFromExcel, String afterLoadBalanceInformation) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.verifyInitialLoadBalanceUpdatedCorreclty(transactionDetailsFromExcel, afterLoadBalanceInformation);
	}
}
