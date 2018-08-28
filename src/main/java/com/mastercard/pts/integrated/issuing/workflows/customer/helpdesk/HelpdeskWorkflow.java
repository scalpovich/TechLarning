package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;

@Workflow
public class HelpdeskWorkflow {
	
	@Autowired
	private HelpdeskGeneralPage helpDeskPage;

	@Autowired
	private Navigator navigator;
	
	@Autowired
	ConnectionUtils connctionUtils;

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

	public void searchWithDeviceNumber(HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);	
		helpDeskPage.searchWithDeviceNumber(helpdeskGeneral);
	}

	public void searchByDeviceNumber(Device device) {
		helpDeskPage.searchByDeviceNumber(device);
	}
	
	public void searchByClientId(String clientId,String cardType){
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);		
		helpDeskPage.searchByClientID(clientId, cardType);
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
	
	public BigDecimal activateCreditLimitChangeRequest(HelpdeskGeneral helpdeskGeneral){
		return helpDeskPage.activateCreditLimitChangeRequest(helpdeskGeneral);
	}
	
	public void creditLimitChange(HelpdeskGeneral helpdeskGeneral){
		helpDeskPage.activateDevice(helpdeskGeneral);
	}

	public void setupDeviceCurrency(HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage.setupDeviceCurrency(helpdeskGeneral);
	}
	
	public void clickOnCurrentStatusTab(){
		helpDeskPage.clickCurrentStatusAndLimitsTab();
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

	public void walletToWalletTransfer(Device device) {
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
	
	public boolean resetCardholderLoginPassword(String clientID){		
		return helpDeskPage.serviceRequestCardholderLoginPassword(clientID);
	}
	
	public BigDecimal noteDownAvailableLimit(String type,Device device) {
		clickCustomerCareEditLink();
		return helpDeskPage.noteDownAvailableLimit(type);
	}
	
	public LinkedList <BigDecimal> noteDownCreditLimit(String type,Device device) {
		clickCustomerCareEditLink();
		return helpDeskPage.noteDownCreditLimit(type);
	}
	
	public boolean resetCardholderTranPassword(String clientID){		
		return helpDeskPage.serviceRequestCardholderTransactionPassword(clientID);
	}
	
	public boolean changeRegisteredEmailID(HelpdeskGeneral general){		
		return helpDeskPage.changeRegisteredEmailID(general);
	}
	
	public boolean changeRegisteredMobileNo(HelpdeskGeneral general){
		return helpDeskPage.changeRegisteredMobileNo(general);
	}
	
	public Optional<String[]> getDeviceTypeAndNumber(String institutionSelector){	
		String institution = System.getProperty("institution");
		if (institution != null && !institution.trim().isEmpty())
			institutionSelector=institution;
		String query = "SELECT * FROM device WHERE bank_code = '"+ institutionSelector +"'AND activation_date IS NOT NULL  AND status_code = 0 AND ROWNUM <= 1";
		ResultSet set = connctionUtils.executeQueryForBIN(query);
		try {
	        set.next();
	        return Optional.of(new String[]{ set.getString("PRODUCT_TYPE"),set.getString("DEVICE_NUMBER"),set.getString("Default_Wallet_Number")});
		} catch (SQLException|NullPointerException e ) {
			// TODO Auto-generated catch block
		   e.printStackTrace();
			return Optional.empty();
		}
	}
	public void validateRequiredFields(HelpdeskGeneral general){
		helpDeskPage.validateRequiredFields(general);
		helpDeskPage.validateMandatoryFields(3);
	}
}