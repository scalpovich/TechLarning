package com.mastercard.pts.integrated.issuing.workflows.customer.helpdesk;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.helpdesk.HelpdeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.customer.helpdesk.HelpdeskGeneralPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Payment;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.domain.agent.transactions.CardToCash;

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
	
	public void resetPinCounter(HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage.resetPinRetryCounter(helpdeskGeneral);
	}

	public void setupDeviceCurrency(HelpdeskGeneral helpdeskGeneral){		
		helpDeskPage.setupDeviceCurrency(helpdeskGeneral);
	}
	
	public void blockDevice(HelpdeskGeneral helpdeskGeneral) {
		clickCustomerCareEditLink();
		helpDeskPage.blockDevice(helpdeskGeneral);
	}
	
	public void cancelDevice(HelpdeskGeneral helpdeskGeneral) {
		clickCustomerCareEditLink();
		helpDeskPage.cancelDevice(helpdeskGeneral);
	}
	
	public void setupInternationalAllowDisallowCheck(String status) {
		helpDeskPage.setupInternationalAllowDisallowCheck(status);
	}
	
	public void setupEccomerceAllowDisallowCheck(HelpdeskGeneral helpdeskGeneral, String status) {
		helpDeskPage.setupEccomerceDisallowCheck(status);
	}
	public void allowTransactionForOneHour(String status) {
		helpDeskPage.allowTransactionForOneHour(status);
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
		searchByDeviceNumber(device);
		clickCustomerCareEditLink();
		helpDeskPage.walletToWalletTransfer(device);
	}

	public String getWalletBalanceInformation(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getWalletBalanceInformation(device);
	}
	
	public String getWalletBalanceInformationForRemittance(Device device, CardToCash cardToCash) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getWalletBalanceInformationForRemittance(device, cardToCash);
	}

	public String getWalletBalanceAfterLoyaltyRedemption(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getWalletBalanceInformationAfterLoyaltyRedemption(device);
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
	
	public boolean resetCardholderTranPassword(String clientID){		
		return helpDeskPage.serviceRequestCardholderTransactionPassword(clientID);
	}
	
	public boolean changeRegisteredEmailID(HelpdeskGeneral general){		
		return helpDeskPage.changeRegisteredEmailID(general);
	}
	
	public boolean changeRegisteredMobileNo(HelpdeskGeneral general){
		return helpDeskPage.changeRegisteredMobileNo(general);
	}
	
	public BigDecimal noteDownAvailableLimit(String type) {
		clickCustomerCareEditLink();
		return helpDeskPage.noteDownAvailableLimit(type);
	}
	
	public HashMap<String,BigDecimal>  noteDownCreditLimit(String type) {
		clickCustomerCareEditLink();
		return helpDeskPage.noteDownCreditLimit(type);
	}
	
	public HashMap<String, String> noteDownRequiredValues(String deviceNumber) {
		clickCustomerCareEditLink();
		return helpDeskPage.noteDownRequiredValues(deviceNumber);
	}
	
	public BigDecimal verifyAvailableLimit(String type) {
		clickCustomerCareEditLink();
		return helpDeskPage.noteDownAvailableLimit(type);
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
	
	public String verifyBillingAmounts(Device device){
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.getDeviceStatus(device);
		return helpDeskPage.verifyBillingDetails(device);
	}
	
	public HashMap<String,BigDecimal> activateCreditLimitChangeRequest(HelpdeskGeneral helpdeskGeneral){
		return helpDeskPage.activateCreditLimitChangeRequest(helpdeskGeneral);
	}
	
	public Map<String,String> fetchCardBalanceAndCloseHelpdesk(Device device) {
		Map<String, String> balanceMapBeforePayments;	
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);	
		balanceMapBeforePayments = helpDeskPage.checkCreditBalances(device);
		helpDeskPage.clickEndCall();
		return balanceMapBeforePayments;		
	}
	
	public void compareBalancesAfterPayment(Payment payment){
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);	
		helpDeskPage.checkAndCompareBalancePostPayment(payment);
	}

	public void checkBalanceDetailsThroughHelpdesk(Device device, String payment) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);	
		helpDeskPage.checkBalancesDetails(device,payment);
		helpDeskPage.clickEndCall();
	}
	
	public void compareBalanceDetailsPostPayments(String payment){
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);	
		helpDeskPage.compareBalanceDetailsPostPayments(payment);
	}

	public String verifyUnpaidAndAuthFlag(Device device, String label) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.getDeviceStatus(device);
		return helpDeskPage.verifyUnpaidAndAuthFlag(device,label);
	}
	
	public List<LoanDetails> raiseRetailToLoanRequest(HelpdeskGeneral helpdeskGeneral,LoanPlan loanPlan,TransactionSearchDetails transactionDetails){
		return helpDeskPage.retailTransactionToLoan(helpdeskGeneral,loanPlan,transactionDetails);
	}
	public String getDeclineCode(Device device, String rrnNumber){
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		return helpDeskPage.getDeclineCodeForTransaction(device, rrnNumber);
		
	}

	public void raiseStoplistRequest(Device device,
			HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.searchByDeviceNumber(device);
		helpdeskGeneral.setServiceCode(Constants.DEVICE_STOPLIST_REQ);
		helpDeskPage.addServiceRequest(helpdeskGeneral,
				helpDeskPage.getReasonDDwn(),
				Constants.FRAME_STOPLIST_REQUEST, false);
	}

	public void withdrawStoplistDeviceFlows(HelpdeskGeneral general,
			Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.searchByDeviceNumber(device);
		helpDeskPage.withdrawDeviceFromStoplist(general);
	}

	public String raiseLoanCancellationRequest(LoanPlan loanPlan, Device device, HelpdeskGeneral helpdeskGeneral) {
		return helpDeskPage.raiseLoanCancellationRequest(helpdeskGeneral,loanPlan,device);
		
	}

	public String raiseLoanPreClosureRequest(HelpdeskGeneral helpdeskGeneral,LoanPlan loanPlan,Device device){
		return helpDeskPage.raiseLoanPreclosureRequest(helpdeskGeneral,loanPlan,device);
	}
	
	public void navigateToLoyaltyDetails(Device device) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.searchByDeviceNumber(device);
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		helpDeskPage.clickEditDeviceLink();
		SimulatorUtilities.wait(5000);// this to wait till the table gets loaded
		helpDeskPage.clickLoyaltyBtn();
	}
	
	public Map<String, String> getLoyaltyDetails() {
		return helpDeskPage.getLoyaltyDetails();
	}

	public String raiseLoanCancellationRequestToVerifyErroMessage(LoanPlan loanPlan, Device device,
			HelpdeskGeneral helpdeskGeneral) {
		return helpDeskPage.raiseLoanCancellationRequestToVerifyErroMessage(helpdeskGeneral,loanPlan,device);
	}
	
	public Device getDeviceDetailsFromHelpdesk(Device device){
		device = helpDeskPage.noteDownDeviceDetails(device);
		return device;
	}
	
	public String raiseReissueTPINRequest(Device device,
			HelpdeskGeneral helpdeskGeneral) {
		helpDeskPage = navigator.navigateToPage(HelpdeskGeneralPage.class);
		helpDeskPage.searchByDeviceNumber(device);
		helpdeskGeneral.setServiceCode(Constants.REISSUE_TPIN_REQ);
		return helpDeskPage.raiseReissueTPINRequest(helpdeskGeneral,
				Constants.FRAME_REISSUE_TPIN);
}

	public boolean isRequestFailingForNonNormalDevice(HelpdeskGeneral helpdeskGeneral){
		try{
			resetPinCounter(helpdeskGeneral);
			return false;
		} catch (Exception e){
			e.printStackTrace();
			helpDeskPage.printResponseMessageLog();
			helpDeskPage.clickEndCall();
			return true;
		}
	}
}


