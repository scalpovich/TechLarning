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
	private MCWebElement networkDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "terminalId:input:inputTextField")
	private MCWebElement txtTerminalID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "merchantId:input:inputTextField")
	private MCWebElement txtMerchantID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcc:input:inputTextField")
	private MCWebElement txtMCC;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquiringCountryCode:input:inputTextField")
	private MCWebElement txtAcquiringCountryCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "acquirerId:input:inputTextField")
	private MCWebElement txtAcquirerID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCurrency:input:inputTextField")
	private MCWebElement txtTransactionCurrency;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardholderPresenceIndicator:input:dropdowncomponent")
	private MCWebElement cardholderPresenceIndicatorDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardPresenceIndicator:input:dropdowncomponent")
	private MCWebElement cardPresenceIndicatorDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "pOSEntryMode:input:dropdowncomponent")
	private MCWebElement POSEntryModeDDwn;

	public static final String TERMINAL_ID = "Terminal Id";
	public static final String MERCHANT_ID = "Merchant Id";
	private static final String ROW_COUNT = "//*[@class='dataview']/tbody[1]//tr";

	private void selectNetwork(String network){
		WebElementUtils.selectDDByVisibleText(networkDDwn, network);
	}

	private void selectProduct(String productType){
		WebElementUtils.selectDDByVisibleText(productTypeDDwn, productType);
	}

	private void enterTerminalID(String terminalID){
		WebElementUtils.enterText(txtTerminalID, terminalID);
	}

	private void enterMerchantID(String merchantID){
		WebElementUtils.enterText(txtMerchantID, merchantID);
	}

	private void enterMCC(String MCC){
		WebElementUtils.enterText(txtMCC, MCC);
	}

	private void enterAcquiringCountryCode(String acquiringCountryCode){
		WebElementUtils.enterText(txtAcquiringCountryCode, acquiringCountryCode);
	}

	private void enterAcquirerID(String acquirerID){
		WebElementUtils.enterText(txtAcquirerID, acquirerID);
	}

	private void enterTransactionCurrency(String transactionCurrency){
		WebElementUtils.enterText(txtTransactionCurrency, transactionCurrency);
	}

	private void selectCardholderPresenceIndicator(String cardholderPresenceIndicator){
		WebElementUtils.selectDDByVisibleText(cardholderPresenceIndicatorDDwn, cardholderPresenceIndicator);
	}

	private void selectPOSEntryMode(String POSEntryMode){
		WebElementUtils.selectDDByVisibleText(POSEntryModeDDwn, POSEntryMode);
	}

	private void selectCardPresenceIndicator(String cardPresenceIndicator){
		WebElementUtils.selectDDByVisibleText(cardPresenceIndicatorDDwn, cardPresenceIndicator);
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