package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MID_TID_Blocking;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_MID_TID_BLOCKING,
})
public class MID_TID_BlockingPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(MID_TID_BlockingPage.class);


	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement DDwnNetwork;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement DDwnProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "terminalId:input:inputTextField")
	private MCWebElement txtbxTerminalID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "merchantId:input:inputTextField")
	private MCWebElement txtbxMerchantID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcc:input:inputTextField")
	private MCWebElement txtbxMCC;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquiringCountryCode:input:inputTextField")
	private MCWebElement txtbxAcquiringCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquirerId:input:inputTextField")
	private MCWebElement txtbxAcquirerID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCurrency:input:inputTextField")
	private MCWebElement txtbxTransactionCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardholderPresenceIndicator:input:dropdowncomponent")
	private MCWebElement DDwnCardholderPresenceIndicator;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardPresenceIndicator:input:dropdowncomponent")
	private MCWebElement DDwnCardPresenceIndicator;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pOSEntryMode:input:dropdowncomponent")
	private MCWebElement DDwnPOSEntryMode;

	public static final String TERMINAL_ID = "Terminal Id";
	public static final String MERCHANT_ID = "Merchant Id";
	private static final String ROW_COUNT = "//*[@class='dataview']/tbody[1]//tr";

	private void selectNetwork(String network){
		WebElementUtils.selectDDByVisibleText(DDwnNetwork, network);
	}

	private void selectProduct(String productType){
		WebElementUtils.selectDDByVisibleText(DDwnProductType, productType);
	}

	private void enterTerminalID(String terminalID){
		WebElementUtils.enterText(txtbxTerminalID, terminalID);
	}

	private void enterMerchantID(String merchantID){
		WebElementUtils.enterText(txtbxMerchantID, merchantID);
	}

	private void enterMCC(String MCC){
		WebElementUtils.enterText(txtbxMCC, MCC);
	}

	private void enterAcquiringCountryCode(String acquiringCountryCode){
		WebElementUtils.enterText(txtbxAcquiringCountryCode, acquiringCountryCode);
	}

	private void enterAcquirerID(String acquirerID){
		WebElementUtils.enterText(txtbxAcquirerID, acquirerID);
	}

	private void enterTransactionCurrency(String transactionCurrency){
		WebElementUtils.enterText(txtbxTransactionCurrency, transactionCurrency);
	}

	private void selectCardholderPresenceIndicator(String cardholderPresenceIndicator){
		WebElementUtils.selectDDByVisibleText(DDwnCardholderPresenceIndicator, cardholderPresenceIndicator);
	}

	private void selectPOSEntryMode(String POSEntryMode){
		WebElementUtils.selectDDByVisibleText(DDwnPOSEntryMode, POSEntryMode);
	}

	private void selectCardPresenceIndicator(String cardPresenceIndicator){
		WebElementUtils.selectDDByVisibleText(DDwnCardPresenceIndicator, cardPresenceIndicator);
	}


	private void selectValidCombinationForBlocking(String caseNumber, MID_TID_Blocking details){
		logger.info("Merchant Id {}",details.getMerchantID());
		logger.info("terminal Id {}",details.getTerminalID());
		switch(caseNumber){
		case "1" :
			enterMCC(details.getMcc());
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			break;
		case "2" :
			enterAcquiringCountryCode(details.getAcquiringCountryCode());
			enterMerchantID(details.getMerchantID());
			selectPOSEntryMode(details.getPosEntryMode());
			break;
		case "3" :
			selectPOSEntryMode(details.getPosEntryMode());
			enterMerchantID(details.getMerchantID());
			enterTransactionCurrency(details.getTransactionCurrency());
			break;
		case "4" : 
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			enterMerchantID(details.getMerchantID());
			break;
		case "5" :
			enterMerchantID(details.getMerchantID());
			break;
		case "6" :
			enterMCC(details.getMcc());
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			enterMerchantID(details.getMerchantID());
			break;
		case "7" :
			enterMCC(details.getMcc());
			enterTerminalID(details.getTerminalID());
			enterMerchantID(details.getMerchantID());
			break;
		case "8" :
			enterMCC(details.getMcc());
			enterTransactionCurrency(details.getTransactionCurrency());
			break;
		case "9" :
			enterAcquirerID(details.getAcquirerID());
			enterMerchantID(details.getMerchantID());
			break;
		case "10" :
			enterAcquiringCountryCode(details.getAcquiringCountryCode());
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			break;
		case "11" : 
			enterAcquirerID(details.getAcquirerID());
			enterTerminalID(details.getTerminalID());
			break;
		default:
			logger.info("Invalid Case Provided {}", caseNumber);
		}
	}

	public void addBlockingMID_TID(String combination, MID_TID_Blocking details){
		logger.info("Create MID TID Blocking combination for case {} " , combination);
		clickAddNewButton();
		runWithinPopup( "Add Blocking MID TID",
				() -> {
					selectNetwork(details.getNetwork());
					selectProduct(details.getProductType());
					selectValidCombinationForBlocking(combination, details);
					clickSaveButton();
				});
		verifyOperationStatus();
	}

	public void deleteRecord(String combination, MID_TID_Blocking details){
		deleteRecordAsPerCase(combination,details);
	}

	protected void deleteRecordAsPerCase(String caseNumber, MID_TID_Blocking details) {
		int rowCount = Elements(ROW_COUNT).size();

		switch (caseNumber) {
		case "1":
		case "10":
		case "11":
			logger.info("Terminal Id {}",details.getTerminalID());
			for (int i = 1; i <=rowCount; i++) {
				String terminalId = getCellTextByColumnName(i, TERMINAL_ID);
				if (details.getTerminalID().equalsIgnoreCase(terminalId)) {
					deleteRecord(i);
					break;
				}
			}
			break;

		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "9":
			logger.info("Merchant Id {}",details.getMerchantID());
			for (int i = 1; i <=rowCount; i++) {
				String merchantID = getCellTextByColumnName(i, MERCHANT_ID);
				if (details.getMerchantID().equalsIgnoreCase(merchantID)) {
					deleteRecord(i);
					break;
				}
			}
			break;
		case "8":
			for (int i = 1; i <=rowCount; i++) {
				String merchantID = getCellTextByColumnName(i, MERCHANT_ID);
				String terminalId = getCellTextByColumnName(i, TERMINAL_ID);
				if (("-").equalsIgnoreCase(merchantID) && ("-").equalsIgnoreCase(terminalId)) {
					deleteRecord(i);
					break;
				}
			}
			break;

		default:
			logger.info("Invalid Case Provided {}", caseNumber);

		}
	}

	private void deleteRecord(int index) {
		Element("//*[@class='dataview']//tbody//tr[" + index + "]//td[5]//a").click();
		SimulatorUtilities.wait(1000);
		acceptPopup();
	}

}